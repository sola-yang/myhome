package tyf.yhy.base.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;

/**
* @author:sola
* @version:1.0 create time：2017年10月26日
*
* 
*/
public abstract class Query  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected LinkedHashMap<String,QueryItem> itmemap=new  LinkedHashMap<String,QueryItem>();
	public static class QueryItem{
		private String name;
		private Object value;
		public QueryItem(String name,Object value){
			this.setName(name);
			this.setValue(value);
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Object getValue() {
			return value;
		}
		public void setValue(Object value) {
			this.value = value;
		}
	}
	public void addItems(String name,Object value){
		itmemap.put(name, new QueryItem(name, value));
	}
	public String getQueryString(){
		if(itmemap==null|| itmemap.isEmpty())
			return "";
		StringBuilder queryString=new StringBuilder();
		for(QueryItem item: itmemap.values()){
			queryString.append(item.name).append("=").append(item.value).append("&");
		}
		return queryString.deleteCharAt(queryString.length()-1).toString();
	}
}
