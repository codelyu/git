package com.sxt.sys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.sys.constast.SYS_Constast;
import com.sxt.sys.domain.Permission;
import com.sxt.sys.domain.User;
import com.sxt.sys.service.PermissionService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.utils.TreeNode;
import com.sxt.sys.utils.TreeNodeBuilder;
import com.sxt.sys.utils.ZtreeNode;
import com.sxt.sys.vo.PermissionVo;

@Controller
@RequestMapping("permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;

	@RequestMapping("loadIndexLeftTree")
	@ResponseBody
	/**
	 * 加载主页左边的菜单项
	 * @param vo
	 * @param session
	 * @return
	 */
	public List<TreeNode> loadIndexLeftTree(PermissionVo vo, HttpSession session) {
		//1,查询当前用户的所有权限  type=permission【先查询所有的】 
				List<TreeNode> nodes=new ArrayList<>();
				//得到当前登陆的用户
				User user=(User) session.getAttribute("user");
				Integer id = user.getId();
				System.out.println(id +"+======================");
				List<Permission> permissions=null;
				if(user.getType()==SYS_Constast.USER_TYPE_SUPER) {
					vo.setType(SYS_Constast.PERMISSION_TYPE_MENU);
					permissions=this.permissionService.queryPermissionForList(vo);
				}else {
					//根据用户id查询菜单
					permissions=this.permissionService.queryPermissionByUserIdForList(user.getId(),SYS_Constast.PERMISSION_TYPE_MENU);
				}
				for (Permission p : permissions) {
					boolean spread=p.getSpread()==1?true:false;
					nodes.add(new TreeNode(p.getId(), p.getPid(), p.getName(), p.getHref(), p.getIcon(), spread));
				}
				//构造树的对象 
				return TreeNodeBuilder.build(nodes, 1);
	}

	

	@RequestMapping("toPermissionManager")
	public String toPermissionManager() {
		return "sys/permission/permissionManager";
	}

	/**
	 * 跳转到部门左边的树
	 * 
	 * @return
	 */
	@RequestMapping("toPermissionLeft")
	public String toPermissionLeft() {
		return "sys/permission/permissionLeft";
	}

	/**
	 * 跳转到部门右边的部门列表
	 * 
	 */
	@RequestMapping("toPermissionRight")
	public String toPermissionRight() {
		return "sys/permission/permissionRight";
	}

	/**
	 * 得到部门树的具体信息
	 */
	@RequestMapping("loadLeftZtree")
	@ResponseBody
	public List<ZtreeNode> loadLeftZtree() {
		Permission record = new Permission();
		record.setType("menu");
		List<ZtreeNode> nodes = new ArrayList<>();
		List<Permission> permissions = this.permissionService.queryPermissionForList(record);
		for (Permission permission : permissions) {
			Boolean isParent = permission.getParent() == 1 ? true : false;
			Boolean open = permission.getSpread() == 1 ? true : false;
			nodes.add(new ZtreeNode(permission.getId(), permission.getPid(), permission.getName(), isParent, open));
		}
		return nodes;
	}

	/**
	 * 查询右侧的部门具体信息
	 */
	@RequestMapping("queryAllPermissions")
	@ResponseBody
	public DataGridView queryAllPermissions(PermissionVo vo) {
		vo.setType("permission");
		DataGridView dataGridView = this.permissionService.queryAllPermissions(vo);
		return dataGridView;
	}

	/**
	 * 跳转到添加部门页面
	 */
	@RequestMapping("toPermissionAdd")
	public String toPermissionAdd() {
		return "sys/permission/permissionAdd";
	}

	/**
	 * 添加
	 */
	@RequestMapping("addPermission")
	@ResponseBody
	public Map<String, Object> addPermission(PermissionVo permissionVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "添加成功";
		try {
			// 做添加
			this.permissionService.addPermission(permissionVo);
		} catch (Exception e) {
			msg = "添加失败" + e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}

	/**
	 * 跳转到修改部门页面
	 */
	/**
	 * 跳转到修改页面
	 */
	@RequestMapping("toUpdatePermission")
	public String toUpdatePermission(PermissionVo permissionVo, Model model) {
		Permission permission = this.permissionService.queryPermissionById(permissionVo.getId());
		model.addAttribute("permission", permission);
		return "sys/permission/permissionUpdate";
	}

	/**
	 * 修改部门
	 */
	@RequestMapping("updatePermission")
	@ResponseBody
	public Map<String, Object> updatePermission(PermissionVo permissionVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "修改成功";
		try {
			// 做修改
			this.permissionService.updatePermission(permissionVo);
		} catch (Exception e) {
			msg = "修改失败" + e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}

	/**
	 * 删除
	 */
	@RequestMapping("deletePermission")
	@ResponseBody
	public Map<String, Object> deletePermission(PermissionVo permissionVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "删除成功";
		try {
			// 做删除
			this.permissionService.deletePermission(permissionVo.getId());
		} catch (Exception e) {
			msg = "删除失败" + e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}

	/**
	 * 批量删除
	 */
	@RequestMapping("batchDeletePermission")
	@ResponseBody
	public Map<String, Object> batchDeletePermission(PermissionVo permissionVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "删除成功";
		try {
			// 删除
			Integer[] ids = permissionVo.getIds();
			if (null != ids && ids.length > 0) {
				for (Integer integer : ids) {
					this.permissionService.deletePermission(integer);
				}
			}
		} catch (Exception e) {
			msg = "删除失败" + e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}

}
