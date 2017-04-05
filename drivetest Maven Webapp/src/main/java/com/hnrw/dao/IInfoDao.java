package com.hnrw.dao;

import com.hnrw.entity.ExamPaper1;
import com.hnrw.entity.ExamPaper4;

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
	
	/**
	 * 获取一道科目一的题
	 * @param paperNumber 试卷编号
	 * @param questionNumber 题号
	 * @return 题目信息
	 */
	public ExamPaper4 getCourseFourQuestion(String paperNumber,int questionNumber);
	/**
	 * 根据试卷编号更新考试结束时间和总成绩
	 * @param paperNumber1 试卷编号
	 * @param totalScore 总成绩
	 * @return 是否更新成功
	 */
	public boolean updateExamEndTimeAndScoreByPaperNumber(String paperNumber,int totalScore);
}
