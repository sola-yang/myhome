package tyf.yhy.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import tyf.yhy.base.entity.Paginator;
import tyf.yhy.base.service.FamilyService;
import tyf.yhy.family.mapper.FamilyMapper;
import tyf.yhy.famliy.entity.Family;

/**
* @author:sola
* @version:1.0 create time：2017年10月27日
*
* 
*/
@Service("familyService")
public class FamilyServiceImpl implements FamilyService {

	@Resource
	private FamilyMapper familyMapper;

	@Override
	public Family get(int id) {
		// TODO Auto-generated method stub
		return familyMapper.selectById(id);
	}

	@Override
	public int save(Family t) {
		// TODO Auto-generated method stub
		return familyMapper.insert(t);
	}

	@Override
	public int update(Family t) {
		// TODO Auto-generated method stub
		return familyMapper.update(t);
	}

	@Override
	public int saveOrUpdate(Family t) {
		return t.getId()!=null&&t.getId().intValue()>1?this.update(t):this.save(t);
	}

	@Override
	public Family getFamily(String familyId) {
		// TODO Auto-generated method stub
		return familyMapper.selectByFamilyId(familyId);
	}

	@Override
	public List<Family> getAll() {
		// TODO Auto-generated method stub
		return familyMapper.selectAll();
	}

	@Override
	public List<Family> getByCondition(Paginator page) {
		// TODO Auto-generated method stub
		return familyMapper.select(page);
	}

	@Override
	public int deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		return familyMapper.delete(ids);
	}



}
