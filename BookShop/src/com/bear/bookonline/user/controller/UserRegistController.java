package com.bear.bookonline.user.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bear.bookonline.entity.User;
import com.bear.bookonline.user.service.UserRegistServiceImpl;

@Controller
@RequestMapping("user")
public class UserRegistController {
	@Resource
	private UserRegistServiceImpl userRegistServiceImpl;
	/**
	 * 管理员注册  
	 * 先获取到数据库中的管理员信息，存到userList列表中
	 * 再获取到注册界面管理员输入的username 、password、tel、address、email 
	 * 如果和数据库中数据一致，则返回到登录界面
	 *否则将新输入的数据存到数据库中保存，返回到登录界面
	 * @param model
	 * @param name
	 * @param pwd
	 * @param tel
	 * @param address
	 * @param email
	 * @return
	 */
	@RequestMapping("saveuser")
	public String addUser(Model model,@RequestParam("username") String name,@RequestParam("password") String pwd,
			@RequestParam("tel") String tel,@RequestParam("address") String address,
			@RequestParam("email") String email) {
		List<User> userList = this.userRegistServiceImpl.listAllUser();
		for(int i = 0 ;i < userList.size();i++) {
			if(((userList.get(i)).getUsername()).equals(name)) {
				model.addAttribute("error", "该用户已经注册,请进行登录！");
				return "login";
			}
		}
		User user = new User();
		user.setUsername(name);
		user.setPassword(pwd);
		user.setTelephone(tel);
		user.setAddress(address);
		user.setEmail(email);
		this.userRegistServiceImpl.saveUser(user);
		model.addAttribute("user", user);
		return "login";
	}

}
