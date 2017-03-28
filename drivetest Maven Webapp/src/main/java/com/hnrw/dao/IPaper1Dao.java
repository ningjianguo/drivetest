package com.hnrw.dao;

import java.util.List;

import com.hnrw.entity.ExamPaper1;
import com.hnrw.entity.ExamQuestion1;

public interface IPaper1Dao {
	
	/**
	 * 生成科一试题
	 * @param 题库试题信息
	 * @return 科一试题编号
	 */
	public String createPaper1(List<ExamQuestion1> examQuestion1s);
	
	/**
	 * 添加试卷已选择答案
	 * @param examPaper1
	 */
	public boolean updatePaper1Choice(ExamPaper1 examPaper1);
}
