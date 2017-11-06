package tyf.yhy.base.entity;
/**
 * the entity who has remark attribute should extends RemarkId;
 * @author sola@2017-10-26
 --
 */
public class RemarkId extends Id {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
