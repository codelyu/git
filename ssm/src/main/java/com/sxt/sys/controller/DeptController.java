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

import com.sxt.sys.domain.Dept;
import com.sxt.sys.service.DeptService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.utils.ZtreeNode;
import com.sxt.sys.vo.DeptVo;

@Controller
@RequestMapping("dept")
public class DeptController {

	@Autowired

	private DeptService deptService;

	@RequestMapping("toDeptManager")
	public String toDeptManager() {
		return "sys/dept/deptManager";
	}

	/**
	 * 跳转到部门左边的树
	 * 
	 * @return
	 */
	@RequestMapping("toDeptLeft")
	public String toDeptLeft() {
		return "sys/dept/deptLeft";
	}

	/**
	 * 跳转到部门右边的部门列表
	 * 
	 */
	@RequestMapping("toDeptRight")
	public String toDeptRight() {
		return "sys/dept/deptRight";
	}

	/**
	 * 得到部门树的具体信息
	 */
	@RequestMapping("loadLeftZtree")
	@ResponseBody
	public List<ZtreeNode> loadLeftZtree() {
		Dept record = null;
		List<ZtreeNode> nodes = new ArrayList<>();
		List<Dept> depts = this.deptService.queryAllDept(record);
		for (Dept dept : depts) {
			Boolean isParent = dept.getParent() == 1 ? true : false;
			Boolean open = dept.getSpread() == 1 ? true : false;
			nodes.add(new ZtreeNode(dept.getId(), dept.getPid(), dept.getName(), isParent, open));
		}
		return nodes;
	}

	/**
	 * 查询右侧的部门具体信息
	 */
	@RequestMapping("queryAllDepts")
	@ResponseBody
	public DataGridView queryAllDepts(DeptVo vo) {
		DataGridView dataGridView = this.deptService.queryAllDept(vo);
		return dataGridView;
	}
	
	/**
	 * 跳转到添加部门页面
	 */
	@RequestMapping("toAddDept")
	public String toDeptAdd() {
		return "sys/dept/deptAdd";
	}
	
	
	/**
	 * 添加
	 */
	@RequestMapping("addDept")
	@ResponseBody
	public Map<String,Object> addDept(DeptVo deptVo){
		Map<String, Object> map=new HashMap<>();
		String msg="添加成功";
		try {
			//做添加
			this.deptService.addDept(deptVo);
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
	@RequestMapping("toUpdateDept")
	public String toUpdateDept(DeptVo deptVo,Model model) {
		Dept dept=this.deptService.queryDeptById(deptVo.getId());
		model.addAttribute("dept", dept);
		return "sys/dept/deptUpdate";
	}
	
	/**
	 * 修改部门
	 */
	@RequestMapping("updateDept")
	@ResponseBody
	public Map<String,Object> updateDept(DeptVo deptVo){
		Map<String, Object> map=new HashMap<>();
		String msg="修改成功";
		try {
			//做修改
			this.deptService.updateDept(deptVo);
		} catch (Exception e) {
			msg="修改失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	
	/**
	 * 删除
	 */
	@RequestMapping("deleteDept")
	@ResponseBody
	public Map<String,Object> deleteDept(DeptVo deptVo){
		Map<String, Object> map=new HashMap<>();
		String msg="删除成功";
		try {
			//做删除
			this.deptService.deleteDept(deptVo.getId());
		} catch (Exception e) {
			msg="删除失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	/**
	 * 批量删除
	 */
	@RequestMapping("batchDeleteDept")
	@ResponseBody
	public Map<String,Object> batchDeleteDept(DeptVo deptVo){
		Map<String, Object> map=new HashMap<>();
		String msg="删除成功";
		try {
			//删除
			Integer[] ids=deptVo.getIds();
			if(null!=ids&&ids.length>0) {
				for (Integer integer : ids) {
					this.deptService.deleteDept(integer);
				}
			}
		} catch (Exception e) {
			msg="删除失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	
	
}
