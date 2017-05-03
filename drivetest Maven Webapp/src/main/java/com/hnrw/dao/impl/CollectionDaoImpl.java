package com.hnrw.dao.impl;

import org.springframework.stereotype.Repository;

import com.hnrw.dao.ICollectionDao;
import com.hnrw.entity.ExamCollection;

@Repository
public class CollectionDaoImpl extends BaseDaoImpl<ExamCollection> implements ICollectionDao{

	@Override
	public String isCollected(int questionId) {
		getSession().createQuery("SELECT COUNT(*) FROM ExamCollection WHERE ");
		return null;
	}

	@Override
	public String collectOrNotCollected(int questionId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
