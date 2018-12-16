package com.sxt.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.sys.domain.User;
import com.sxt.sys.service.UserService;
import com.sxt.sys.utils.DataGridView;
import com.sxt.sys.utils.Md5Utils;
import com.sxt.sys.vo.UserVo;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	

	@RequestMapping("toUserManager")
	public String toUserManager() {
		return "sys/user/userManager";
	}

	/**
	 * 跳转到左边的部门菜单
	 * 
	 * @return
	 */
	@RequestMapping("toUserLeft")
	public String toUserLeft() {
		return "sys/user/userLeft";
	}

	/**
	 * 跳转到用户右边的用户列表
	 * 
	 */
	@RequestMapping("toUserRight")
	public String toUserRight() {
		return "sys/user/userRight";
	}


	/**
	 * 查询右侧的用户具体信息
	 */
	@RequestMapping("queryAllUsers")
	@ResponseBody
	public DataGridView queryAllUsers(UserVo vo) {
		DataGridView dataGridView = this.userService.queryAllUser(vo);
		return dataGridView;
	}
	
	/**
	 * 跳转到添加用户页面
	 */
	@RequestMapping("toUserAdd")
	public String toUserAdd() {
		return "sys/user/userAdd";
	}
	
	
	/**
	 * 添加
	 */
	@RequestMapping("addUser")
	@ResponseBody
	public Map<String,Object> addUser(UserVo userVo){
		Map<String, Object> map=new HashMap<>();
		String msg="添加成功";
		try {
			//做添加
			//设置默认的类型type=1
			userVo.setType(1);;
			//设置默认密码123456
			String pwd="123456";
			String salt = userVo.getAddress()+userVo.getName();
			String userPwd = Md5Utils.encodePasswordUseMd5(pwd, salt, 2);
			userVo.setPwd(userPwd);
			//设置默认的图片../resources/images/defaulttitle.jpg
			userVo.setImgpath("../resources/images/defaulttitle.jpg");
			this.userService.addUser(userVo);
		} catch (Exception e) {
			msg="添加失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	
	/**
	 * 跳转到修改用户页面
	 */
	/**
	 * 跳转到修改页面
	 */
	@RequestMapping("toUpdateUser")
	public String toUpdateUser(UserVo userVo,Model model) {
		User user1=this.userService.queryUserById(userVo.getId());
		model.addAttribute("user1", user1);
		//再根据用户的id查询到领导的id
		User user2=this.userService.queryUserById(user1.getMgr());
		model.addAttribute("user2", user2);
		return "sys/user/userUpdate";
	}
	
	/**
	 * 通过部门id查询该部门的所有员工
	 * @param vo
	 * @return
	 */
	@RequestMapping("loadAllUserByDeptId")
	@ResponseBody
	public List<User>loadAllUserByDeptId(UserVo vo){
		return this.userService.loadAllUserByDeptId(vo);
		
	}
	/**
	 * 修改用户
	 */
	@RequestMapping("updateUser")
	@ResponseBody
	public Map<String,Object> updateUser(UserVo userVo){
		Map<String, Object> map=new HashMap<>();
		String msg="修改成功";
		try {
			//做修改
			this.userService.updateUser(userVo);
		} catch (Exception e) {
			msg="修改失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	
	/**
	 * 删除
	 */
	@RequestMapping("deleteUser")
	@ResponseBody
	public Map<String,Object> deleteUser(UserVo userVo){
		Map<String, Object> map=new HashMap<>();
		String msg="删除成功";
		try {
			//做删除
			this.userService.deleteUser(userVo.getId());
		} catch (Exception e) {
			msg="删除失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	/**
	 * 批量删除
	 */
	@RequestMapping("batchDeleteUser")
	@ResponseBody
	public Map<String,Object> batchDeleteUser(UserVo userVo){
		Map<String, Object> map=new HashMap<>();
		String msg="删除成功";
		try {
			//删除
			Integer[] ids=userVo.getIds();
			if(null!=ids&&ids.length>0) {
				for (Integer integer : ids) {
					this.userService.deleteUser(integer);
				}
			}
		} catch (Exception e) {
			msg="删除失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	/**
	 * 跳转到分配页面
	 * @param vo
	 * @return
	 */
	@RequestMapping("toSelectUserRole")
	public String toSelectUserRole(UserVo vo) {
		
		return "sys/user/selectUserRole";
		
	}
	
	/**
	 * 加载用户拥有的角色的具体信息
	 * @param vo
	 * @return
	 */
	@RequestMapping("loadAllUserRoles")
	@ResponseBody
	public DataGridView loadAllUserRoles(UserVo vo) {
		
	
		return this.userService.loadAllUserRoles(vo);
	}
	
	
	@RequestMapping("addUserRoles")
	@ResponseBody
	public Map<String, Object>addUserRoles(UserVo vo){
		
			Map<String, Object> map=new HashMap<>();
			String msg="分配成功";
			try {
				this.userService.addUserRoles(vo);
			} catch (Exception e) {
				msg="分配失败"+e.getMessage();
			}
			map.put("msg", msg);
			return map;
	}
	
	@RequestMapping("resetPwd")
	@ResponseBody
	public Map<String, Object>resetPwd(UserVo vo){
		
		Map<String, Object> map=new HashMap<>();
		String msg="重置成功";
		try {
			this.userService.resetPwd(vo);
		} catch (Exception e) {
			msg="重置失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
}
	
}
