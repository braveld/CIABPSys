package com.ciabp.models;

import java.util.List;

public class PageVO {
	public static int count=10;//每页的记录数量
	public int pageCount;//总页数量
	public int page;//当前的页码
	public List list;//当前页的数据
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		PageVO.count = count;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
}
