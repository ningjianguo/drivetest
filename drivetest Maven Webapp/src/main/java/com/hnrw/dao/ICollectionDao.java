package com.hnrw.dao;

public interface ICollectionDao {
	
	/**
	 * 判断题目是否被收藏 
	 * @param questionId 题目ID
	 * @return 已收藏:yes、未收藏:no
	 */
	public String isCollected(int questionId);
	
	/**
	 * 收藏题目或取消收藏
	 * @param questionId 题目ID
	 * @return 已收藏:yes、未收藏:no
	 */
	public String collectOrNotCollected(int questionId);
}
