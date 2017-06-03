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
	public ExamQuestion1 getOneSubjectByNo(int question1No) {
		String sql = "SELECT * FROM EXAM_QUESTION1 ORDER BY QUESTION1_NO LIMIT ?,1 ";
		ExamQuestion1 examquestion1 = null;
		try {
			examquestion1 = (ExamQuestion1) getSession().createSQLQuery(sql).addEntity(ExamQuestion1.class)
						.setInteger(0, question1No-1)
						.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return examquestion1;
	}

	@Override
	public String getQuestion1IdByQuestionNo(int question1No) {
		String questionId = null;
		try {
			questionId = (String) getSession().createQuery("SELECT question1Id FROM ExamQuestion1 WHERE question1No=?")
						.setInteger(0, question1No).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return questionId;
	}

	@Override
	public List<ExamQuestion1> loadAllData(int pageNo, int pageSize,String limitSql) {
		List<ExamQuestion1> examQuestion1s = getPaging(pageNo,pageSize,limitSql);
		return examQuestion1s;
	}

	@Override
	public int getQuestion1TotalSizeByArgs(String limitSql) {
		String sql = "SELECT COUNT(*) FROM ExamQuestion1 WHERE "+limitSql;
		Long count = null;
		try {
			count = (Long) getSession().createQuery(sql).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count.intValue();
	}

	@Override
	public void addQuestion1(ExamQuestion1 question1) {
		save(question1);
	}

	@Override
	public int getMaxQuestion1No() {
		int maxValue = (Integer) getSession().createSQLQuery("SELECT MAX(QUESTION1_NO) FROM EXAM_QUESTION1").uniqueResult();
		return maxValue;
	}

	@Override
	public void deleteQuestion1(ExamQuestion1 question1) {
		getSession().createSQLQuery("DELETE FROM EXAM_QUESTION1 WHERE QUESTION1_ID=?")
					.setString(0, question1.getQuestion1Id()).executeUpdate();
	}

	@Override
	public ExamQuestion1 getOneSubjectById(String question1Id) {
		ExamQuestion1 question1 = (ExamQuestion1) getSession().createQuery("FROM ExamQuestion1 WHERE question1Id=?")
					.setString(0, question1Id).uniqueResult();
		return question1;
	}

	@Override
	public void editeQuestion1(ExamQuestion1 question1) {
		update(question1);
	}

}
