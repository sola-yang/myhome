package tyf.yhy.base.entity;
/**
* @author:sola
* @version:1.0 create time：2017年10月30日
*
* 
*/
public abstract class RemarkIdForm<T extends RemarkId> extends IdForm<T> {

	protected String remark;

	public T toObj(){
		T t=super.toObj();
		t.setRemark(remark);
		return t;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
