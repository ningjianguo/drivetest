package com.hnrw.drivetest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.hnrw.util.CommonUtil;

public class TestUtil {
	
	@Test
	public static void testGetOrderList(){
		List<Map<String, Object>> testList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("id", 1);
		map1.put("time1", "2017-05-13 11:23:10");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("id", 2);
		map2.put("time2", "2017-05-13 11:23:15");
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("id", 3);
		map3.put("time3", "2017-05-13 11:23:08");
		testList.add(map1);
		testList.add(map2);
		testList.add(map3);
	}
}
