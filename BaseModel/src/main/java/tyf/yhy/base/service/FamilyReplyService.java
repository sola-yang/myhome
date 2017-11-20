package tyf.yhy.base.service;

import tyf.yhy.familyshare.entity.FamilyReply;

/**
* @author:sola
* @version:1.0 create time：2017年11月7日
*
* 
*/
public interface FamilyReplyService extends BaseService<FamilyReply> {
	int deleteByReplyId(String replyId);
}
