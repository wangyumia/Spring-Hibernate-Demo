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
