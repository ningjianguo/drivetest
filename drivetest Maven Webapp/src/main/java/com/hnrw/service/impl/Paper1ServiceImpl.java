package com.hnrw.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Service;

import com.hnrw.dao.IInfoDao;
import com.hnrw.dao.IPaper1Dao;
import com.hnrw.dao.IQuestion1Dao;
import com.hnrw.entity.ExamPaper1;
import com.hnrw.entity.ExamQuestion1;
import com.hnrw.service.IPaper1Service;

@Service
public class Paper1ServiceImpl implements IPaper1Service{
	
	@Resource
	private IPaper1Dao paper1DaoImpl;
	@Resource
	private IQuestion1Dao question1DaoImpl;
	@Resource
	private IInfoDao infoDaoImpl;
	@Override
	public String createPaper1() {
		List<ExamQuestion1> examQuestion1s = question1DaoImpl.get100SubjectByRandom();
		String paper1Number = paper1DaoImpl.createPaper1(examQuestion1s);
		if(infoDaoImpl.createExamInfo(paper1Number, 1)){//出题成功
			//返回第一道题
			ExamPaper1 examPaper1 = infoDaoImpl.getCourseOneQuestion(paper1Number, 1);
			JsonConfig config = new JsonConfig();
			config.setExcludes(new String[]{"examPaper1s"});
			return JSONArray.fromObject(examPaper1,config).toString();
		}
		return null;
	}

}
