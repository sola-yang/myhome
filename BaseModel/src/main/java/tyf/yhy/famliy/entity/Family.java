package tyf.yhy.famliy.entity;

import java.io.Serializable;

import tyf.yhy.base.entity.Id;

/**
* @author:sola
* @version:1.0 create time：2017年11月1日
*
* 
*/
public class Family extends Id implements Serializable{
      /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  private String familyId;
      private String familyName;
      private String familyMotto;
      private String pFamilyId1;
      private String pFamilyId2;
      private String familyPictureSrc;
	public String getFamilyPictureSrc() {
		return familyPictureSrc;
	}
	public void setFamilyPictureSrc(String familyPictureSrc) {
		this.familyPictureSrc = familyPictureSrc;
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
      
}
