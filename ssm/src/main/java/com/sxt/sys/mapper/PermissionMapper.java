package com.sxt.sys.mapper;

import java.util.List;

import com.sxt.sys.domain.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    /**
     * 根据用户id查询权限和菜单
     * @param uid
     * @return
     */
    List<Permission> queryPermissionByUid(Integer uid);
    /**
     * 查询所有的菜单
     * @param record
     * @return
     */
    List<Permission>queryPermissionForList(Permission record);
/**
 * 根据角色的id 查询角色所拥有的权限
 * @param id
 * @return
 */
	List<Permission> queryPermissionByRoleId(Integer id);

List<Permission> queryPermissionByUserIdForList(Integer id, String permissionTypeMenu);
}