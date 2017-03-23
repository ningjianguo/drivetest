package com.hnrw.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hnrw.dao.IPaper1Dao;
import com.hnrw.entity.ExamPaper1;
import com.hnrw.entity.ExamQuestion1;
import com.hnrw.util.UUIDUtil;

@Repository
public class Paper1DaoImpl extends BaseDaoImpl<ExamPaper1> implements IPaper1Dao{

	@Override
	public boolean createPaper1(List<ExamQuestion1> examQuestion1s) {
		String paper1Number = UUIDUtil.getUUID();
		ExamPaper1 examPaper1 = null;
		try {
			for (ExamQuestion1 examQuestion1 : examQuestion1s) {
				examPaper1 = new ExamPaper1();
				examPaper1.setExamQuestion1(examQuestion1);
				examPaper1.setPaper1Number(paper1Number);
				examPaper1.setQuestion1Answer(examQuestion1.getQuestion1Answer());
				save(examPaper1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


}
