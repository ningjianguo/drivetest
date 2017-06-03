package com.hnrw.service;

import com.hnrw.entity.ExamQuestion1;
import com.hnrw.entity.ExamQuestion4;


public interface IQuestion4Service {
	
	/**
	 * 创建一份科目四复习试卷
	 * @return
	 */
	public String createReviewPaper4();
	
	/**
	 * 跳转下一题
	 * @param examQuestion4No 科目四题库题目序号
	 * @return 题目信息
	 */
	public String nextReviewQuestion4(int examQuestion4No);
	
	/**
	 * 分页获取科目四题库题目
	 * @param pageNo 页数
	 * @param pageSize 每页所包含的题目
	 * @param limitSql 限制条件
	 * @return
	 */
	public String loadAllData(int pageNo, int pageSize,String limitSql);
	
	/**
	 * 添加科目四试题
	 * @param question4 科目四试题对象
	 * @return 当前题序号
	 */
	public int addQuestion4(ExamQuestion4 question4);
	
	/**
	 * 删除科目四试题库
	 * @param delItems 题目主键
	 * @return
	 */
	public String deleteQuestion4(String delItems);
	
	/**
	 * 编辑科目四试题
	 * @param question4 科目四试题对象
	 * @return
	 */
	public void editeQuestion4(ExamQuestion4 question4);
}
