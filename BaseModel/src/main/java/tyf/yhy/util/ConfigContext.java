package tyf.yhy.util;

import java.util.HashMap;
import java.util.Map;

/**
* @author:sola
* @version:1.0 create time：2017年11月3日
*
* 
*/
public final class ConfigContext {
    public static final Map<Character,String> sexMap=getSexMap();
    public static final Map<Character,String> familyRoleMap=getFamilyRoleMap();
    public static Map<Character,String> getSexMap(){
    	Map<Character,String> map=new HashMap<Character,String>();
    	map.put('0',"man");
    	map.put('1',"woman");
    	return map;
    }
    public static Map<Character,String> getFamilyRoleMap(){
    	Map<Character,String> map=new HashMap<Character,String>();
    	map.put('0',"father");
    	map.put('1',"mother");
    	map.put('2',"child");
    	return map;
    }
}
