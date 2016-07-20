package com.ciabp.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserSession implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4998122406255424351L;
	private Map<String, Object> map;
	
	public void init() {
		map = new HashMap<String, Object>();
	}
	
	public void destroy() {
		map.clear();
		map = null;
	}
	
	public void put(String key, Object value){
		this.map.put(key, value);
	}
	public Object get(String key){
		return this.map.get(key);
	}
}
