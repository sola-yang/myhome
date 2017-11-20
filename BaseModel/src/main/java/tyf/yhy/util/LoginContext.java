package tyf.yhy.util;

import javax.servlet.http.HttpSession;

import tyf.yhy.usermanager.entity.User;

/**
* @author:sola
* @version:1.0 create time：2017年10月31日
*
* 
*/
public final class LoginContext {
	 public final static String USER_SESSION_KEY="userSessionKey";
	 public final static String LOGIN_SESSION_KEY="loginUserMap";
     private final static ThreadLocal<LoginUser> LOCAL=new ThreadLocal<LoginUser>(){
 		@Override
 		protected LoginUser initialValue() {
 			return null;
 		}
 	};
	public static boolean checkLogin(HttpSession session){
		if(session==null){
			return false;
		}
		LoginUser loginUser=(LoginUser)session.getAttribute(USER_SESSION_KEY);
		if(loginUser==null){
			return false;
		}else{
			setLocal(loginUser);
			return true;
		}
		
	}
	public static void setLocal(LoginUser loginUser){
		LOCAL.set(loginUser);
	}
	public static LoginUser getLoginUser(){
		return LOCAL.get();
	}
	public static void login(User user,HttpSession session){
		if(user==null){
			return;
		}
		LoginUser loginUser=new LoginUser();
		loginUser.setUser(user);
		session.setAttribute(USER_SESSION_KEY,loginUser);
		loginUser.setSession(session);
		setLocal(loginUser);
	}
	public static void logout(){
		LOCAL.remove();
	}
	public static class LoginUser{
		private User user;
		private HttpSession session;
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public HttpSession getSession() {
			return session;
		}
		public void setSession(HttpSession session) {
			this.session = session;
		}
		
	}
}
