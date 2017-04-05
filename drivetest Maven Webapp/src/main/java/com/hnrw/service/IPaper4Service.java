package com.hnrw.service;

import com.hnrw.entity.ExamPaper4;

public interface IPaper4Service {
	
	/**
	 * 创建一份科四试卷
	 * @return
	 */
	public String createPaper4();
	
	/**
	 * 选择一项答案返回下一题信息
	 * @param examPaper4 用户选项
	 * @return	下一道题目信息
	 */
	public String chooseOneAnswer(ExamPaper4 examPaper4);
}
