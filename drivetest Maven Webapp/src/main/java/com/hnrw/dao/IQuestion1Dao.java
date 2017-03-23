package com.hnrw.dao;

import java.util.List;

import com.hnrw.entity.ExamQuestion1;

public interface IQuestion1Dao {
	/**
	 * 从题库中随机取出100道试题
	 * @return 100道试题
	 */
	public List<ExamQuestion1> get100SubjectByRandom();
}
