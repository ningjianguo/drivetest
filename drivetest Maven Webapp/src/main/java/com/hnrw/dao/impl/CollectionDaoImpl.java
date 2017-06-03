package com.hnrw.dao.impl;

import java.math.BigInteger;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hnrw.dao.ICollectionDao;
import com.hnrw.entity.ExamCollection;
import com.hnrw.entity.ExamUser;
import com.hnrw.util.JDUuid;
import com.opensymphony.xwork2.ActionContext;

@Repository
public class CollectionDaoImpl extends BaseDaoImpl<ExamCollection> implements ICollectionDao{

	@Override
	public String isCollected(String questionId) {
		Map session = ActionContext.getContext().getSession();
		ExamUser user = (ExamUser) session.get("user");
		BigInteger count = null;
		try {
			count = (BigInteger) getSession().createSQLQuery("SELECT COUNT(*) FROM EXAM_COLLECTION WHERE USER_ID = ? AND COLLECTION_QID = ?")
						.setString(0, user.getUserId())
						.setString(1, questionId).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count.intValue() == 0 ? "NO" : "YES";
	}

	@Override
	public String collectOrNotCollected(String questionId) {
		Map session = ActionContext.getContext().getSession();
		ExamUser user = (ExamUser) session.get("user");
		ExamCollection collection = null;
		if(isCollected(questionId).equals("NO")){
			//收藏题目
			collection = new ExamCollection();
			collection.setCollectionId(JDUuid.createID("SDFGXCVB"));
			collection.setCollectionQid(questionId);
			collection.setExamUser(user);
			save(collection);
			return "YES";
		}else{
			//取消收藏
			try {
				getSession().createSQLQuery("DELETE FROM EXAM_COLLECTION WHERE USER_ID = ? AND COLLECTION_QID = ?")
							.setString(0, user.getUserId())
							.setString(1, questionId).executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "NO";
		}
	}
	
}
