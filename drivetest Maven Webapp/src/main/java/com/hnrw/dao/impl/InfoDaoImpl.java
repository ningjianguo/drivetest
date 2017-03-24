package com.hnrw.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import com.hnrw.dao.IInfoDao;
import com.hnrw.entity.ExamInfo;
import com.hnrw.entity.ExamPaper1;
import com.hnrw.entity.ExamQuestion1;
import com.hnrw.entity.ExamUser;
import com.opensymphony.xwork2.ActionContext;

@Repository
public class InfoDaoImpl extends BaseDaoImpl<ExamInfo> implements IInfoDao{

	@Override
	public boolean createExamInfo(String paperNumber,int examType) {
		Map session = ActionContext.getContext().getSession();
		ExamInfo examInfo = new ExamInfo();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		ExamUser user = (ExamUser) session.get("user");
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
		String sql = "SELECT * FROM EXAM_PAPER1 WHERE PAPER1_NUMBER=? LIMIT ?,1 ";
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
	
}
