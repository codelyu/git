package com.sxt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.sys.domain.Role;
import com.sxt.sys.mapper.RoleMapper;
import com.sxt.sys.service.RoleService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.vo.RoleVo;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<Role> queryRoleByUid(Integer uid) {

		return this.roleMapper.queryRoleByUid(uid);
	}
	@Override
	public DataGridView queryAllRole(RoleVo vo) {
		Page<Role> page = PageHelper.startPage(vo.getPage(), vo.getLimit());
		List<Role> roles = this.roleMapper.queryAllRole(vo);
		DataGridView view = new DataGridView(page.getTotal(), roles);
		return view;
	}

	@Override
	public void addRole(RoleVo roleVo) {
		this.roleMapper.insertSelective(roleVo);
		
	}

	@Override
	public Role queryRoleById(Integer id) {
		
		return this.roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateRole(RoleVo roleVo) {
		this.roleMapper.updateByPrimaryKeySelective(roleVo);
		
	}

	@Override
	public void deleteRole(Integer id) {
		this.roleMapper.deleteRolePermissionByRoleId(id);
		this.roleMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void addRolePermission(RoleVo roleVo) {
		Integer roleId=roleVo.getId();
		Integer[] perIds=roleVo.getIds();
		//1，先删除原来 根据roleid删除sys_role_permission里面的数据
		this.roleMapper.deleteRolePermissionByRoleId(roleId);
		//2，重新保存
		if(perIds!=null&&perIds.length>0) {
			for (Integer perId : perIds) {
				this.roleMapper.addRolePermission(roleId,perId);
			}
		}
	}
	@Override
	public List<Role> queryallRoles() {
		RoleVo vo = null;
		return this.roleMapper.queryAllRole(vo);
	}
}
