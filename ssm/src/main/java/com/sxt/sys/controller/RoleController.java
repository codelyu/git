package com.sxt.sys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.sys.domain.Permission;
import com.sxt.sys.domain.Role;
import com.sxt.sys.service.PermissionService;
import com.sxt.sys.service.RoleService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.utils.ZTreeNodeBuilder;
import com.sxt.sys.utils.ZtreeNode;
import com.sxt.sys.vo.PermissionVo;
import com.sxt.sys.vo.RoleVo;

@Controller
@RequestMapping("role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;

	@RequestMapping("toRoleManager")
	public String toRoleManager() {
		return "sys/role/roleManager";
	}

	/**
	 * 查询角色具体信息
	 */
	@RequestMapping("queryAllRoles")
	@ResponseBody
	public DataGridView queryAllRoles(RoleVo vo) {
		DataGridView dataGridView = this.roleService.queryAllRole(vo);
		return dataGridView;
	}


	

	
	/**
	 * 跳转到添加角色页面
	 */
	@RequestMapping("toRoleAdd")
	public String toRoleAdd() {
		return "sys/role/roleAdd";
	}
	
	
	/**
	 * 添加
	 */
	@RequestMapping("addRole")
	@ResponseBody
	public Map<String,Object> addRole(RoleVo roleVo){
		Map<String, Object> map=new HashMap<>();
		String msg="添加成功";
		try {
			//做添加
			this.roleService.addRole(roleVo);
		} catch (Exception e) {
			msg="添加失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	
	/**
	 * 跳转到修改角色页面
	 */
	/**
	 * 跳转到修改页面
	 */
	@RequestMapping("toUpdateRole")
	public String toUpdateRole(RoleVo roleVo,Model model) {
		Role role=this.roleService.queryRoleById(roleVo.getId());
		model.addAttribute("role", role);
		return "sys/role/roleUpdate";
	}
	
	/**
	 * 修改角色
	 */
	@RequestMapping("updateRole")
	@ResponseBody
	public Map<String,Object> updateRole(RoleVo roleVo){
		Map<String, Object> map=new HashMap<>();
		String msg="修改成功";
		try {
			//做修改
			this.roleService.updateRole(roleVo);
		} catch (Exception e) {
			msg="修改失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	
	/**
	 * 删除
	 */
	@RequestMapping("deleteRole")
	@ResponseBody
	public Map<String,Object> deleteRole(RoleVo roleVo){
		Map<String, Object> map=new HashMap<>();
		String msg="删除成功";
		try {
			//做删除
			//1先删除sys_role_permission里面分配的权限
			
			this.roleService.deleteRole(roleVo.getId());
		} catch (Exception e) {
			msg="删除失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	/**
	 * 批量删除
	 */
	@RequestMapping("batchDeleteRole")
	@ResponseBody
	public Map<String,Object> batchDeleteRole(RoleVo roleVo){
		Map<String, Object> map=new HashMap<>();
		String msg="删除成功";
		try {
			//删除
			Integer[] ids=roleVo.getIds();
			if(null!=ids&&ids.length>0) {
				for (Integer integer : ids) {
					this.roleService.deleteRole(integer);
				}
			}
		} catch (Exception e) {
			msg="删除失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	
	
	
	/**
	 * 跳转到分配权限的页面
	 */
	@RequestMapping("toSelectPermission")
//	public String toSelectPermission(RoleVo roleVo,Model model) {
	public String toSelectPermission(RoleVo roleVo) {
//		model.addAttribute("id", roleVo.getId());
		return "sys/role/selectPermission";
	}
	
	/**
	 * 加载树的json和选中当前角色已有的权限
	 */
	@RequestMapping("initRolePermissionTree")
	@ResponseBody
	public List<ZtreeNode> initRolePermissionTree(RoleVo roleVo){
		List<ZtreeNode> nodes=new ArrayList<>();
		//查询所有的可用的权限和菜单  
		PermissionVo permissionVo=new PermissionVo();
		permissionVo.setAvailable(1);//查询可用的
		List<Permission> allPermissions=permissionService.queryPermissionForList(permissionVo);
		//查询已有的权限
		List<Permission> rolePermissions=permissionService.queryPermissionByRoleIdForList(roleVo.getId());
		for (Permission all : allPermissions) {
			Boolean checked=false;
			for (Permission permission : rolePermissions) {
				if(permission.getId()==all.getId()) {
					checked=true;
					break;
				}
			}
			Boolean isParent=all.getParent()==1?true:false;
			Boolean open=all.getSpread()==1?true:false;
			nodes.add(new ZtreeNode(all.getId(), all.getPid(), all.getName(), isParent, open, checked));
		}
		//返回
		return ZTreeNodeBuilder.build(nodes, 0);
	}
	
	
	/**
	 * 保存角色和权限之间的关系
	 */
	@RequestMapping("addRolePermission")
	@ResponseBody
	public Map<String,Object> addRolePermission(RoleVo roleVo){
		Map<String,Object> map=new HashMap<>();
		try {
			map.put("msg", "分配成功");
			this.roleService.addRolePermission(roleVo);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "分配失败");
		}
		return map;
	}
	
	
	
}
