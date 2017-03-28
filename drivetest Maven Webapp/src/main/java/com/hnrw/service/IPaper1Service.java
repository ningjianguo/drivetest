package com.hnrw.service;

import com.hnrw.entity.ExamPaper1;

public interface IPaper1Service {
	
	/**
	 * 创建一份科一试卷
	 * @return
	 */
	public String createPaper1();
	
	/**
	 * 选择一项答案返回下一题信息
	 * @param examPaper1 用户选项
	 * @return	下一道题目信息
	 */
	public String chooseOneAnswer(ExamPaper1 examPaper1);
}
