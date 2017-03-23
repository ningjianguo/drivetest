package com.hnrw.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hnrw.dao.IPaper1Dao;
import com.hnrw.dao.IQuestion1Dao;
import com.hnrw.entity.ExamQuestion1;
import com.hnrw.service.IPaper1Service;

@Service
public class Paper1ServiceImpl implements IPaper1Service{
	
	@Resource
	private IPaper1Dao paper1DaoImpl;
	@Resource
	private IQuestion1Dao question1DaoImpl;
	
	@Override
	public String createPaper1() {
		List<ExamQuestion1> examQuestion1s = question1DaoImpl.get100SubjectByRandom();
		paper1DaoImpl.createPaper1(examQuestion1s);
		return null;
	}

}
