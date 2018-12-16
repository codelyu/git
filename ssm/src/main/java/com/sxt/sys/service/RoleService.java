package com.sxt.sys.service;

import java.util.List;

import com.sxt.sys.domain.Role;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.vo.RoleVo;

public interface RoleService {
	List<Role> queryRoleByUid(Integer uid);

	/**
	 * 全查询
	 * 
	 * @param vo
	 * @return
	 */
	DataGridView queryAllRole(RoleVo vo);

	/**
	 * 添加
	 * 
	 * @param roleVo
	 */
	void addRole(RoleVo roleVo);

	/**
	 * 
	 * @param id
	 *            要查询的部门的id
	 * @return
	 */
	Role queryRoleById(Integer id);

	/**
	 * 修改
	 * 
	 * @param roleVo
	 */
	void updateRole(RoleVo roleVo);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	void deleteRole(Integer id);
/**
 * 添加权限
 * @param roleVo
 */
	void addRolePermission(RoleVo roleVo);
	/**
	 * 查询所有的角色
	 * @return
	 */

List<Role> queryallRoles();
}
