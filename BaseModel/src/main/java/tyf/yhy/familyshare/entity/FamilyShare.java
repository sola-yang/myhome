package tyf.yhy.familyshare.entity;


import java.util.List;

import tyf.yhy.base.entity.Id;

/**
* @author:sola
* @version:1.0 create time：2017年11月1日
*
* 
*/
public class FamilyShare extends Id{
      /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	  private String shareId;
	  private String userId;
	  private String shareContent;
      private String shareSrc;
      private String familyId;
	  private List<FamilyComment> comment;
	  
	  public String getUserId() {
	 		return userId;
	 	}
	 	public void setUserId(String userId) {
	 		this.userId = userId;
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
	  public String getFamilyId() {
			return familyId;
		}
	  public void setFamilyId(String familyId) {
			this.familyId = familyId;
		}
	  public List<FamilyComment> getComment() {
				return comment;
			}
		public void setComment(List<FamilyComment> comment) {
				this.comment = comment;
			}
}
