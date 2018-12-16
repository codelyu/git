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
import com.sxt.sys.service.PermissionService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.utils.ZtreeNode;
import com.sxt.sys.vo.PermissionVo;

@Controller
@RequestMapping("menu")
public class MenuController {

	@Autowired
	private PermissionService permissionService;

	@RequestMapping("toMenuManager")
	public String toMenuManager() {
		return "sys/menu/menuManager";
	}

	/**
	 * 跳转到部门左边的树
	 * 
	 * @return
	 */
	@RequestMapping("toMenuLeft")
	public String toMenuLeft() {
		return "sys/menu/menuLeft";
	}

	/**
	 * 跳转到部门右边的部门列表
	 * 
	 */
	@RequestMapping("toMenuRight")
	public String toMenuRight() {
		return "sys/menu/menuRight";
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
	@RequestMapping("queryAllMenus")
	@ResponseBody
	public DataGridView queryAllMenus(PermissionVo vo) {
		DataGridView dataGridView = this.permissionService.queryAllPermissions(vo);
		return dataGridView;
	}
	
	/**
	 * 跳转到添加部门页面
	 */
	@RequestMapping("toMenuAdd")
	public String toMenuAdd() {
		return "sys/menu/menuAdd";
	}
	
	
	/**
	 * 添加
	 */
	@RequestMapping("addMenu")
	@ResponseBody
	public Map<String,Object> addMenu(PermissionVo permissionVo){
		Map<String, Object> map=new HashMap<>();
		String msg="添加成功";
		try {
			//做添加
			this.permissionService.addPermission(permissionVo);
		} catch (Exception e) {
			msg="添加失败"+e.getMessage();
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
	@RequestMapping("toUpdateMenu")
	public String toUpdateMenu(PermissionVo permissionVo,Model model) {
		Permission permission=this.permissionService.queryPermissionById(permissionVo.getId());
		model.addAttribute("permission", permission);
		return "sys/menu/menuUpdate";
	}
	
	/**
	 * 修改部门
	 */
	@RequestMapping("updateMenu")
	@ResponseBody
	public Map<String,Object> updateMenu(PermissionVo permissionVo){
		Map<String, Object> map=new HashMap<>();
		String msg="修改成功";
		try {
			//做修改
			this.permissionService.updatePermission(permissionVo);
		} catch (Exception e) {
			msg="修改失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	
	/**
	 * 删除
	 */
	@RequestMapping("deleteMenu")
	@ResponseBody
	public Map<String,Object> deleteMenu(PermissionVo permissionVo){
		Map<String, Object> map=new HashMap<>();
		String msg="删除成功";
		try {
			//做删除
			this.permissionService.deletePermission(permissionVo.getId());
		} catch (Exception e) {
			msg="删除失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	/**
	 * 批量删除
	 */
	@RequestMapping("batchDeleteMenu")
	@ResponseBody
	public Map<String,Object> batchDeleteMenu(PermissionVo permissionVo){
		Map<String, Object> map=new HashMap<>();
		String msg="删除成功";
		try {
			//删除
			Integer[] ids=permissionVo.getIds();
			if(null!=ids&&ids.length>0) {
				for (Integer integer : ids) {
					this.permissionService.deletePermission(integer);
				}
			}
		} catch (Exception e) {
			msg="删除失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	
	
}
