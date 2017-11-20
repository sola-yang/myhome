package tyf.yhy.base.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import tyf.yhy.base.entity.Paginator;
import tyf.yhy.base.service.FamilyMemberService;
import tyf.yhy.family.mapper.FamilyMemberMapper;
import tyf.yhy.famliy.entity.FamilyMember;

/**
* @author:sola
* @version:1.0 create time：2017年11月2日
*
* 
*/
@Service("familyMemberService")
public class FamilyMemberServiceImpl implements FamilyMemberService {
    @Resource
    FamilyMemberMapper familyMemberMapper;
	@Override
	public FamilyMember get(int id) {
		// TODO Auto-generated method stub
		return familyMemberMapper.selectById(id);
	}

	@Override
	public int save(FamilyMember t) {
		// TODO Auto-generated method stub
		return familyMemberMapper.insert(t);
	}

	@Override
	public int update(FamilyMember t) {
		// TODO Auto-generated method stub
		return familyMemberMapper.update(t);
	}

	@Override
	public int saveOrUpdate(FamilyMember t) {
		// TODO Auto-generated method stub
		return t.getId()!=null&&t.getId().intValue()>1?this.update(t):this.save(t);
	}

	@Override
	public List<FamilyMember> getAll() {
		// TODO Auto-generated method stub
		return familyMemberMapper.selectAll();
	}

	@Override
	public List<FamilyMember> getByCondition(Paginator<FamilyMember> page) {
		// TODO Auto-generated method stub
		return familyMemberMapper.select(page);
	}

	@Override
	public int deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		return familyMemberMapper.delete(ids);
	}

	@Override
	public FamilyMember getFamilyMember(String familyMember) {
		// TODO Auto-generated method stub
		return familyMemberMapper.selectByFamilyMember(familyMember);
	}

	@Override
	public FamilyMember getSuperPFamilyIdByFamilyMember(String familyMember) {
		// TODO Auto-generated method stub
		return familyMemberMapper.selectSuperPFamilyIdByFamilyMember(familyMember);
	}


}
