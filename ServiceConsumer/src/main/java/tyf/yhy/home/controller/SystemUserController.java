package tyf.yhy.home.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tyf.yhy.base.controller.CDUContentController;
import tyf.yhy.base.entity.IdForm;
import tyf.yhy.base.entity.Query;
import tyf.yhy.base.service.UserService;
import tyf.yhy.usermanager.entity.User;
import tyf.yhy.util.ConfigContext;
import tyf.yhy.util.LoginContext;
import tyf.yhy.util.SecurityUtils;

/**
* @author:sola
* @version:1.0 create time£º2017Äê10ÔÂ30ÈÕ
*
* 
*/
@Controller
@RequestMapping("/system")
public class SystemUserController extends CDUContentController<User, UserService,SystemUserController.UserForm, SystemUserController.UserQuery> {

	public SystemUserController() {
		super("system");
		// TODO Auto-generated constructor stub
	}
	@Resource
	public void setUserService(UserService userService){
		this.service=userService;
	}
	@Override
	protected void toSave(UserForm form, BindingResult errors, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		User user=form.toObj();
		this.service.save(user);
	}
	@Override
	protected void postAddData(Model model) {
		model.addAttribute("sexMap", ConfigContext.sexMap);
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	protected String userRegister(UserForm form, BindingResult errors, Model model, HttpServletRequest request,
			HttpServletResponse response){
		
		User user=form.toObj();
		User exist=this.service.getUser(user.getUserId());
		if(exist!=null&&exist.getUserId()!=null){
			errors.addError(new ObjectError("errors", "the count has been registered!"));
			model.addAttribute("errors",errors);
			model.addAttribute("form", user);
			model.addAttribute("sexMap",ConfigContext.sexMap);
			return this.ADD_PAGE;
		}
		try {
			this.service.save(user);
		}catch(Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "redirect:/system/login";
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	protected String login(HttpSession session){
		if(LoginContext.checkLogin(session)){
			return "redirect:/myhome/home";
		}
		return "/system/login";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	protected String userLogin(UserForm form, BindingResult errors, Model model,HttpSession session){
		User newUser=form.toObj();
		User oldUser=this.service.getUser(newUser.getUserId());
		if(oldUser==null){
			errors.addError(new ObjectError("account", "the account does not exist!"));
			model.addAttribute("errors",errors);
			model.addAttribute("form", form);
			return "/system/login";
		}else if(!newUser.getPassword().equals(oldUser.getPassword())){
			errors.addError(new ObjectError("password", "the password is not correct!"));
			model.addAttribute("errors",errors);
			model.addAttribute("form", form);
			return "/system/login";
		}
		Map<String,String> loginUserMap=(Map<String,String>)session.getServletContext().getAttribute(LoginContext.LOGIN_SESSION_KEY);
		if(loginUserMap==null){
			loginUserMap=new HashMap<String,String>();
		}
		if(loginUserMap.containsKey(oldUser.getUserId())){
			errors.addError(new ObjectError("login", "you have been logined!"));
			model.addAttribute("errors",errors);
			return "/system/login";
		}else{
			loginUserMap.put(oldUser.getUserId(),  session.getId());
			session.getServletContext().setAttribute(LoginContext.LOGIN_SESSION_KEY,loginUserMap);
		}
		
		LoginContext.login(oldUser, session);
		return "redirect:/myhome/home";
	}
	@RequestMapping(value="/logout")
	protected String logout(HttpSession session){
		session.invalidate();
		return "redirect:/system/login";
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
    public static class UserQuery extends Query{
    	private String userId;
    	private String userName;
    	private char sex;//0 represent man 1 represent woman
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
			this.addItems("suerId", this.userId);
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
			this.addItems("userName", this.userName);
		}
		public char getSex() {
			return sex;
		}
		public void setSex(char sex) {
			this.sex = sex;
			this.addItems("sex", this.sex);
		}
		public String getPhoneNum() {
			return phoneNum;
		}
		public void setPhoneNum(String phoneNum) {
			this.phoneNum = phoneNum;
			this.addItems("phoneNum", this.phoneNum);
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
			this.addItems("address", this.address);
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
			this.addItems("email", this.email);
		}
		public String getQqCount() {
			return qqCount;
		}
		public void setQqCount(String qqCount) {
			this.qqCount = qqCount;
			this.addItems("qqCount", this.qqCount);
		}
		public String getWeChartCount() {
			return weChartCount;
		}
		public void setWeChartCount(String weChartCount) {
			this.weChartCount = weChartCount;
			this.addItems("weChartCount", this.weChartCount);
		}
    	
    }
	
}
