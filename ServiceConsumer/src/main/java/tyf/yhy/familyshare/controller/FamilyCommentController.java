package tyf.yhy.familyshare.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tyf.yhy.base.controller.CDUContentController;
import tyf.yhy.base.entity.IdForm;
import tyf.yhy.base.service.FamilyCommentService;
import tyf.yhy.familyshare.entity.FamilyComment;
import tyf.yhy.util.LoginContext;

/**
* @author:sola
* @version:1.0 create time£º2017Äê11ÔÂ10ÈÕ
 * @param <F>
*
* 
*/
@Controller
@RequestMapping("/familycomment")
public class FamilyCommentController extends CDUContentController<FamilyComment, FamilyCommentService,FamilyCommentController.FamilyCommentForm> {

	public FamilyCommentController() {
		super("familycomment");
		// TODO Auto-generated constructor stub
	}
	@Resource
	public void setFamilyCommentService(FamilyCommentService familyCommentService){
		this.service=familyCommentService;
	}
	@Override
	protected void toSave(FamilyCommentForm form, BindingResult errors, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		this.service.save(form.toObj());
	}
	@RequestMapping("/savecomment")
	public @ResponseBody  String saveComment(FamilyCommentForm form, BindingResult errors, Model model, HttpServletRequest request,
			HttpServletResponse response){
	      this.service.save(form.toObj());
	      return "success";
	}
   public static class FamilyCommentForm extends IdForm<FamilyComment>{
		private String shareId;
		private String commentContent;
		public String getShareId() {
			return shareId;
		}

		public void setShareId(String shareId) {
			this.shareId = shareId;
		}

		public String getCommentContent() {
			return commentContent;
		}

		public void setCommentContent(String commentContent) {
			this.commentContent = commentContent;
		}


		@Override
		public FamilyComment newObj() {
			// TODO Auto-generated method stub
			return new FamilyComment();
		}
	
		@Override
		public void populateObj(FamilyComment t) {
			// TODO Auto-generated method stub
			t.setCommentContent(commentContent);
			t.setShareId(shareId);
			String userId=LoginContext.getLoginUser().getUser().getUserId();
			t.setCommentId(DateTime.now().toString("yyyyMMddHHssSSS")+userId);
			t.setUserId(userId);
			t.setTimeCreate(DateTime.now().toString("yyyy-MM-dd HH:ss:SSS"));
		}
	   
   }
}
