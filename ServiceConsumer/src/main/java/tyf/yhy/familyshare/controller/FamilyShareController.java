package tyf.yhy.familyshare.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
import tyf.yhy.base.entity.Paginator;
import tyf.yhy.base.service.FamilyMemberService;
import tyf.yhy.base.service.FamilyShareService;
import tyf.yhy.familyshare.entity.FamilyShare;
import tyf.yhy.famliy.entity.FamilyMember;
import tyf.yhy.util.LoginContext;

/**
* @author:sola
* @version:1.0 create time£º2017Äê11ÔÂ8ÈÕ
*
* 
*/
@Controller
@RequestMapping("/familyshare")
public class FamilyShareController extends CDUContentController<FamilyShare, FamilyShareService, FamilyShareController.FamilyShareForm> {

	@Resource
	private void setFamilyShareService(FamilyShareService familyShareService){
		this.service=familyShareService;
	} 
	@Resource
	private FamilyMemberService familyMemberService;
	public FamilyShareController() {
		super("familyshare");
		// TODO Auto-generated constructor stub
	}
    @Override
    protected boolean preShow(int page, Paginator<FamilyShare> paginator, FamilyShare query, Model model,
		HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
    	FamilyMember familyMember=familyMemberService.getSuperPFamilyIdByFamilyMember(LoginContext.getLoginUser().getUser().getUserId());
    	if(familyMember==null||familyMember.getSuperPFamilyId()==null){
    		query.setFamilyId("");
    	}else{
    		query.setFamilyId(familyMember.getSuperPFamilyId());
    	}
		return super.preShow(page, paginator, query, model, request, response);
    }
	@Override
	protected void toSave(FamilyShareForm form, BindingResult errors, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String userId=LoginContext.getLoginUser().getUser().getUserId();
		String shareId=DateTime.now().toString("yyyyMMddHHmmssSSS")+userId;
		form.setShareId(shareId);
		MultipartFile files[]=form.getFiles();
		FamilyMember familyMember=familyMemberService.getSuperPFamilyIdByFamilyMember(userId);
		try {
			String filePath=request.getSession().getServletContext().getRealPath("/image/"+shareId+"/");
			if(!isEmptyOfMultipartFile(files)){
				File file=new File(filePath);
				file.mkdirs();
				saveFiles(files,filePath);
				form.setShareSrc(files.length+"");
			}
			
		} catch (Exception e) {
			errors.addError(new ObjectError("errors", "please try again later!"));
			e.printStackTrace();
			return;
		}
		form.setFamilyId(familyMember.getSuperPFamilyId());
		form.setUserId(userId);
		this.service.saveOrUpdate(form.toObj());
	}
 	public static void saveFile(MultipartFile file,String filePath){
 		if (!file.isEmpty()) {  
	 		try {
	 			File newFile=new File(filePath);
	 			if(!newFile.exists()){
	 				newFile.createNewFile();
	 			}
	 	       
				file.transferTo(newFile);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}
	}
 	public static boolean isEmptyOfMultipartFile(MultipartFile files[]){
 		if(files.length<0){
 			return true;
 		}else if(files.length==1&&(files[0]==null||files[0].isEmpty())){
 			return true;
 		}else{
 			return false;
 		}
 	}
 	public static void saveFiles(MultipartFile files[],String filePath){
 		  if(files!=null&&files.length>0){  
 	            for(int i = 0;i<files.length;i++){  
 	                MultipartFile file = files[i];
 	                if (file==null||file.isEmpty()) {
						continue;
					}
 	                String newpath="";
 	                newpath=filePath+(i+".png");
 	               saveFile(file,newpath);  
 	            }  
 	        } 
	}
	public static class FamilyShareForm extends IdForm<FamilyShare>{
		  private String shareId;
		  private String userId;
	      private String shareContent;
	      private String shareSrc;
	      private String familyId;
	      public String getUserId() {
	    	  return userId;
	      }
	      
	      public void setUserId(String userId) {
	    	  this.userId = userId;
	      }
	      public String getFamilyId() {
			return familyId;
		}

		public void setFamilyId(String familyId) {
			this.familyId = familyId;
		}

		private MultipartFile[] files;

		public MultipartFile[] getFiles() {
			return files;
		}

		public void setFiles(MultipartFile[] files) {
			this.files = files;
		}

		public String getShareId() {
			return shareId;
		}

		public void setShareId(String shareId) {
			this.shareId = shareId;
		}

		public String getShareContent() {
			return shareContent;
		}

		public void setShareContent(String shareContent) {
			this.shareContent = shareContent;
		}

		public String getShareSrc() {
			return shareSrc;
		}

		public void setShareSrc(String shareSrc) {
			this.shareSrc = shareSrc;
		}

		@Override
		public FamilyShare newObj() {
			// TODO Auto-generated method stub
			return new FamilyShare();
		}

		@Override
		public void populateObj(FamilyShare t) {
			// TODO Auto-generated method stub
			t.setShareId(shareId);
			t.setShareContent(shareContent);
			t.setShareSrc(shareSrc);
			t.setFamilyId(familyId);
			t.setUserId(userId);
			t.setTimeCreate(DateTime.now().toString("yyyy-MM-dd HH:mm:ss:SSS"));
		}
		
	}
}
