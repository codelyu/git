package com.sxt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.sys.domain.Dept;
import com.sxt.sys.mapper.DeptMapper;
import com.sxt.sys.service.DeptService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.vo.DeptVo;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptMapper deptMapper;

	@Override
	public List<Dept> queryAllDept(Dept record) {
		// TODO Auto-generated method stub
		return this.deptMapper.queryAllDept(record);
	}

	@Override
	public DataGridView queryAllDept(DeptVo vo) {
		Page<Dept> page = PageHelper.startPage(vo.getPage(), vo.getLimit());
		List<Dept> depts = this.deptMapper.queryAllDept(vo);
		DataGridView view = new DataGridView(page.getTotal(), depts);
		return view;
	}

	@Override
	public void addDept(DeptVo deptVo) {
		this.deptMapper.insertSelective(deptVo);
		
	}

	@Override
	public Dept queryDeptById(Integer id) {
		
		return this.deptMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateDept(DeptVo deptVo) {
		this.deptMapper.updateByPrimaryKeySelective(deptVo);
		
	}

	@Override
	public void deleteDept(Integer id) {
		this.deptMapper.deleteByPrimaryKey(id);
		
	}

}
