package com.sxt.sys.domain;

public class Role {
    private Integer id;

    private String name;

    private String remark;

    private Integer available;
   
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", remark=" + remark + ", available=" + available + "]";
	}
    
}