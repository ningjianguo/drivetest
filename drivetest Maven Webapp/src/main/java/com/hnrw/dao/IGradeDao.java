package com.hnrw.dao;

import java.util.List;
import java.util.Map;

import com.hnrw.entity.ExamInfo;

public interface IGradeDao {
	
	/**
	 * 通过限制条件加载成绩
	 * @param pageNo 当前页
	 * @param pageSize 每页显示个数
	 * @param limitSql 限制条件
	 * @return
	 */
	public List<ExamInfo> loadGradeByArgs(int pageNo, int pageSize,String limitSql);
	
	/**
	 * 获取当前条件下的总数量
	 * @param limitSql 限制条件
	 * @return
	 */
	public int getTotalSize(String limitSql);
	
	/**
	 * 获取试卷类型
	 * @param paperId 试卷ID
	 * @return 1:科目一、4：科目四
	 */
	public int getPaperTypeByPaperId(String paperId);
	
}
