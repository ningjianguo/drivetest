package com.hnrw.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import com.hnrw.dao.IQuestion1Dao;
import com.hnrw.entity.ExamPaper1;
import com.hnrw.entity.ExamQuestion1;

@Repository
public class Question1DaoImpl extends BaseDaoImpl<ExamQuestion1> implements IQuestion1Dao{

	@SuppressWarnings("unchecked")
	@Override
	public List<ExamQuestion1> get100SubjectByRandom() {
		String sql = "SELECT * FROM exam_question1 ORDER BY rand() LIMIT 100";
		List<ExamQuestion1> examQuestion1s = null;
		try {
			examQuestion1s = getSession().createSQLQuery(sql).addEntity(ExamQuestion1.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return examQuestion1s;
	}

	@Override
	public int getQuestion1TotalSize() {
		String sql = "SELECT COUNT(*) FROM ExamQuestion1";
		Long count = null;
		try {
			count = (Long) getSession().createQuery(sql).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count.intValue();
	}

	@Override
	public ExamQuestion1 getOneSubject(int num) {
		String sql = "SELECT * FROM exam_question1 LIMIT ?,1 ";
		ExamQuestion1 examquestion1 = null;
		try {
			examquestion1 = (ExamQuestion1) getSession().createSQLQuery(sql).addEntity(ExamQuestion1.class)
						.setInteger(0, num-1)
						.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return examquestion1;
	}

}
