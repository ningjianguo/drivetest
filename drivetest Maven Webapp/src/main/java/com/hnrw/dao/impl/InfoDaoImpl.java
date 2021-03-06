package com.hnrw.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hnrw.dao.IInfoDao;
import com.hnrw.entity.ExamInfo;
import com.hnrw.entity.ExamPaper1;
import com.hnrw.entity.ExamPaper4;
import com.hnrw.entity.ExamUser;
import com.hnrw.util.JDUuid;
import com.opensymphony.xwork2.ActionContext;

@Repository
public class InfoDaoImpl extends BaseDaoImpl<ExamInfo> implements IInfoDao{

	@Override
	public boolean createExamInfo(String paperNumber,int examType) {
		Map session = ActionContext.getContext().getSession();
		ExamInfo examInfo = new ExamInfo();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		ExamUser user = (ExamUser) session.get("user");
		examInfo.setInfoId(JDUuid.createID("ASDDDDWE"));
		examInfo.setExamUser(user);
		examInfo.setInfoStartTime(sdf.format(new Date()));
		examInfo.setInfoType(examType);
		examInfo.setPaperNumber(paperNumber);
		try {
			save(examInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public ExamPaper1 getCourseOneQuestion(String paperNumber, int questionNumber) {
		String sql = "SELECT * FROM EXAM_PAPER1 WHERE PAPER1_NUMBER=? ORDER BY PAPER1_NO LIMIT ?,1 ";
		ExamPaper1 examPaper1 = null;
		try {
			examPaper1 = (ExamPaper1) getSession().createSQLQuery(sql).addEntity(ExamPaper1.class)
						.setString(0, paperNumber)
						.setInteger(1, questionNumber-1)
						.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return examPaper1;
	}

	@Override
	public boolean updateExamEndTimeAndScoreByPaperNumber(String paperNumber,int totalScore) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		try {
			String sql = "UPDATE EXAM_INFO SET INFO_SCORE=? , INFO_ENDTIME=? WHERE PAPER_NUMBER=?";
			int a = getSession().createSQLQuery(sql).setInteger(0, totalScore)
											.setString(1, sdf.format(new Date()))
											.setString(2, paperNumber)
											.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ExamPaper4 getCourseFourQuestion(String paperNumber, int questionNumber) {
		String sql = "SELECT * FROM EXAM_PAPER4 WHERE PAPER4_NUMBER=? ORDER BY PAPER4_NO LIMIT ?,1 ";
		ExamPaper4 examPaper4 = null;
		try {
			examPaper4 = (ExamPaper4) getSession().createSQLQuery(sql).addEntity(ExamPaper4.class)
						.setString(0, paperNumber)
						.setInteger(1, questionNumber-1)
						.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return examPaper4;
	}

	@Override
	public void deleteInfo(String paperNumber) {
		getSession().createSQLQuery("DELETE FROM EXAM_INFO WHERE PAPER_NUMBER=?")
		.setString(0, paperNumber).executeUpdate();
	}

}
