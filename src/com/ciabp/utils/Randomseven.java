package com.ciabp.utils;
import java.util.Random;

public class Randomseven {
	
	 public static String getRandomString(int length) { 
		 StringBuffer buffer = new StringBuffer("0123456789"); 
		 StringBuffer sb = new StringBuffer(); 
		 Random r = new Random(); 
		 int range = buffer.length(); 
		 for (int i = 0; i < length; i ++) { 
		sb.append(buffer.charAt(r.nextInt(range)));
		}
		 return sb.toString(); 
		}

}
