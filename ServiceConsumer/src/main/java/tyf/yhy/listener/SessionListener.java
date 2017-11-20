package tyf.yhy.listener;

import java.util.Map;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import tyf.yhy.util.LoginContext;
import tyf.yhy.util.LoginContext.LoginUser;

/**
* @author:sola
* @version:1.0 create time£º2017Äê11ÔÂ1ÈÕ
*
* 
*/
public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		LoginUser loginUser=(LoginUser)arg0.getSession().getAttribute(LoginContext.USER_SESSION_KEY);
		if(loginUser!=null){
			Map<String,String> loginUserMap=(Map<String,String>)arg0.getSession().getServletContext().getAttribute(LoginContext.LOGIN_SESSION_KEY);
			loginUserMap.remove(loginUser.getUser().getUserId());
			arg0.getSession().getServletContext().setAttribute(LoginContext.LOGIN_SESSION_KEY, loginUserMap);
		}
	}

}
