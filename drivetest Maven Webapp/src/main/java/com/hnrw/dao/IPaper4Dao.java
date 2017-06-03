package com.hnrw.dao;

import java.util.List;

import com.hnrw.entity.ExamPaper4;
import com.hnrw.entity.ExamQuestion4;

public interface IPaper4Dao {
	
	/**
	 * 生成科四试题
	 * @param 题库试题信息
	 * @return 科四试题编号
	 */
	public String createPaper4(List<ExamQuestion4> examQuestion4s);
	
	/**
	 * 添加试卷已选择答案
	 * @param examPaper4
	 */
	public boolean updatePaper4Choice(ExamPaper4 examPaper4);
	
	/**
	 * 根据试卷编号获得此试卷的总分
	 * @param paper4Number 试卷编号
	 * @return 试卷总分
	 */
	public int getTrueAnswerByPaper4Number(String paper4Number);
	
	/**
	 * 根据试卷编号获得此试卷已做过的题数
	 * @param paper4Number 试卷编号
	 * @return 做过的题数
	 */
	public int getselectedAnswerByPaper4Number(String paper4Number);
	
	/**
	 * 删除科目四试卷
	 * @param paperNumber 试卷编号
	 */
	public void deletePaper4(String paperNumber);
}
