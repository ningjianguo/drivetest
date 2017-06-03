package com.hnrw.service;

import com.hnrw.entity.ExamQuestion1;


public interface IQuestion1Service {
	
	/**
	 * 创建一份科目一复习试卷
	 * @return
	 */
	public String createReviewPaper1();
	
	/**
	 * 跳转下一题
	 * @param examQuestion1No 科目一题库题目序号
	 * @return 题目信息
	 */
	public String nextReviewQuestion1(int examQuestion1No);
	
	/**
	 * 分页获取科目一题库题目
	 * @param pageNo 页数
	 * @param pageSize 每页所包含的题目
	 * @param limitSql 限制条件
	 * @return
	 */
	public String loadAllData(int pageNo, int pageSize,String limitSql);
	
	/**
	 * 添加科目一试题
	 * @param question1 科目一试题对象
	 * @return 当前题序号
	 */
	public int addQuestion1(ExamQuestion1 question1);
	
	/**
	 * 删除科目一试题库
	 * @param delItems 题目主键
	 * @return
	 */
	public String deleteQuestion1(String delItems);
	
	/**
	 * 编辑科目一试题
	 * @param question1 科目一试题对象
	 * @return
	 */
	public void editeQuestion1(ExamQuestion1 question1);
}
