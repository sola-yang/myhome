package tyf.yhy.family.mapper;

import tyf.yhy.base.mapper.BaseMapper;
import tyf.yhy.familyshare.entity.FamilyShare;

/**
* @author:sola
* @version:1.0 create time：2017年11月7日
*
* 
*/
public interface FamilyShareMapper extends BaseMapper<FamilyShare>{
	int deleteByShareId(String shareId);
}
