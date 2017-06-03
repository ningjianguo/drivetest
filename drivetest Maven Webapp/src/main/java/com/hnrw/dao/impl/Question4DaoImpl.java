package com.hnrw.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hnrw.dao.IQuestion4Dao;
import com.hnrw.entity.ExamQuestion1;
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

	@Override
	public String getQuestion4IdByQuestionNo(int question4No) {
		String questionId = null;
		try {
			questionId = (String) getSession().createQuery("SELECT question4Id FROM ExamQuestion4 WHERE question4No=?")
						.setInteger(0, question4No).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return questionId;
	}
	
	@Override
	public int getQuestion4TotalSize() {
		String sql = "SELECT COUNT(*) FROM ExamQuestion4";
		Long count = null;
		try {
			count = (Long) getSession().createQuery(sql).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count.intValue();
	}
	
	@Override
	public ExamQuestion4 getOneSubject(int question4No) {
		String sql = "SELECT * FROM EXAM_QUESTION4 ORDER BY QUESTION4_NO LIMIT ?,1 ";
		ExamQuestion4 examquestion4 = null;
		try {
			examquestion4 = (ExamQuestion4) getSession().createSQLQuery(sql).addEntity(ExamQuestion4.class)
						.setInteger(0, question4No-1)
						.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return examquestion4;
	}
	
	@Override
	public List<ExamQuestion4> loadAllData(int pageNo, int pageSize,String limitSql) {
		List<ExamQuestion4> examQuestion4s = getPaging(pageNo,pageSize,limitSql);
		return examQuestion4s;
	}
	
	@Override
	public int getQuestion4TotalSizeByArgs(String limitSql) {
		String sql = "SELECT COUNT(*) FROM ExamQuestion4 WHERE "+limitSql;
		Long count = null;
		try {
			count = (Long) getSession().createQuery(sql).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count.intValue();
	}
	
	@Override
	public void addQuestion4(ExamQuestion4 question4) {
		save(question4);
	}
	
	@Override
	public void deleteQuestion4(ExamQuestion4 question4) {
		getSession().createSQLQuery("DELETE FROM EXAM_QUESTION4 WHERE QUESTION4_ID=?")
					.setString(0, question4.getQuestion4Id()).executeUpdate();
	}
	
	@Override
	public int getMaxQuestion4No() {
		int maxValue = (Integer) getSession().createSQLQuery("SELECT MAX(QUESTION4_NO) FROM EXAM_QUESTION4").uniqueResult();
		return maxValue;
	}
	
	@Override
	public ExamQuestion4 getOneSubjectById(String question4Id) {
		ExamQuestion4 question4 = (ExamQuestion4) getSession().createQuery("FROM ExamQuestion4 WHERE question4Id=?")
					.setString(0, question4Id).uniqueResult();
		return question4;
	}
	
	@Override
	public void editeQuestion4(ExamQuestion4 question4) {
		update(question4);
	}
}
