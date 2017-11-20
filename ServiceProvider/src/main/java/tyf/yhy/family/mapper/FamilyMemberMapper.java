package tyf.yhy.family.mapper;

import tyf.yhy.base.mapper.BaseMapper;
import tyf.yhy.famliy.entity.FamilyMember;

/**
* @author:sola
* @version:1.0 create time：2017年10月27日
*
* 
*/

public interface FamilyMemberMapper extends BaseMapper<FamilyMember> {
	public FamilyMember selectByFamilyMember(String familyMember);
	public FamilyMember selectSuperPFamilyIdByFamilyMember(String familyMember);
}
