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
import com.hnrw.dao.IQuestion4Dao;
import com.hnrw.entity.ExamQuestion1;
import com.hnrw.entity.ExamQuestion4;
import com.hnrw.service.IQuestion4Service;
import com.hnrw.util.JDUuid;

@Service
public class Question4ServiceImpl implements IQuestion4Service {
	@Resource
	private IQuestion4Dao question4DaoImpl;
	@Resource
	private ICollectionDao collectionDaoImpl;
	@Override
	public String createReviewPaper4() {
		return nextReviewQuestion4(1);
	}

	@Override
	public String nextReviewQuestion4(int examQuestion4No) {
		int totalSize = question4DaoImpl.getQuestion4TotalSize();
		ExamQuestion4 examQuestion4_ = question4DaoImpl.getOneSubject(examQuestion4No);
		String question4Id = question4DaoImpl.getQuestion4IdByQuestionNo(examQuestion4No);
		String statu = collectionDaoImpl.isCollected(question4Id);
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[]{"examPaper4s"});
		String jsonStr = JSONArray.fromObject(examQuestion4_,config).toString();
		String jsonStr_ = "[{\"totalSize\":\""+totalSize+"\",\"statu\":\""+statu+"\","+jsonStr.substring(2);
		return jsonStr_;
	}

	@Override
	public String loadAllData(int pageNo, int pageSize, String limitSql) {
		List<ExamQuestion4> examQuestion4s = question4DaoImpl.loadAllData(pageNo, pageSize,limitSql);
		Map<String, Object> maps = null;
		JSONObject jobj = null;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (ExamQuestion4 examQuestion4 : examQuestion4s) {
			maps = new HashMap<String, Object>();
			maps.put("question4Id", examQuestion4.getQuestion4Id());
			maps.put("question4No", examQuestion4.getQuestion4No());
			maps.put("question4Question", examQuestion4.getQuestion4Question());
			maps.put("question4Answer", examQuestion4.getQuestion4Answer());
			maps.put("question4Item1", examQuestion4.getQuestion4Item1());
			maps.put("question4Item2", examQuestion4.getQuestion4Item2());
			maps.put("question4Item3", examQuestion4.getQuestion4Item3());
			maps.put("question4Item4", examQuestion4.getQuestion4Item4());
			maps.put("question4Explains", examQuestion4.getQuestion4Explains());
			maps.put("question4Url", examQuestion4.getQuestion4Url());
			list.add(maps);
		}
		jobj = new JSONObject();
        jobj.accumulate("total",question4DaoImpl.getQuestion4TotalSizeByArgs(limitSql));//total代表一共有多少数据  
        jobj.accumulate("rows", list);//row是代表显示的页的数据  
		return jobj.toString();
	}
	
	@Override
	public int addQuestion4(ExamQuestion4 question4) {
		String temps[] = question4.getQuestion4Answer().split(",");
		String answerStr = "";
		for(String temp : temps){
			answerStr+=temp;
		}
		question4.setQuestion4Answer(answerStr.replace(" ", ""));
		int tempNo = question4DaoImpl.getMaxQuestion4No()+1;
		question4.setQuestion4Id(JDUuid.createID("tyuytyui"));
		question4.setQuestion4No(tempNo);
		String url = question4.getQuestion4Url();
		if(url!=null){
			String temp = url.substring(url.lastIndexOf("."));
			question4.setQuestion4Url(tempNo+temp);
		}
		try {
			question4DaoImpl.addQuestion4(question4);
			return tempNo;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	@Override
	public String deleteQuestion4(String delItems) {
		String[] dels = delItems.split(";");
		ExamQuestion4 question4 = null;
		for (String del : dels) {
			question4 = new ExamQuestion4();
			question4.setQuestion4Id(del);
			try {
				String url = question4DaoImpl.getOneSubjectById(del).getQuestion4Url();
				question4DaoImpl.deleteQuestion4(question4);
				//物理删除图片
				File imgFile = new File("C:/jiakao_question4/"+url);
				imgFile.delete();
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		}
		return "ok";
	}
	
	@Override
	public void editeQuestion4(ExamQuestion4 question4) {
		String url = question4.getQuestion4Url();
		if(url!=null){
			String temp = url.substring(url.lastIndexOf("."));
			question4.setQuestion4Url(question4.getQuestion4No()+temp);
		}
		try {
			question4DaoImpl.editeQuestion4(question4);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
