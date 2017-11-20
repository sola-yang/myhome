package tyf.yhy.familyshare.entity;

import java.util.List;

import tyf.yhy.base.entity.Id;

/**
* @author:sola
* @version:1.0 create time：2017年11月2日
*
* 
*/
public class FamilyComment extends Id {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   
	private String commentId;
	private String shareId;
	private String commentContent;
	private String userId;
	private List<FamilyReply> reply;
	public List<FamilyReply> getReply() {
		return reply;
	}
	public void setReply(List<FamilyReply> reply) {
		this.reply = reply;
	}
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
