package tyf.yhy.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import tyf.yhy.base.entity.Paginator;
import tyf.yhy.base.service.UserService;
import tyf.yhy.user.mapper.UserMapper;
import tyf.yhy.usermanager.entity.User;

/**
* @author:sola
* @version:1.0 create time：2017年10月27日
*
* 
*/
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return userMapper.selectById(id);
	}

	@Override
	public int save(User t) {
		// TODO Auto-generated method stub
		return userMapper.insert(t);
	}

	@Override
	public int update(User t) {
		// TODO Auto-generated method stub
		return userMapper.update(t);
	}

	@Override
	public int saveOrUpdate(User t) {
		return t.getId()!=null&&t.getId().intValue()>1?this.update(t):this.save(t);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userMapper.selectAll();
	}

	@Override
	public List<User> getByCondition(Paginator<User> page) {
		// TODO Auto-generated method stub
		return userMapper.select(page);
	}

	@Override
	public int deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		return userMapper.delete(ids);
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		return userMapper.selectByUserId(userId);
	}



}
