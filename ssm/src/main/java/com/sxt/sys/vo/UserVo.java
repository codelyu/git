package com.sxt.sys.vo;

import java.util.ArrayList;
import java.util.List;

import com.sxt.sys.domain.User;

public class UserVo extends User {
	private Integer page;//页号
	private Integer limit;//每页的条数
	private Integer[] ids;
	private List<String> roles = new ArrayList<>();
	private List<String> permissions = new ArrayList<>();
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
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public List<String> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}
	
	
}
