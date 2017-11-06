package tyf.yhy.user.mapper;

import tyf.yhy.base.mapper.BaseMapper;
import tyf.yhy.usermanager.entity.User;

/**
* @author:sola
* @version:1.0 create time：2017年10月27日
*
* 
*/
public interface UserMapper extends BaseMapper<User> {
         User selectByUserId(String userId);
}
