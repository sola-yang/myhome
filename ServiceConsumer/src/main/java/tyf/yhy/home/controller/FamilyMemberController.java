package tyf.yhy.home.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import tyf.yhy.base.controller.CDUContentController;
import tyf.yhy.base.entity.IdForm;
import tyf.yhy.base.entity.Query;
import tyf.yhy.base.service.FamilyMemberService;
import tyf.yhy.base.service.FamilyService;
import tyf.yhy.famliy.entity.Family;
import tyf.yhy.famliy.entity.FamilyMember;
import tyf.yhy.util.ConfigContext;
import tyf.yhy.util.LoginContext;

/**
* @author:sola
* @version:1.0 create time£º2017Äê11ÔÂ3ÈÕ
*
* 
*/
@Controller
@RequestMapping("/familymember")
public class FamilyMemberController extends CDUContentController<FamilyMember,FamilyMemberService, FamilyMemberController.FamilyMemberForm> {

	public FamilyMemberController() {
		super("familymember");
	}
	@Resource
	private FamilyService familyService;
	@Resource
	public void setFamilyMemberService(FamilyMemberService familyMemberService){
		this.service=familyMemberService;
	}
	@Override
	protected void postAddData(Model model) {
		model.addAttribute("familyRoleMap", ConfigContext.familyRoleMap);
	}
	@Override
	protected void toSave(FamilyMemberForm form, BindingResult errors, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		FamilyMember familyMember=form.toObj();
		Family family =familyService.getFamily(LoginContext.getLoginUser().getUser().getUserId());
		if(familyMember.getFamilyMemberRole()!='2'){
			familyService.updatePFamilyId(familyMember.getFamilyMember(),family.getFamilyId());
		}
		familyMember.setFamilyId(family.getFamilyId());
		familyMember.setSuperPFamilyId(family.getSuperPFamilyId());
		this.service.saveOrUpdate(familyMember);
		
	}
	@Override
	protected String toShow(int page, FamilyMember query, BindingResult errors, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		query.setFamilyId(LoginContext.getLoginUser().getUser().getUserId());
		model.addAttribute("familyRoleMap", ConfigContext.familyRoleMap);
		return super.toShow(page, query, errors, model, request, response);
	}
	@Override
	protected void postupdateData(int id, FamilyMember obj, Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("familyRoleMap", ConfigContext.familyRoleMap);
		super.postupdateData(id, obj, model);
	}
	public static class FamilyMemberForm extends IdForm<FamilyMember>{
		private String familyMember;
		private String familyId;
		private char familyMemberRole;
		private String superPFamilyId;
		public String getSuperPFamilyId() {
			return superPFamilyId;
		}

		public void setSuperPFamilyId(String superPFamilyId) {
			this.superPFamilyId = superPFamilyId;
		}

		public String getFamilyMember() {
			return familyMember;
		}

		public void setFamilyMember(String familyMember) {
			this.familyMember = familyMember;
		}

		public String getFamilyId() {
			return familyId;
		}

		public void setFamilyId(String familyId) {
			this.familyId = familyId;
		}

		public char getFamilyMemberRole() {
			return familyMemberRole;
		}

		public void setFamilyMemberRole(char familyMemberRole) {
			this.familyMemberRole = familyMemberRole;
		}

		@Override
		public FamilyMember newObj() {
			// TODO Auto-generated method stub
			return new FamilyMember();
		}

		@Override
		public void populateObj(FamilyMember t) {
			// TODO Auto-generated method stub
			t.setFamilyId(familyId);
			t.setFamilyMember(familyMember);
			t.setFamilyMemberRole(familyMemberRole);
			t.setSuperPFamilyId(superPFamilyId);
		}
		
	}

}
