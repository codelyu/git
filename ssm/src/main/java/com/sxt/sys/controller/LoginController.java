package com.sxt.sys.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxt.sys.domain.User;
import com.sxt.sys.vo.UserVo;

@Controller
@RequestMapping("login")
public class LoginController {
	//跳转到登录页面
	@RequestMapping("toLoginJsp")
	public String toLoginJsp() {
		return "sys/main/login";
	}
	
	
	//验证登录信息
	@RequestMapping("loginCheck")
	public String checkLogin(User user,HttpSession session,Model model) {
		AuthenticationToken token =new UsernamePasswordToken(user.getLoginname(),user.getPwd(), true);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			UserVo activerUser=(UserVo) subject.getPrincipal();
			session.setAttribute("user", activerUser);
			return "sys/main/index";
		}  catch (IncorrectCredentialsException e) {
			System.out.println("密码不正确");
			model.addAttribute("error",  "密码不正确");
			return "sys/main/login";
		} catch (UnknownAccountException e) {
			System.out.println("用户不存在");
			model.addAttribute("error",  "用户不存在");
			return "sys/main/login";
		}
	}
}
