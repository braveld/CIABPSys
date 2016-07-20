package com.ciabp.utils;

public class PageUtils {
	private static int count=3;

	private  PageUtils() {
	}
	
	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		PageUtils.count = count;
	}
	
}
