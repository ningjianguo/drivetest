package com.hnrw.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.hnrw.dao.IGradeDao;
import com.hnrw.dao.IInfoDao;
import com.hnrw.dao.IPaper1Dao;
import com.hnrw.dao.IPaper4Dao;
import com.hnrw.entity.ExamInfo;
import com.hnrw.entity.ExamPaper1;
import com.hnrw.entity.ExamPaper4;
import com.hnrw.service.IGradeService;
import com.hnrw.util.CommonUtil;

@Service
public class GradeServiceImpl implements IGradeService {
	@Resource
	private IGradeDao gradeDaoImpl;
	@Resource
	private IPaper1Dao paper1DaoImpl;
	@Resource
	private IPaper4Dao paper4DaoImpl;
	@Resource
	private IInfoDao infoDaoImpl;
	@Override
	public String loadGradeByArgs(int pageNo, int pageSize,String limitSql) {
		List<ExamInfo> examInfos = gradeDaoImpl.loadGradeByArgs(pageNo, pageSize, "".equals(limitSql) ? null:limitSql);
		Map<String, Object> maps = null;
		JSONObject jobj = null;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			for (ExamInfo examInfo : examInfos) {
				maps = new HashMap<String, Object>();
				String paperNum = examInfo.getPaperNumber();
				int paperType = gradeDaoImpl.getPaperTypeByPaperId(paperNum);
				int selectedCount = 0;
				String selectedRate = "";
				int grade = 0;
				String trueRate = "";
				String endTime = "";
				String totalTime = "";
				int testStatu = 0;
				int paperScore = 0;
				if(1 == paperType){
					selectedCount = paper1DaoImpl.getselectedAnswerByPaper1Number(examInfo.getPaperNumber());
					selectedRate = CommonUtil.getPercent(selectedCount, 100);
			        int trueCount = paper1DaoImpl.getTrueAnswerByPaper1Number(examInfo.getPaperNumber());
			        grade = trueCount >89 ? 1 : 0;
			        trueRate = CommonUtil.getPercent(trueCount, selectedCount);
					paperScore = trueCount*1;
					endTime = examInfo.getInfoEndTime();
					testStatu = endTime == null ? 0 : 1;
					if(1 == testStatu){
						totalTime = CommonUtil.getTimeByTwoArgs(examInfo.getInfoStartTime(), examInfo.getInfoEndTime());
					}
				}else{
					selectedCount = paper4DaoImpl.getselectedAnswerByPaper4Number(examInfo.getPaperNumber());
					selectedRate = CommonUtil.getPercent(selectedCount, 50);
			        int trueCount = paper4DaoImpl.getTrueAnswerByPaper4Number(examInfo.getPaperNumber());
			        grade = trueCount > 44 ? 1 : 0;
			        trueRate = CommonUtil.getPercent(trueCount, selectedCount);
					paperScore = trueCount*2;
					endTime = examInfo.getInfoEndTime();
					testStatu = endTime == null ? 0 : 1;
					if(1 == testStatu){
						totalTime = CommonUtil.getTimeByTwoArgs(examInfo.getInfoStartTime(), examInfo.getInfoEndTime());
					}
				}
				maps.put("totalTime", totalTime);
				maps.put("endTime", endTime);
				maps.put("trueRate", trueRate);
				maps.put("selectedRate", selectedRate);
				maps.put("paperNum", paperNum);
				maps.put("paperTempNum", paperNum.toUpperCase().substring(0,20));
				maps.put("paperType", paperType);
				maps.put("testStatu", testStatu);
				maps.put("selectedCount", selectedCount);
				maps.put("grade", grade);
				maps.put("paperScore", paperScore);
				list.add(maps);
			}
			jobj = new JSONObject();
            jobj.accumulate("total",gradeDaoImpl.getTotalSize("".equals(limitSql) ? null:limitSql));//total代表一共有多少数据  
            jobj.accumulate("rows", list);//row是代表显示的页的数据  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobj.toString();
	}
	
	@Override
	public String deleteGrade(String delItems) {
		String[] dels = delItems.split(";");
		for (String del : dels) {
			int paperType = gradeDaoImpl.getPaperTypeByPaperId(del);
			if(paperType==1){
				paper1DaoImpl.deletePaper1(del);
			}else{
				paper4DaoImpl.deletePaper4(del);
			}
			infoDaoImpl.deleteInfo(del);
		}
		return "ok";
	}

}
