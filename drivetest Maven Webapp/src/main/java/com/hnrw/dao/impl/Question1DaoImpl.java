package com.hnrw.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hnrw.dao.IQuestion1Dao;
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

}
