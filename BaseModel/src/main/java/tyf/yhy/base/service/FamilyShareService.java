package tyf.yhy.base.service;

import tyf.yhy.familyshare.entity.FamilyShare;

/**
* @author:sola
* @version:1.0 create time：2017年11月7日
*
* 
*/
public interface FamilyShareService extends BaseService<FamilyShare> {
     int deleteByShareId(String shareId);
}
