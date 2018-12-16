package com.sxt.bus.utils;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ZtreeNode {
	private Integer id;
	@JsonProperty("pId")
	private Integer pid;
	private String name;
	private Boolean isParent;
	private Boolean open;
	private Boolean checked;

	private List<ZtreeNode> children = new ArrayList<>();

	public ZtreeNode(Integer id, Integer pid, String name, Boolean isParent, Boolean open, Boolean checked) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.isParent = isParent;
		this.open = open;
		this.checked = checked;
		
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public List<ZtreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<ZtreeNode> children) {
		this.children = children;
	}

	public ZtreeNode(Integer id, Integer pid, String name, Boolean isParent, Boolean open) {
		super();
		this.id = id;
		// 改别名

		this.pid = pid;
		this.name = name;
		this.isParent = isParent;
		this.open = open;
	}

	public ZtreeNode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

}
