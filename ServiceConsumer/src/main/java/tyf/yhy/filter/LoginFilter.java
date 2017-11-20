package tyf.yhy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tyf.yhy.util.LoginContext;

/**
* @author:sola
* @version:1.0 create time£º2017Äê11ÔÂ1ÈÕ
*
* 
*/
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		if(request.getRequestURI().endsWith("/system/login")||request.getRequestURI().endsWith("/system/addData")||request.getRequestURI().endsWith("/system/register")){
			arg2.doFilter(arg0, arg1);
		}else if(!LoginContext.checkLogin(request.getSession())&&!request.getRequestURI().contains(".")){
			response.sendRedirect(request.getContextPath()+"/system/login");
		}else {
			arg2.doFilter(arg0, arg1);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
