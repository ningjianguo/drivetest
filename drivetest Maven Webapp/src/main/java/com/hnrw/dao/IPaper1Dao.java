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
	
	/**
	 * 根据试卷编号获得此试卷的总分
	 * @param paper1Number 试卷编号
	 * @return 试卷总分
	 */
	public int getTrueAnswerByPaper1Number(String paper1Number);
	
	/**
	 * 根据试卷编号获得此试卷已做过的题数
	 * @param paper1Number 试卷编号
	 * @return 做过的题数
	 */
	public int getselectedAnswerByPaper1Number(String paper1Number);
}
