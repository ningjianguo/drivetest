package com.hnrw.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hnrw.dao.IPaper1Dao;
import com.hnrw.entity.ExamPaper1;
import com.hnrw.entity.ExamQuestion1;
import com.hnrw.util.JDUuid;

@Repository
public class Paper1DaoImpl extends BaseDaoImpl<ExamPaper1> implements IPaper1Dao{

	@Override
	public String createPaper1(List<ExamQuestion1> examQuestion1s) {
		String paper1Number = JDUuid.createID("WERWEWER");
		ExamPaper1 examPaper1 = null;
		int qid = 1;
		try {
			for (ExamQuestion1 examQuestion1 : examQuestion1s) {
				examPaper1 = new ExamPaper1();
				examPaper1.setPaper1Id(JDUuid.createID("DSHJSDFD"));
				examPaper1.setExamQuestion1(examQuestion1);
				examPaper1.setPaper1Number(paper1Number);
				examPaper1.setQuestion1Answer(examQuestion1.getQuestion1Answer());
				examPaper1.setPaper1No(qid++);
				save(examPaper1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return paper1Number;
	}

	@Override
	public boolean updatePaper1Choice(ExamPaper1 examPaper1) {
		try {
			String sql = "UPDATE EXAM_PAPER1 SET PAPER1_CHOICE=? WHERE PAPER1_NUMBER=? AND PAPER1_NO=?";
			getSession().createSQLQuery(sql).setInteger(0, examPaper1.getPaper1Choice())
											.setString(1, examPaper1.getPaper1Number())
											.setInteger(2, examPaper1.getPaper1No())
											.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int getTrueAnswerByPaper1Number(String paper1Number) {
		String hql = "SELECT COUNT(*) FROM ExamPaper1 WHERE paper1Number=:number AND question1Answer=paper1Choice";
		Long size = null;
		try {
			size = (Long) getSession().createQuery(hql).setString("number", paper1Number).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size.intValue();
	}

	@Override
	public int getselectedAnswerByPaper1Number(String paper1Number) {
		String hql = "SELECT COUNT(*) FROM ExamPaper1 WHERE paper1Number=:number AND paper1Choice IS NOT NULL";
		Long size = null;
		try {
			size = (Long) getSession().createQuery(hql).setString("number", paper1Number).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size.intValue();
	}

	@Override
	public void deletePaper1(String paper1Number) {
		getSession().createSQLQuery("DELETE FROM EXAM_PAPER1 WHERE PAPER1_NUMBER=?")
		.setString(0, paper1Number).executeUpdate();
	}

}
