package com.sxt.sys.vo;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sxt.sys.domain.Role;

public class RoleVo extends Role{
	private Integer page;//页号
	private Integer limit;//每页的条数
	private Integer[] ids;
	@JsonProperty("LAY_CHECKED")
	private Boolean LAY_CHECKED;
	
	public Boolean getLAY_CHECKED() {
		return LAY_CHECKED;
	}
	public void setLAY_CHECKED(Boolean lAY_CHECKED) {
		LAY_CHECKED = lAY_CHECKED;
	}
	public RoleVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoleVo(Integer page, Integer limit, Integer[] ids) {
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
	@Override
	public String toString() {
		return "RoleVo [page=" + page + ", limit=" + limit + ", ids=" + Arrays.toString(ids) + ", LAY_CHECKED="
				+ LAY_CHECKED + "]";
	}
	
}
