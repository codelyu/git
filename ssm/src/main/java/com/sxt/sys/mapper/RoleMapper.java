package com.sxt.sys.mapper;

import java.util.List;

import com.sxt.sys.domain.Role;

public interface RoleMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Role record);

	int insertSelective(Role record);

	Role selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);

	List<Role> queryRoleByUid(Integer id);

	List<Role> queryAllRole(Role role);
	
	
	/**
	 * 删除原有的权限
	 */
	void deleteRolePermissionByRoleId(Integer roleId);
/**
 * 分配新的权限
 * @param roleId
 * @param perId
 */
	void addRolePermission(Integer roleId, Integer perId);
}