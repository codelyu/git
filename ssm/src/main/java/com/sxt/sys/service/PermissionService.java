package com.sxt.sys.service;

import java.util.List;

import com.sxt.sys.domain.Permission;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.vo.PermissionVo;

public interface PermissionService {
	/**
	 * 根据用户的id 查询拥有的权限和菜单
	 * @param uid
	 * @return
	 */
  List<Permission> queryPermissionByUid(Integer uid);
  /**
   * 查询所有的菜单和权限
   * @param record
   * @return
   */
  List<Permission>queryPermissionForList(Permission record);
  
  
   DataGridView queryAllPermissions(PermissionVo vo);
	
	/**
	 * 添加
	 * @param vo
	 */
	void addPermission(PermissionVo vo);
	
	/**
	 * 
	 * @param id 要查询的部门的id
	 * @return
	 */
	Permission queryPermissionById(Integer id);
	/**
	 * 修改
	 * @param vo
	 */
	void updatePermission(PermissionVo vo);
	
	/**
	 * 删除
	 * @param id
	 */
	void deletePermission(Integer id);
	
	/**
	 * 根据角色ID查询权限
	 * @param id
	 * @return
	 */
	public List<Permission> queryPermissionByRoleIdForList(Integer id);
	/**
	 * 根据用户的id查询菜单
	 * @param id
	 * @param permissionTypeMenu
	 * @return
	 */
	List<Permission> queryPermissionByUserIdForList(Integer id, String permissionTypeMenu);
}
