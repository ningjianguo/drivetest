package com.hnrw.service;

public interface IInfoService {
	
	/**
	 * 提交科一试卷
	 * @param paper1Number 试卷编号
	 * @return 试卷分数反馈
	 */
	public String submitPaper1(String paper1Number);
	
	/**
	 * 提交科四试卷
	 * @param paper4Number 试卷编号
	 * @return 试卷分数反馈
	 */
	public String submitPaper4(String paper4Number);
	
	/**
	 * 删除试卷
	 * @param paperNumber
	 */
	public void deletePaper(String paperNumber);
}
