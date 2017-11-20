package tyf.yhy.base.service;

import java.util.List;

import tyf.yhy.famliy.entity.Family;

/**
* @author:sola
* @version:1.0 create time：2017年11月01日
*
* 
*/
public interface FamilyService extends BaseService<Family> {
	public Family getFamily(String familyId);
	public List<Family> getFamilyPicture(String userId);
	int updatePFamilyId(String pFamilyId,String familyId);
}
