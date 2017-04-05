package com.hnrw.dao;

import java.util.List;

import com.hnrw.entity.ExamQuestion4;

public interface IQuestion4Dao {
	/**
	 * 从题库中随机取出50道试题
	 * @return 50道试题
	 */
	public List<ExamQuestion4> get50SubjectByRandom();
}
