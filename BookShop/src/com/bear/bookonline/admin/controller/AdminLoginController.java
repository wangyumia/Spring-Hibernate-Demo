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
	@RequestMapping("adminlogin")
	public String loginUser(Model model,@RequestParam("adminname") String name,@RequestParam("adminpassword") String pwd,HttpSession session) {
		
		List<Admin> adminlist = this.adminRegistServiceImpl.listAllAdmin();
		model.addAttribute("adminlist", adminlist);
		for(int i = 0 ;i < adminlist.size();i++) {
			if((adminlist.get(i)).getAdminname().equals(name)&&adminlist.get(i).getAdminpassword().equals(pwd)) {
				model.addAttribute("adminname", name);
				model.addAttribute("adminpassword", pwd);
				session.setAttribute("admin",adminlist.get(i));
				return "Index";
			}
		}
		return "adminlogin";
		
	}
}
