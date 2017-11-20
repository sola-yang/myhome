package tyf.yhy.familyshare.entity;


import tyf.yhy.base.entity.Id;

/**
* @author:sola
* @version:1.0 create time：2017年11月2日
*
* 
*/
public class FamilyReply extends Id {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   
	private String replyId;
	private String commentId;
	private String replyContent;
	private String fromUser;
	private String toUser;
	public String getReplyId() {
		return replyId;
	}
	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}
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
	public String getFromUser() {
		return fromUser;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	
}
