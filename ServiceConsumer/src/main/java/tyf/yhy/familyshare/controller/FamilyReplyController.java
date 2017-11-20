package tyf.yhy.familyshare.controller;

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
import tyf.yhy.base.service.FamilyReplyService;
import tyf.yhy.familyshare.entity.FamilyReply;
import tyf.yhy.util.LoginContext;

/**
* @author:sola
* @version:1.0 create time£º2017Äê11ÔÂ16ÈÕ
*
* 
*/
@Controller
@RequestMapping("/familyreply")
public class FamilyReplyController extends CDUContentController<FamilyReply, FamilyReplyService, FamilyReplyController.FamilyReplyForm>{

	public FamilyReplyController() {
		super("familyreply");
		// TODO Auto-generated constructor stub
	}
	@Resource
	public void setFamilyReplyService(FamilyReplyService familyReplyService){
		this.service=familyReplyService;
	}
	@RequestMapping("/savereply")
	public @ResponseBody  String saveReply(FamilyReplyForm form, BindingResult errors, Model model, HttpServletRequest request,
			HttpServletResponse response){
	      this.service.save(form.toObj());
	      return "success";
	}
 public static class FamilyReplyForm extends IdForm<FamilyReply>{
	private String commentId;
	private String replyContent;
	private String toUser;
	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	@Override
	public FamilyReply newObj() {
		// TODO Auto-generated method stub
		return new FamilyReply();
	}

	@Override
	public void populateObj(FamilyReply t) {
		String userId=LoginContext.getLoginUser().getUser().getUserId();
		t.setCommentId(commentId);
		t.setToUser(toUser);
		t.setReplyContent(replyContent);
		t.setFromUser(userId);
		t.setReplyId(DateTime.now().toString("yyyyMMddHHssSSS")+userId);
	}
	 
 }
}
