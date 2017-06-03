package com.hnrw.service;

public interface IGradeService {
	
	/**
	 * 通过限制条件加载成绩
	 * @param pageNo 当前页
	 * @param pageSize 每页显示个数
	 * @param limitSql 限制条件
	 * @return
	 */
	public String loadGradeByArgs(int pageNo, int pageSize,String limitSql);
	
	/**
	 * 删除成绩
	 * @param delItems 被删除的记录id
	 * @return ok : 删除成功、error : 删除失败
	 */
	public String deleteGrade(String delItems);
}
