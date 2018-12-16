package com.sxt.sys.vo;

import com.sxt.sys.domain.Dept;

public class DeptVo extends Dept{
	private Integer page;//页号
	private Integer limit;//每页的条数
	private Integer[] ids;
	
	public DeptVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeptVo(Integer page, Integer limit, Integer[] ids) {
		super();
		this.page = page;
		this.limit = limit;
		this.ids = ids;
	}
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
}
