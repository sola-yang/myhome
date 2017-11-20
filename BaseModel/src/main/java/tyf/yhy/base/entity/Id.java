package tyf.yhy.base.entity;

import java.io.Serializable;

/**
 * base entity for any entity(every entity should extends Id)
 * @author sola@2017-10-26
 --
 */
public abstract class Id implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Integer Id;
	protected String timeCreate;
	protected String timeModifed;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getTimeCreate() {
		return timeCreate;
	}
	public void setTimeCreate(String timeCreate) {
		this.timeCreate = timeCreate;
	}
	public String getTimeModifed() {
		return timeModifed;
	}
	public void setTimeModifed(String timeModifed) {
		this.timeModifed = timeModifed;
	}
	
}
