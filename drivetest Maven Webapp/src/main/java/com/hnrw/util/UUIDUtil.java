package com.hnrw.util;

import java.util.UUID;

public class UUIDUtil {
	
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String uuidStr = uuid.toString().replace("-", "");
		return uuidStr;
	}
	
}
