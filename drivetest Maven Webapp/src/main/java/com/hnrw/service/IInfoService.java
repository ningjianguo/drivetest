package com.hnrw.service;

public interface IInfoService {
	/**
	 * 提交科一试卷
	 * @param paper1Number 试卷编号
	 * @return 试卷分数反馈
	 */
	public String submitPaper1(String paper1Number);
}
