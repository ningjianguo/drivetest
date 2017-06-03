package com.hnrw.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hnrw.dao.IGradeDao;
import com.hnrw.entity.ExamInfo;
@Repository
public class GradeDaoImpl extends BaseDaoImpl<ExamInfo> implements IGradeDao {

	@Override
	public List<ExamInfo> loadGradeByArgs(int pageNo, int pageSize, String limitSql) {
		List<ExamInfo> examInfos = getPaging(pageNo,pageSize,limitSql);
		return examInfos;
	}
	
	@Override
	public int getTotalSize(String limitSql){
		String querySql = "SELECT COUNT(*) FROM ExamInfo "+(limitSql == null ? "":"WHERE "+limitSql);
		Long count = (Long) getSession().createQuery(querySql).uniqueResult();
		return count.intValue();
	}

	@Override
	public int getPaperTypeByPaperId(String paperId) {
		Long count = (Long) getSession().createQuery("SELECT COUNT(*) FROM ExamPaper1 WHERE paper1Number=?")
					.setString(0, paperId).uniqueResult();
		 return count.intValue() == 0 ? 4 : 1;
	}

}
