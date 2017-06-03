package com.hnrw.service;

public interface ICollectionService {
	/**
	 * 收藏或者是取消收藏试题
	 * @param questionId 试题ID
	 * @return 收藏:yes、取消收藏:no
	 */
	public String collectOrNotCollect(String questionId);
}
