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
	 * 获得科目一题库中的题目
	 * @param num 题号
	 * @return 题目
	 */
	public ExamQuestion1 getOneSubject(int num);
}
