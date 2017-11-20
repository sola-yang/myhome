package tyf.yhy.base.service;

import tyf.yhy.familyshare.entity.FamilyComment;

/**
* @author:sola
* @version:1.0 create time：2017年11月7日
*
* 
*/
public interface FamilyCommentService extends BaseService<FamilyComment> {
	int deleteByCommentId(String commentId);
}
