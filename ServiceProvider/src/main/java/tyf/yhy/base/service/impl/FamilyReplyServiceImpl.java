package tyf.yhy.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import tyf.yhy.base.entity.Paginator;
import tyf.yhy.base.service.FamilyReplyService;
import tyf.yhy.family.mapper.FamilyReplyMapper;
import tyf.yhy.familyshare.entity.FamilyReply;

/**
* @author:sola
* @version:1.0 create time：2017年11月8日
*
* 
*/
@Service("familyReolyService")
public class FamilyReplyServiceImpl implements FamilyReplyService {

	@Resource
	private FamilyReplyMapper familyReplyMapper;
	@Override
	public FamilyReply get(int id) {
		// TODO Auto-generated method stub
		return familyReplyMapper.selectById(id);
	}

	@Override
	public int save(FamilyReply t) {
		// TODO Auto-generated method stub
		return familyReplyMapper.insert(t);
	}

	@Override
	public int update(FamilyReply t) {
		// TODO Auto-generated method stub
		return familyReplyMapper.update(t);
	}

	@Override
	public int saveOrUpdate(FamilyReply t) {
		// TODO Auto-generated method stub
		return t.getId()!=null&&t.getId().intValue()>1?this.update(t):this.save(t);
	}

	@Override
	public List<FamilyReply> getAll() {
		// TODO Auto-generated method stub
		return familyReplyMapper.selectAll();
	}

	@Override
	public List<FamilyReply> getByCondition(Paginator<FamilyReply> page) {
		// TODO Auto-generated method stub
		return familyReplyMapper.select(page);
	}

	@Override
	public int deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		return familyReplyMapper.delete(ids);
	}

	@Override
	public int deleteByReplyId(String replyId) {
		// TODO Auto-generated method stub
		return familyReplyMapper.deleteByReplyId(replyId);
	}

}
