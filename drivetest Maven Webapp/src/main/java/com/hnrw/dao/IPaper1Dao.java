package com.hnrw.dao;

import java.util.List;

import com.hnrw.entity.ExamQuestion1;

public interface IPaper1Dao {
	
	/**
	 * 生成科一试题
	 * @return
	 */
	public boolean createPaper1(List<ExamQuestion1> examQuestion1s);
}
