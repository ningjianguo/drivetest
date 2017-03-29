package com.hnrw.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;

import com.hnrw.dao.IInfoDao;
import com.hnrw.dao.IPaper1Dao;
import com.hnrw.service.IInfoService;

@Service
public class InfoServiceImpl implements IInfoService {
	
	@Resource
	private IPaper1Dao paper1DaoImpl;
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

}
