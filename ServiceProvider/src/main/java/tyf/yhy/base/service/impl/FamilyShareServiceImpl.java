package tyf.yhy.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import tyf.yhy.base.entity.Paginator;
import tyf.yhy.base.service.FamilyShareService;
import tyf.yhy.family.mapper.FamilyShareMapper;
import tyf.yhy.familyshare.entity.FamilyShare;

/**
* @author:sola
* @version:1.0 create time：2017年11月8日
*
* 
*/
@Service("familyShareService")
public class FamilyShareServiceImpl implements FamilyShareService {

	@Resource
	private FamilyShareMapper familyShareMapper;
	@Override
	public FamilyShare get(int id) {
		// TODO Auto-generated method stub
		return familyShareMapper.selectById(id);
	}

	@Override
	public int save(FamilyShare t) {
		// TODO Auto-generated method stub
		return familyShareMapper.insert(t);
	}

	@Override
	public int update(FamilyShare t) {
		// TODO Auto-generated method stub
		return familyShareMapper.update(t);
	}

	@Override
	public int saveOrUpdate(FamilyShare t) {
		// TODO Auto-generated method stub
		return t.getId()!=null&&t.getId().intValue()>1?this.update(t):this.save(t);
	}

	@Override
	public List<FamilyShare> getAll() {
		// TODO Auto-generated method stub
		return familyShareMapper.selectAll();
	}

	@Override
	public List<FamilyShare> getByCondition(Paginator<FamilyShare> page) {
		// TODO Auto-generated method stub
		return familyShareMapper.select(page);
	}

	@Override
	public int deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		return familyShareMapper.delete(ids);
	}

	@Override
	public int deleteByShareId(String shareId) {
		// TODO Auto-generated method stub
		return familyShareMapper.deleteByShareId(shareId);
	}

}
