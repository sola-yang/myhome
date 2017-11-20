package tyf.yhy.util;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

/**
* @author:sola
* @version:1.0 create time：2017年10月30日
*
* 
*/
public final class SecurityUtils {

	public static String enCode(String enCodeStr){
		try {
			MessageDigest messageDigest=MessageDigest.getInstance("MD5");
			BASE64Encoder base64Encoder=new BASE64Encoder();
			return base64Encoder.encode(messageDigest.digest(enCodeStr.getBytes("utf-8")));
		} catch (Exception e) {
			return "";
		} 
	}
}
