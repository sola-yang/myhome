package tyf.yhy.base.service;

import java.util.List;

import tyf.yhy.base.entity.Id;
import tyf.yhy.base.entity.Paginator;

/**
* @author:sola
* @version:1.0 create time：2017年10月27日
*
* 
*/
public interface BaseService<T extends Id>  {
	public T get(int id);
	public int save(T t);
	public int update(T t);
	public int saveOrUpdate(T t);
	public List<T> getAll();
	public List<T> getByCondition(Paginator<T> page);
	public int deleteByIds(int ids[]);
}
