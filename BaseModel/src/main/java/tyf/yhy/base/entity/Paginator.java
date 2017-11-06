package tyf.yhy.base.entity;

import java.io.Serializable;

/**
* @author:sola
* @version:1.0 create time：2017年10月26日
*paging for table
* 
*/
public class Paginator implements Serializable{
       /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public  static final int DEFAULT_SIZE=20;
	   private int start;
	   private int size;
	   private int page;
       private int total;
       private boolean needTotal;
       private boolean hasNextPage;
   	   private boolean hasPrePage;
   	   private boolean hasData;
       private boolean pageless;
   	   private String path;
   	   private Query query;
   	   private Object attachment;
   	   public Paginator(int page){
   		   this.page=page;
   		   init();
   	   }
   	   public void init(){
   		   if(page<1){
   			   page=1;
   		   }
   		   if(size<1){
   			size=DEFAULT_SIZE;
   		   }
   		   start=(page-1)*size;
   		   hasPrePage=page>1;
   	   }
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSqlSize() {
		return size+1;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
		init();
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public boolean isNeedTotal() {
		return needTotal;
	}
	public void setNeedTotal(boolean needTotal) {
		this.needTotal = needTotal;
	}
	public boolean isHasNextPage() {
		return hasNextPage;
	}
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	public boolean isHasPrePage() {
		return hasPrePage;
	}
	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}
	public boolean isHasData() {
		return hasData;
	}
	public void setHasData(boolean hasData) {
		this.hasData = hasData;
	}
	public boolean isPageless() {
		return pageless;
	}
	public void setPageless(boolean pageless) {
		this.pageless = pageless;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Query getQuery() {
		return query;
	}
	public void setQuery(Query query) {
		this.query = query;
	}
	public Object getAttachment() {
		return attachment;
	}
	public void setAttachment(Object attachment) {
		this.attachment = attachment;
	}
	public static int getDefaultSize() {
		return DEFAULT_SIZE;
	}
}
