package tyf.yhy.famliy.entity;

import tyf.yhy.base.entity.Id;

/**
* @author:sola
* @version:1.0 create time：2017年11月2日
*
* 
*/
public class FamilyMember extends Id {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   
	private String familyMember;
	private String familyId;
	private Integer familyMemberRole;//0 represent father 1 represent mother 2 represent child
	public Integer getFamilyMemberRole() {
		return familyMemberRole;
	}
	public void setFamilyMemberRole(Integer familyMemberRole) {
		this.familyMemberRole = familyMemberRole;
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
	
}
