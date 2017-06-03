package com.hnrw.dao;

import java.util.List;

import com.hnrw.entity.ExamQuestion1;

public interface IQuestion1Dao {
	
	/**
	 * 从题库中随机取出100道试题
	 * @return 100道试题
	 */
	public List<ExamQuestion1> get100SubjectByRandom();
	
	/**
	 * 获得科目一题库的题目总数量
	 * @return 题库总数量
	 */
	public int getQuestion1TotalSize();
	
	/**
	 * 根据条件获得科目一题库的题目总数量
	 * @param limitSql 限制条件
	 * @return 题库总数量
	 */
	public int getQuestion1TotalSizeByArgs(String limitSql);
	
	/**
	 * 获得科目一题库中的题目
	 * @param question1No 题目序号
	 * @return 题目
	 */
	public ExamQuestion1 getOneSubjectByNo(int question1No);
	
	/**
	 * 获得科目一题库中的题目
	 * @param question1Id 题目ID
	 * @return 题目
	 */
	public ExamQuestion1 getOneSubjectById(String question1Id);
	
	/**
	 * 获取科目一试题题目ID
	 * @param question1No
	 * @return 试题ID
	 */
	public String getQuestion1IdByQuestionNo(int question1No);
	
	/**
	 * 分页获取科目一题库题目
	 * @param pageNo 页数
	 * @param pageSize 每页所包含的题目
	 * @param limitSql 限制条件
	 * @return
	 */
	public List<ExamQuestion1> loadAllData(int pageNo, int pageSize,String limitSql);
	
	/**
	 * 添加科目一试题
	 * @param question1 科目一试题对象
	 */
	public void addQuestion1(ExamQuestion1 question1);
	
	/**
	 * 编辑科目一试题
	 * @param question1 科目一试题对象
	 */
	public void editeQuestion1(ExamQuestion1 question1);
	
	/**
	 * 删除科目一试题
	 * @param question1 question1 科目一试题对象
	 */
	public void deleteQuestion1(ExamQuestion1 question1);
	
	/**
	 * 获取科目一试题库最大的题目序号
	 * @return
	 */
	public int getMaxQuestion1No();
}
