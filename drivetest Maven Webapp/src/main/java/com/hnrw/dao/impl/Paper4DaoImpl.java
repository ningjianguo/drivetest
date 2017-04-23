package com.hnrw.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hnrw.dao.IPaper4Dao;
import com.hnrw.entity.ExamPaper4;
import com.hnrw.entity.ExamQuestion4;
import com.hnrw.util.UUIDUtil;

@Repository
public class Paper4DaoImpl extends BaseDaoImpl<ExamPaper4> implements IPaper4Dao{

	@Override
	public String createPaper4(List<ExamQuestion4> examQuestion4s) {
		String paper4Number = UUIDUtil.getUUID();
		ExamPaper4 examPaper4 = null;
		int qid = 1;
		try {
			for (ExamQuestion4 examQuestion4 : examQuestion4s) {
				examPaper4 = new ExamPaper4();
				examPaper4.setExamQuestion4(examQuestion4);
				examPaper4.setPaper4Number(paper4Number);
				examPaper4.setQuestion4Answer(examQuestion4.getQuestion4Answer());
				examPaper4.setPaper4Qid(qid++);
				save(examPaper4);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return paper4Number;
	}

	@Override
	public boolean updatePaper4Choice(ExamPaper4 examPaper4) {
		try {
			String sql = "UPDATE EXAM_PAPER4 SET PAPER4_CHOICE=? WHERE PAPER4_NUMBER=? AND PAPER4_QID=?";
			getSession().createSQLQuery(sql).setInteger(0, examPaper4.getPaper4Choice())
											.setString(1, examPaper4.getPaper4Number())
											.setInteger(2, examPaper4.getPaper4Qid())
											.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int getTrueAnswerByPaper4Number(String paper4Number) {
		String hql = "SELECT COUNT(*) FROM ExamPaper4 WHERE paper4Number=:number AND question4Answer=paper4Choice";
		Long size = null;
		try {
			size = (Long) getSession().createQuery(hql).setString("number", paper4Number).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size.intValue();
	}

	@Override
	public int getselectedAnswerByPaper4Number(String paper4Number) {
		String hql = "SELECT COUNT(*) FROM ExamPaper4 WHERE paper4Number=:number AND paper4Choice IS NOT NULL";
		Long size = null;
		try {
			size = (Long) getSession().createQuery(hql).setString("number", paper4Number).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size.intValue();
	}


}
