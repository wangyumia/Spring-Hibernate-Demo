package com.bear.bookonline.admin.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bear.bookonline.admin.service.AdminRegistServiceImpl;
import com.bear.bookonline.entity.Admin;
import com.bear.bookonline.entity.User;

@Controller
@RequestMapping("admin")
public class AdminRegistController {
	@Resource
	private AdminRegistServiceImpl adminRegistServiceImpl;
	@RequestMapping("/saveadmin")
	/**
	 * 管理员注册  
	 * 先获取到数据库中的管理员信息，存到adminList列表中
	 * 再获取到注册界面管理员输入的admin 和adminpassword 
	 * 如果和数据库中数据一致，则返回到登录界面
	 *否则将新输入的数据存到数据库中保存，返回到登录界面
	 * @param model
	 * @param name
	 * @param pwd
	 * @return
	 */
	public String addAdmin(Model model,@RequestParam("adminname") String name,@RequestParam("adminpassword") String pwd) {
		List<Admin> adminList = this.adminRegistServiceImpl.listAllAdmin();
		model.addAttribute("adminList", adminList);
		for(int i = 0 ;i < adminList.size();i++) {
			if(((adminList.get(i)).getAdminname()).equals(name)) {
				return "adminlogin";
			}
		}
		Admin admin = new Admin();
		admin.setAdminname(name);
		admin.setAdminpassword(pwd);
		this.adminRegistServiceImpl.saveAdmin(admin);
		model.addAttribute("admin", admin);
		return "adminlogin";
	}
	
}
