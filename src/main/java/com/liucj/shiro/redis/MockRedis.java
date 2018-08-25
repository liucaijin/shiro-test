package com.liucj.shiro.redis;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class MockRedis {
	
	private static Map<String,String> redis = new ConcurrentHashMap<>();
	
	public static String getKey(String key){
		return redis.get(key);
	}
	
	public static void setKey(String key,String value){
		 redis.put(key, value);
	}
}
