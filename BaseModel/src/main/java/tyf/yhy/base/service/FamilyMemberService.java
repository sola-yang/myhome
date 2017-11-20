package tyf.yhy.base.service;

import tyf.yhy.famliy.entity.FamilyMember;

/**
* @author:sola
* @version:1.0 create time：2017年11月2日
*
* 
*/
public interface FamilyMemberService extends BaseService<FamilyMember> {
       public FamilyMember getFamilyMember(String familyMember);
       public FamilyMember getSuperPFamilyIdByFamilyMember(String familyMember);
       
}
