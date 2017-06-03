package com.hnrw.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Service;

import com.hnrw.dao.IInfoDao;
import com.hnrw.dao.IPaper4Dao;
import com.hnrw.dao.IQuestion4Dao;
import com.hnrw.entity.ExamPaper4;
import com.hnrw.entity.ExamQuestion4;
import com.hnrw.service.IPaper4Service;

@Service
public class Paper4ServiceImpl implements IPaper4Service{
	
	@Resource
	private IPaper4Dao paper4DaoImpl;
	@Resource
	private IQuestion4Dao question4DaoImpl;
	@Resource
	private IInfoDao infoDaoImpl;
	@Override
	public String createPaper4() {
		List<ExamQuestion4> examQuestion4s = question4DaoImpl.get50SubjectByRandom();
		String paper4Number = paper4DaoImpl.createPaper4(examQuestion4s);
		if(infoDaoImpl.createExamInfo(paper4Number, 4)){//出题成功
			//返回第一道题
			ExamPaper4 examPaper4 = infoDaoImpl.getCourseFourQuestion(paper4Number, 1);
			JsonConfig config = new JsonConfig();
			config.setExcludes(new String[]{"examPaper4s"});
			return JSONArray.fromObject(examPaper4,config).toString();
		}
		return null;
	}
	
	@Override
	public String chooseOneAnswer(ExamPaper4 examPaper4) {
		if(examPaper4.getPaper4Choice()==null){
			examPaper4.setPaper4Choice(5);
		}
		if(paper4DaoImpl.updatePaper4Choice(examPaper4)){//保存上一题的答题信息
			ExamPaper4 paper4 = infoDaoImpl.getCourseFourQuestion(examPaper4.getPaper4Number(),examPaper4.getPaper4No()+1);
			JsonConfig config = new JsonConfig();
			config.setExcludes(new String[]{"examPaper4s"});
			return JSONArray.fromObject(paper4,config).toString();
		}
		return null;
	}

}
