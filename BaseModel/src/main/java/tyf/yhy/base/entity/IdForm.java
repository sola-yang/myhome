package tyf.yhy.base.entity;
/**
* @author:sola
* @version:1.0 create time：2017年10月30日
*
* 
*/
public abstract class IdForm<T extends Id> {

	protected Integer id;
	
	
    public abstract T newObj();
    public abstract void populateObj(T t);
    public T toObj(){
    	T t=this.newObj();
    	t.setId(this.id);
    	this.populateObj(t);
    	return t;
    }
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
