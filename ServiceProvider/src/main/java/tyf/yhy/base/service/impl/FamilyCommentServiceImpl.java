package tyf.yhy.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import tyf.yhy.base.entity.Paginator;
import tyf.yhy.family.mapper.FamilyCommentMapper;
import tyf.yhy.familyshare.entity.FamilyComment;

/**
* @author:sola
* @version:1.0 create time：2017年11月8日
*
* 
*/
@Service("familyCommentService")
public class FamilyCommentServiceImpl implements tyf.yhy.base.service.FamilyCommentService {

	@Resource
	private FamilyCommentMapper familyCommentMapper;
	
	@Override
	public FamilyComment get(int id) {
		// TODO Auto-generated method stub
		return familyCommentMapper.selectById(id);
	}

	@Override
	public int save(FamilyComment t) {
		// TODO Auto-generated method stub
		return familyCommentMapper.insert(t);
	}

	@Override
	public int update(FamilyComment t) {
		// TODO Auto-generated method stub
		return familyCommentMapper.update(t);
	}

	@Override
	public int saveOrUpdate(FamilyComment t) {
		// TODO Auto-generated method stub
		return t.getId()!=null&&t.getId().intValue()>1?this.update(t):this.save(t);
	}

	@Override
	public List<FamilyComment> getAll() {
		// TODO Auto-generated method stub
		return familyCommentMapper.selectAll();
	}

	@Override
	public List<FamilyComment> getByCondition(Paginator<FamilyComment> page) {
		// TODO Auto-generated method stub
		return familyCommentMapper.select(page);
	}

	@Override
	public int deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		return familyCommentMapper.delete(ids);
	}

	@Override
	public int deleteByCommentId(String commentId) {
		// TODO Auto-generated method stub
		return familyCommentMapper.deleteByCommentId(commentId);
	}

}
