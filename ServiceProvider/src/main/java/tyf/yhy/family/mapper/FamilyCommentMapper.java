package tyf.yhy.family.mapper;

import tyf.yhy.base.mapper.BaseMapper;
import tyf.yhy.familyshare.entity.FamilyComment;

/**
* @author:sola
* @version:1.0 create time：2017年11月7日
*
* 
*/
public interface FamilyCommentMapper extends BaseMapper<FamilyComment> {
	int deleteByCommentId(String commentId);
}
