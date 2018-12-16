package com.sxt.sys.utils;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	private Integer id;
	private Integer pid;
	private String title;
	private String href;
	private String icon;
	private Boolean spread;
	private List<TreeNode> children = new ArrayList<>();
	
	
	public TreeNode() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TreeNode(Integer id, Integer pid, String title, String href, String icon, Boolean spread) {
		super();
		this.id = id;
		this.pid = pid;
		this.title = title;
		this.href = href;
		this.icon = icon;
		this.spread = spread;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Boolean getSpread() {
		return spread;
	}
	public void setSpread(Boolean spread) {
		this.spread = spread;
	}
	public List<TreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

}
