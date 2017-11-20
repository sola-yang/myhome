package tyf.yhy.usermanager.entity;

import java.io.Serializable;

import tyf.yhy.base.entity.Id;
/**
 * 
 * @author sola@2017-10-26
 *
 */
public class User extends Id implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
}
