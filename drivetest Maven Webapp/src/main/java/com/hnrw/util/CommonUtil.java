package com.hnrw.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CommonUtil {
	
	/**
	 * 获取两个时间段的间隔时间
	 * @param startTime 初始时间
	 * @param endTime 结束时间
	 * @return 间隔时间
	 */
	public static String getTimeByTwoArgs(String startTime,String endTime){
		SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
		try {
			Date time1 = sdf.parse(startTime);
			Date time2 = sdf.parse(endTime);
			Long a = time1.getTime();
			Long b = time2.getTime();
			int c = b.intValue()-a.intValue();
			int s = c/1000;
			if(s/60 == 0){
				return (s%60)+"秒";
			}
			return (s/60)+"分"+(s%60)+"秒";
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取百分比
	 * @param fz 分子
	 * @param fm 分母
	 * @return 百分比
	 */
	public static String getPercent(int fz,int fm){
		 NumberFormat nt = NumberFormat.getPercentInstance();  
	     //设置百分数精确度2即保留两位小数  
	     nt.setMinimumFractionDigits(2);  
	     float baifen = (float)fz/fm;  
	     return nt.format(baifen);
	}
}
