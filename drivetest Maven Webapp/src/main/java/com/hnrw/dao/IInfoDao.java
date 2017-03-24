package com.hnrw.dao;

import com.hnrw.entity.ExamPaper1;

public interface IInfoDao {
	/**
	 * 创建一份考试信息
	 * @param paperNumber 试题编号
	 * @param examType 考试类型（科一:1、科四:4）
	 * @return 成功与否
	 */
	public boolean createExamInfo(String paperNumber,int examType);
	
	/**
	 * 获取一道科目一的题
	 * @param paperNumber 试卷编号
	 * @param questionNumber 题号
	 * @return 题目信息
	 */
	public ExamPaper1 getCourseOneQuestion(String paperNumber,int questionNumber);
}
