package com.ciabp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Randomten {
	public static String getRandom(){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		return df.format(new Date());// new Date()为获取当前系统时间
	}
	
	public static void main(String[] args){
		System.out.println(getRandom());
	}

}
