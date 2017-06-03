package com.hnrw.dao;

import java.util.List;

import com.hnrw.entity.ExamQuestion1;
import com.hnrw.entity.ExamQuestion4;

public interface IQuestion4Dao {
	/**
	 * 从题库中随机取出50道试题
	 * @return 50道试题
	 */
	public List<ExamQuestion4> get50SubjectByRandom();
	
	/**
	 * 获取科目四试题题目ID
	 * @param question4No
	 * @return 试题ID
	 */
	public String getQuestion4IdByQuestionNo(int question4No);
	
	/**
	 * 获得科目四题库的题目总数量
	 * @return 题库总数量
	 */
	public int getQuestion4TotalSize();
	
	/**
	 * 获得科目一题库中的题目
	 * @param question4No 题目ID
	 * @return 题目
	 */
	public ExamQuestion4 getOneSubject(int question4No);
	
	/**
	 * 分页获取科目四题库题目
	 * @param pageNo 页数
	 * @param pageSize 每页所包含的题目
	 * @param limitSql 限制条件
	 * @return
	 */
	public List<ExamQuestion4> loadAllData(int pageNo, int pageSize,String limitSql);
	
	/**
	 * 根据条件获得科目四题库的题目总数量
	 * @param limitSql 限制条件
	 * @return 题库总数量
	 */
	public int getQuestion4TotalSizeByArgs(String limitSql);
	
	/**
	 * 获取科目四试题库最大的题目序号
	 * @return
	 */
	public int getMaxQuestion4No();
	
	/**
	 * 添加科目四试题
	 * @param question1 科目四试题对象
	 */
	public void addQuestion4(ExamQuestion4 question4);
	
	/**
	 * 删除科目四试题
	 * @param question4 question4 科目一试题对象
	 */
	public void deleteQuestion4(ExamQuestion4 question4);
	
	/**
	 * 获得科目四题库中的题目
	 * @param question4Id 题目ID
	 * @return 题目
	 */
	public ExamQuestion4 getOneSubjectById(String question4Id);
	
	/**
	 * 编辑科目四试题
	 * @param question1 科目四试题对象
	 */
	public void editeQuestion4(ExamQuestion4 question4);
}
