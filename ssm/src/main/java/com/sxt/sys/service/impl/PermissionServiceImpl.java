package com.sxt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.sys.domain.Permission;
import com.sxt.sys.mapper.PermissionMapper;
import com.sxt.sys.service.PermissionService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.vo.PermissionVo;

@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public List<Permission> queryPermissionByUid(Integer uid) {

		return this.permissionMapper.queryPermissionByUid(uid);
	}

	@Override
	public List<Permission> queryPermissionForList(Permission record) {

		return this.permissionMapper.queryPermissionForList(record);
	}
	
	
	@Override
	public DataGridView queryAllPermissions(PermissionVo vo) {
		Page<Permission> page = PageHelper.startPage(vo.getPage(), vo.getLimit());
		List<Permission> depts = this.permissionMapper.queryPermissionForList(vo);
		DataGridView view = new DataGridView(page.getTotal(), depts);
		return view;
	}

	@Override
	public void addPermission(PermissionVo vo) {
		this.permissionMapper.insertSelective(vo);
		
	}

	@Override
	public Permission queryPermissionById(Integer id) {
		
		return this.permissionMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updatePermission(PermissionVo vo) {
		this.permissionMapper.updateByPrimaryKeySelective(vo);
		
	}

	@Override
	public void deletePermission(Integer id) {
		this.permissionMapper.deleteByPrimaryKey(id);
		
	}
	
	@Override
	public List<Permission> queryPermissionByRoleIdForList(Integer id) {
		return this.permissionMapper.queryPermissionByRoleId(id);
	}

	/**
	 * //根据用户id查询菜单
	 */
	@Override
	public List<Permission> queryPermissionByUserIdForList(Integer id, String permissionTypeMenu) {
		return this.permissionMapper.queryPermissionByUserIdForList(id,permissionTypeMenu);
	}


}
