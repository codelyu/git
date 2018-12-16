package com.sxt.sys.service;

import java.util.List;

import com.sxt.sys.domain.User;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.vo.UserVo;

public interface UserService {
	UserVo queryUserByLoginname(String loginname);

	DataGridView queryAllUser(UserVo uservo);

	/**
	 * 添加
	 * 
	 * @param userVo
	 */
	void addUser(UserVo userVo);

	/**
	 * 
	 * @param id
	 *            要查询的部门的id
	 * @return
	 */
	User queryUserById(Integer id);

	/**
	 * 修改
	 * 
	 * @param userVo
	 */
	void updateUser(UserVo userVo);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	void deleteUser(Integer id);

	/**
	 * 查询所有的员工
	 * 
	 * @param vo
	 * @return
	 */
	List<User> loadAllUserByDeptId(UserVo vo);

	DataGridView loadAllUserRoles(UserVo vo);

	/**
	 * 分配角色
	 * 
	 * @param vo
	 */
	void addUserRoles(UserVo vo);

	/**
	 * 重置密码
	 * 
	 * @param vo
	 */
	void resetPwd(UserVo vo);
}
