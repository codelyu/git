package com.sxt.sys.mapper;

import java.util.List;

import com.sxt.sys.domain.User;
import com.sxt.sys.vo.UserVo;

public interface UserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	UserVo queryUserByLoginName(String loginname);

	List<User> queryAllUser(User user);

	/**
	 * 查询所有的员工
	 * 
	 * @param deptid
	 * @return
	 */
	List<User> loadAllUserByDeptId(Integer deptid);

	/**
	 * 删除用户拥有的角色
	 * 
	 * @param id
	 */

	void deleteUserRolesByUserid(Integer id);
	/**
	 * 给用户添加角色
	 * @param rid
	 * @param uid
	 */
	void insertUserRoleByRid(Integer rid, Integer uid);
}