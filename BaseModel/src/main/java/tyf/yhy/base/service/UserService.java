package tyf.yhy.base.service;

import tyf.yhy.usermanager.entity.User;

/**
* @author:sola
* @version:1.0 create time：2017年10月27日
*
* 
*/
public interface UserService extends BaseService<User> {
	public User getUser(String userId);
}
