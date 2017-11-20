package tyf.yhy.home.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import tyf.yhy.base.controller.CDUContentController;
import tyf.yhy.base.entity.IdForm;
import tyf.yhy.base.entity.Query;
import tyf.yhy.base.service.BaseService;
import tyf.yhy.usermanager.entity.User;
import tyf.yhy.util.SecurityUtils;

/**
* @author:sola
* @version:1.0 create time£º2017Äê10ÔÂ30ÈÕ
*
* 
*/
@Controller()
@RequestMapping("/myhome")
public class UserController extends CDUContentController<User, BaseService<User>,UserController.UserForm>{

	public UserController() {
		super("myhome");
	}
    
	@Override
	protected void toSave(UserForm form, BindingResult errors, Model model, HttpServletRequest request,
			HttpServletResponse response) {
	}
	@RequestMapping("/home")
	protected String myhome(){
		return "/myhome/myhome";
	}
	@RequestMapping("/myplace")
	protected String myplace(){
		return "/myhome/myplace";
	}
	@RequestMapping("/homemember")
	protected String homemember(){
		return "/myhome/homemember";
	}
	@RequestMapping("/homemanagement")
	protected String homemanagement(){
		return "/myhome/homemanagement";
	}
	@RequestMapping("/hometree")
	protected String hometree(){
		return "/myhome/hometree";
	}
	public static class UserForm extends IdForm<User>{
		private String userId;
		private String userName;
		private char sex;//0 represent man 1 represent woman
		private String password;
		private String phoneNum;
		private String address;
		private String email;
		private String qqCount;
		private String weChartCount;
		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public char getSex() {
			return sex;
		}

		public void setSex(char sex) {
			this.sex = sex;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPhoneNum() {
			return phoneNum;
		}

		public void setPhoneNum(String phoneNum) {
			this.phoneNum = phoneNum;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getQqCount() {
			return qqCount;
		}

		public void setQqCount(String qqCount) {
			this.qqCount = qqCount;
		}

		public String getWeChartCount() {
			return weChartCount;
		}

		public void setWeChartCount(String weChartCount) {
			this.weChartCount = weChartCount;
		}

		@Override
		public User newObj() {
			// TODO Auto-generated method stub
			return new User();
		}

		@Override
		public void populateObj(User user) {
			// TODO Auto-generated method stub
			user.setUserId(userId);
			user.setUserName(userName);
			user.setSex(sex);
			user.setAddress(address);
			user.setPassword(SecurityUtils.enCode(password));
			user.setPhoneNum(phoneNum);
			user.setEmail(email);
			user.setQqCount(qqCount);
			user.setWeChartCount(weChartCount);
			user.setTimeCreate(DateTime.now().toString("yyyy-MM-dd HH:mm:ss:SSS"));
			user.setTimeModifed(DateTime.now().toString("yyyy-MM-dd HH:mm:ss:SSS"));
		}
		
	}
    	
	
}
