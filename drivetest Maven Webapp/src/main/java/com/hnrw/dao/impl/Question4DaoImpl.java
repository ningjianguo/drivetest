package com.hnrw.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hnrw.dao.IQuestion4Dao;
import com.hnrw.entity.ExamQuestion4;

@Repository
public class Question4DaoImpl extends BaseDaoImpl<ExamQuestion4> implements IQuestion4Dao{

	@SuppressWarnings("unchecked")
	@Override
	public List<ExamQuestion4> get50SubjectByRandom() {
		String sql = "SELECT * FROM exam_question4 ORDER BY rand() LIMIT 50";
		List<ExamQuestion4> examQuestion4s = null;
		try {
			examQuestion4s = getSession().createSQLQuery(sql).addEntity(ExamQuestion4.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return examQuestion4s;
	}

}
