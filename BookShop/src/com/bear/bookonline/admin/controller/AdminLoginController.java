package com.bear.bookonline.admin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bear.bookonline.admin.service.AdminRegistServiceImpl;
import com.bear.bookonline.entity.Admin;
import com.bear.bookonline.entity.User;
import com.bear.bookonline.user.service.UserRegistServiceImpl;
@Controller
public class AdminLoginController {
	@Resource
	private AdminRegistServiceImpl adminRegistServiceImpl;
	/**
	 * 获取到管理员在登录界面的adminname 和adminpassword
	 * 用来和数据库中的数据进行匹配，如果用户名和密码匹配  则跳转到book/list这个控制器
	 * 如果没有匹配上，那就是用户名不存在或者密码输入错误，返回到登录界面
	 * @param model
	 * @param name
	 * @param pwd
	 * @param session
	 * @return
	 */
	@RequestMapping("adminlogin")
	public String loginUser(Model model,@RequestParam("adminname") String name,@RequestParam("adminpassword") String pwd,HttpSession session) {
		
		List<Admin> adminlist = this.adminRegistServiceImpl.listAllAdmin();
		model.addAttribute("adminlist", adminlist);
		for(int i = 0 ;i < adminlist.size();i++) {
			if((adminlist.get(i)).getAdminname().equals(name)&&adminlist.get(i).getAdminpassword().equals(pwd)) {
				session.setAttribute("adminname", name);
				session.setAttribute("adminpassword", pwd);
				session.setAttribute("admin",adminlist.get(i));
				return "redirect:book/list";
			}
		}
		return "adminlogin";
		
	}
	/**
	 * 后台管理员点击退出登录按钮，会执行这个控制器，废弃session会话，执行book/list控制器，跳转到后台展示界面
	 * @param session
	 * @return
	 */
	@RequestMapping("adminoff")
	public String adminoff(HttpSession session) {
		session.invalidate();
		return "redirect:book/list";
	}
}
