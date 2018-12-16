package com.sxt.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.sys.domain.Role;
import com.sxt.sys.domain.User;
import com.sxt.sys.mapper.RoleMapper;
import com.sxt.sys.mapper.UserMapper;
import com.sxt.sys.service.UserService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.utils.Md5Utils;
import com.sxt.sys.vo.RoleVo;
import com.sxt.sys.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public UserVo queryUserByLoginname(String loginname) {

		return this.userMapper.queryUserByLoginName(loginname);
	}

	@Override
	public DataGridView queryAllUser(UserVo vo) {
		Page<User> page = PageHelper.startPage(vo.getPage(), vo.getLimit());
		List<User> users = this.userMapper.queryAllUser(vo);
		DataGridView view = new DataGridView(page.getTotal(), users);
		return view;
	}

	@Override
	public void addUser(UserVo userVo) {
		this.userMapper.insertSelective(userVo);

	}

	@Override
	public User queryUserById(Integer id) {

		return this.userMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateUser(UserVo userVo) {
		this.userMapper.updateByPrimaryKeySelective(userVo);

	}

	@Override
	public void deleteUser(Integer id) {
		// 先删除sys_role_user里面用户的信息
		this.userMapper.deleteUserRolesByUserid(id);
		this.userMapper.deleteByPrimaryKey(id);

	}

	@Override
	public List<User> loadAllUserByDeptId(UserVo vo) {

		return this.userMapper.loadAllUserByDeptId(vo.getDeptid());
	}

	@Override
	public DataGridView loadAllUserRoles(UserVo vo) {
		Role record = new Role();
		record.setAvailable(1);
		// 先查询所有的角色
		List<Role> roles = this.roleMapper.queryAllRole(record);
		// 再根据用户的id查询用户所拥有的角色
		List<Role> userRoles = this.roleMapper.queryRoleByUid(vo.getId());
		List<RoleVo> roleVos = new ArrayList<>();
		for (Role role : roles) {
			Boolean LAY_CHECKED = false;
			for (Role userRole : userRoles) {
				if (role.getId() == userRole.getId()) {
					LAY_CHECKED = true;
				}
			}
			RoleVo roleVo = new RoleVo();
			BeanUtils.copyProperties(role, roleVo);
			roleVo.setLAY_CHECKED(LAY_CHECKED);
			roleVos.add(roleVo);
		}
		DataGridView view = new DataGridView(Long.valueOf(roleVos.size()), roleVos);
		return view;
	}

	@Override
	public void addUserRoles(UserVo vo) {
		// 先删除原来用户拥有的角色
		Integer uid = vo.getId();
		this.userMapper.deleteUserRolesByUserid(uid);
		// 给用户添加角色
		Integer[] ids = vo.getIds();
		for (Integer rid : ids) {
			this.userMapper.insertUserRoleByRid(rid, uid);
		}
	}

	@Override
	public void resetPwd(UserVo vo) {
		String pwd = "123456";
		// 根据用户id查询用户
		User user = this.userMapper.selectByPrimaryKey(vo.getId());
		String salt = user.getName() + user.getAddress();
		String userPwd = Md5Utils.encodePasswordUseMd5(pwd, salt, 2);
		user.setPwd(userPwd);
		// 将修改完的用户存入数据库
		this.userMapper.updateByPrimaryKeySelective(user);
	}

}
