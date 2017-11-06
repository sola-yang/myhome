package tyf.yhy.family.mapper;

import tyf.yhy.base.mapper.BaseMapper;
import tyf.yhy.famliy.entity.Family;

/**
* @author:sola
* @version:1.0 create time：2017年10月27日
*
* 
*/
public interface FamilyMapper extends BaseMapper<Family> {
	Family selectByFamilyId(String familyId);
}
