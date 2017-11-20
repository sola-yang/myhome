package tyf.yhy.base.mapper;

import java.util.List;

import tyf.yhy.base.entity.Id;
import tyf.yhy.base.entity.Paginator;

/**
* @author:sola
* @version:1.0 create time：2017年10月26日
*
* 
*/
public interface BaseMapper<T extends Id>{
	
	T selectById(Integer id);
	List<T> select(Paginator page);
	
	int count(Paginator page);
	
	List<T> selectAll();
	
	int insert(T t);
	
	int delete(int ids[]);
	
	int update(T t);
	
}
