package com.sxt.sys.service;

import java.util.List;

import com.sxt.sys.domain.Dept;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.vo.DeptVo;

public interface DeptService {
	List<Dept>queryAllDept(Dept record);
	DataGridView queryAllDept(DeptVo vo);
	
	/**
	 * 添加
	 * @param deptVo
	 */
	void addDept(DeptVo deptVo);
	
	/**
	 * 
	 * @param id 要查询的部门的id
	 * @return
	 */
	Dept queryDeptById(Integer id);
	/**
	 * 修改
	 * @param deptVo
	 */
	void updateDept(DeptVo deptVo);
	
	/**
	 * 删除
	 * @param id
	 */
	void deleteDept(Integer id);
}
