package com.hnrw.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hnrw.dao.IInfoDao;
import com.hnrw.dao.IPaper1Dao;
import com.hnrw.dao.IPaper4Dao;
import com.hnrw.service.IInfoService;

import net.sf.json.JSONArray;

@Service
public class InfoServiceImpl implements IInfoService {
	
	@Resource
	private IPaper1Dao paper1DaoImpl;
	@Resource
	private IPaper4Dao paper4DaoImpl;
	@Resource
	private IInfoDao infoDaoImpl;
	
	@Override
	public String submitPaper1(String paper1Number) {
		int trueNum = paper1DaoImpl.getTrueAnswerByPaper1Number(paper1Number);
		int selectedNum = paper1DaoImpl.getselectedAnswerByPaper1Number(paper1Number);
		int errorNum = selectedNum - trueNum;
		int noSelectedNum = 100 - selectedNum;
		int totalScore = trueNum*1;
		boolean flag = infoDaoImpl.updateExamEndTimeAndScoreByPaperNumber(paper1Number, totalScore);
		if(flag){//插入成功
			List<Integer> paper1Info = new ArrayList<Integer>();	
			paper1Info.add(errorNum);
			paper1Info.add(noSelectedNum);
			paper1Info.add(totalScore);
			return JSONArray.fromObject(paper1Info).toString();
		}
		return null;
	}

	@Override
	public String submitPaper4(String paper4Number) {
		int trueNum = paper4DaoImpl.getTrueAnswerByPaper4Number(paper4Number);
		int selectedNum = paper4DaoImpl.getselectedAnswerByPaper4Number(paper4Number);
		int errorNum = selectedNum - trueNum;
		int noSelectedNum = 50 - selectedNum;
		int totalScore = trueNum*2;
		boolean flag = infoDaoImpl.updateExamEndTimeAndScoreByPaperNumber(paper4Number, totalScore);
		if(flag){//插入成功
			List<Integer> paper4Info = new ArrayList<Integer>();	
			paper4Info.add(errorNum);
			paper4Info.add(noSelectedNum);
			paper4Info.add(totalScore);
			return JSONArray.fromObject(paper4Info).toString();
		}
		return null;
	}

	@Override
	public void deletePaper(String paperNumber) {
		
	}
}
