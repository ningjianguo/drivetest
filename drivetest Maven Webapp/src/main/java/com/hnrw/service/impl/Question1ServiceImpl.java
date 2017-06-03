package com.hnrw.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Service;

import com.hnrw.dao.ICollectionDao;
import com.hnrw.dao.IQuestion1Dao;
import com.hnrw.entity.ExamQuestion1;
import com.hnrw.service.IQuestion1Service;
import com.hnrw.util.JDUuid;

@Service
public class Question1ServiceImpl implements IQuestion1Service {
	@Resource
	private IQuestion1Dao question1DaoImpl;
	@Resource
	private ICollectionDao collectionDaoImpl;
	@Override
	public String createReviewPaper1() {
		return nextReviewQuestion1(1);
	}

	@Override
	public String nextReviewQuestion1(int examQuestion1No) {
		int totalSize = question1DaoImpl.getQuestion1TotalSize();
		ExamQuestion1 examQuestion1_ = question1DaoImpl.getOneSubjectByNo(examQuestion1No);
		String question1Id = question1DaoImpl.getQuestion1IdByQuestionNo(examQuestion1No);
		String statu = collectionDaoImpl.isCollected(question1Id);
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[]{"examPaper1s"});
		String jsonStr = JSONArray.fromObject(examQuestion1_,config).toString();
		String jsonStr_ = "[{\"totalSize\":\""+totalSize+"\",\"statu\":\""+statu+"\","+jsonStr.substring(2);
		return jsonStr_;
	}

	@Override
	public String loadAllData(int pageNo, int pageSize,String limitSql) {
		List<ExamQuestion1> examQuestion1s = question1DaoImpl.loadAllData(pageNo, pageSize,limitSql);
		Map<String, Object> maps = null;
		JSONObject jobj = null;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (ExamQuestion1 examQuestion1 : examQuestion1s) {
			maps = new HashMap<String, Object>();
			maps.put("question1Id", examQuestion1.getQuestion1Id());
			maps.put("question1No", examQuestion1.getQuestion1No());
			maps.put("question1Question", examQuestion1.getQuestion1Question());
			maps.put("question1Answer", examQuestion1.getQuestion1Answer());
			maps.put("question1Item1", examQuestion1.getQuestion1Item1());
			maps.put("question1Item2", examQuestion1.getQuestion1Item2());
			maps.put("question1Item3", examQuestion1.getQuestion1Item3());
			maps.put("question1Item4", examQuestion1.getQuestion1Item4());
			maps.put("question1Explains", examQuestion1.getQuestion1Explains());
			maps.put("question1Url", examQuestion1.getQuestion1Url());
			list.add(maps);
		}
		jobj = new JSONObject();
        jobj.accumulate("total",question1DaoImpl.getQuestion1TotalSizeByArgs(limitSql));//total代表一共有多少数据  
        jobj.accumulate("rows", list);//row是代表显示的页的数据  
		return jobj.toString();
	}

	@Override
	public int addQuestion1(ExamQuestion1 question1) {
		int tempNo = question1DaoImpl.getMaxQuestion1No()+1;
		question1.setQuestion1Id(JDUuid.createID("tyuytyui"));
		question1.setQuestion1No(tempNo);
		String url = question1.getQuestion1Url();
		if(url!=null){
			String temp = url.substring(url.lastIndexOf("."));
			question1.setQuestion1Url(tempNo+temp);
		}
		try {
			question1DaoImpl.addQuestion1(question1);
			return tempNo;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public String deleteQuestion1(String delItems) {
		String[] dels = delItems.split(";");
		ExamQuestion1 question1 = null;
		for (String del : dels) {
			question1 = new ExamQuestion1();
			question1.setQuestion1Id(del);
			try {
				String url = question1DaoImpl.getOneSubjectById(del).getQuestion1Url();
				question1DaoImpl.deleteQuestion1(question1);
				//物理删除图片
				File imgFile = new File("C:/jiakao_question1/"+url);
				imgFile.delete();
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		}
		return "ok";
	}

	@Override
	public void editeQuestion1(ExamQuestion1 question1) {
		String url = question1.getQuestion1Url();
		
		if(url!=null){
			String temp = url.substring(url.lastIndexOf("."));
			question1.setQuestion1Url(question1.getQuestion1No()+temp);
		}
		try {
			question1DaoImpl.editeQuestion1(question1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
