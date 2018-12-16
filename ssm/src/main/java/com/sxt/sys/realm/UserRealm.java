package com.sxt.sys.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.sxt.sys.domain.Permission;
import com.sxt.sys.domain.Role;
import com.sxt.sys.mapper.PermissionMapper;
import com.sxt.sys.mapper.RoleMapper;
import com.sxt.sys.service.UserService;
import com.sxt.sys.vo.UserVo;

public class UserRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private PermissionMapper permissionMapper;

	public String getRealmName() {
		return this.getClass().getSimpleName();
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection collection) {
		/**
		 * 授权
		 */
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		UserVo vo = (UserVo) collection.getPrimaryPrincipal();
		List<String> roles = vo.getRoles();
		List<String> permissions = vo.getPermissions();
		//添加权限
		info.addRoles(roles);
		info.addStringPermissions(permissions);
		return info;
	}

	/**
	 * + 验证登录
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 拿到用户输入的登录名
		String loginname = token.getPrincipal().toString();
		// 验证用户是否存在
		UserVo vo = this.userService.queryUserByLoginname(loginname);

		// 如果登录名输入正确
		if (null != vo) {
			List<String> roles = new ArrayList<String>();
			List<String> permissions = new ArrayList<String>();
			List<Role> userRoles = null;
			List<Permission> userPermissions = null;
			if (vo.getType() != 0) {
				// 根据用户id去查询所的用户拥有的角色
				userRoles = this.roleMapper.queryRoleByUid(vo.getId());
				// 根据用户的id查询用户拥有的所有权限
				userPermissions = this.permissionMapper.queryPermissionByUserIdForList(vo.getId(),"permission");
				for (Role r : userRoles) {
					roles.add(r.getName());
				}
				for (Permission p : userPermissions) {
					permissions.add(p.getPercode());
				}

			} else {
				// 内置用户不受限制
				roles.add("*");
				permissions.add("*:*");
			}
			// 将所有信息封装到UserVo里面
			vo.setPermissions(permissions);
			vo.setRoles(roles);
			ByteSource salt = ByteSource.Util.bytes(vo.getName() + vo.getAddress());
			AuthenticationInfo info = new SimpleAuthenticationInfo(vo, vo.getPwd(), salt, this.getRealmName());
			return info;
		} else
			return null;
	}

}
