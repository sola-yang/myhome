package tyf.yhy.home.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import tyf.yhy.base.controller.CDUContentController;
import tyf.yhy.base.entity.IdForm;
import tyf.yhy.base.entity.Query;
import tyf.yhy.base.service.FamilyMemberService;
import tyf.yhy.base.service.FamilyService;
import tyf.yhy.famliy.entity.Family;
import tyf.yhy.famliy.entity.FamilyMember;
import tyf.yhy.util.LoginContext;

/**
* @author:sola
* @version:1.0 create time£º2017Äê11ÔÂ1ÈÕ
*
* 
*/
@Controller
@RequestMapping("/family")
public class FamilyController extends CDUContentController<Family,FamilyService, FamilyController.FamilyForm, FamilyController.FamilyQuery> {

	public FamilyController() {
		super("family");
		
		// TODO Auto-generated constructor stub
	}
	@Resource
	private FamilyMemberService familyMemberService;
	@Resource
	public void setFamilyService (FamilyService familyService){
		this.service=familyService;
	}
	@Override
	protected void toSave(FamilyForm form, BindingResult errors, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		Family family=form.toObj();
		family.setFamilyId(LoginContext.getLoginUser().getUser().getUserId());
		FamilyMember member=familyMemberService.getFamilyMember(family.getFamilyId());
		if(form.getFile()!=null&&form.getFile().getOriginalFilename()!=null&&!form.getFile().getOriginalFilename().trim().equals("")){
			String filePath="/image/family/"+form.getFile().getOriginalFilename();
			saveFile(form.getFile(),request.getRealPath(filePath));
			family.setFamilyPictureSrc(filePath);
		}
		family.setpFamilyId1(member.getFamilyId()==null?"":member.getFamilyId());
		this.service.saveOrUpdate(family);
		
	}
	public static class FamilyQuery extends Query{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
	}
	
	public static void saveFile(MultipartFile file,String filePath){
		if(file!=null){
			InputStream input=null;
			OutputStream out=null;
			File fielPath=new File(filePath);
			try {
				if(!fielPath.exists()){
					fielPath.createNewFile();
				}
				input=file.getInputStream();
				out=new FileOutputStream(fielPath);
				byte b[]=new byte[input.available()];
				input.read(b);
				out.write(b);
				out.flush();
			} catch (IOException e) {
			}finally {
					try {
						if(out!=null){
							out.close();
						}
						if(input!=null){
							input.close();
						}
					} catch (IOException e) {
					}
			}
		}
	}
	public static class FamilyForm extends IdForm<Family>{
	    private String familyId;
	    private String familyName;
	    private String familyMotto;
	    private String pFamilyId1;
	    private String pFamilyId2;
	    private MultipartFile file;
		public MultipartFile getFile() {
			return file;
		}

		public void setFile(MultipartFile file) {
			this.file = file;
		}

		public String getFamilyId() {
			return familyId;
		}

		public void setFamilyId(String familyId) {
			this.familyId = familyId;
		}

		public String getFamilyName() {
			return familyName;
		}

		public void setFamilyName(String familyName) {
			this.familyName = familyName;
		}

		public String getFamilyMotto() {
			return familyMotto;
		}

		public void setFamilyMotto(String familyMotto) {
			this.familyMotto = familyMotto;
		}

		public String getpFamilyId1() {
			return pFamilyId1;
		}

		public void setpFamilyId1(String pFamilyId1) {
			this.pFamilyId1 = pFamilyId1;
		}

		public String getpFamilyId2() {
			return pFamilyId2;
		}

		public void setpFamilyId2(String pFamilyId2) {
			this.pFamilyId2 = pFamilyId2;
		}

		@Override
		public Family newObj() {
			// TODO Auto-generated method stub
			return new Family();
		}

		@Override
		public void populateObj(Family family) {
			family.setFamilyId(familyId);
			family.setFamilyName(familyName);
			family.setFamilyMotto(familyMotto);
			family.setpFamilyId1(pFamilyId1);
			family.setpFamilyId2(pFamilyId2);
			family.setTimeCreate(DateTime.now().toString("yyyy-MM-dd HH:mm:ss:SSS"));
			family.setTimeModifed(DateTime.now().toString("yyyy-MM-dd HH:mm:ss:SSS"));
		}
		
	}
}
