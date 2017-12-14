package com.bear.bookonline.user.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bear.bookonline.entity.User;
import com.bear.bookonline.user.service.UserRegistServiceImpl;

@Controller

public class UserLoginController {
	@Resource
	private UserRegistServiceImpl userRegistServiceImpl;
	/**
	 * 获取到用户在登录界面的username 和password
	 * 用来和数据库中的数据进行匹配，如果用户名和密码匹配  则跳转到book/list1这个控制器
	 * 如果没有匹配上，那就是用户名不存在或者密码输入错误，返回到登录界面
	 * @param model
	 * @param name
	 * @param pwd
	 * @param session
	 * @return
	 */
	@RequestMapping("userlogin")
	public String loginUser(Model model,@RequestParam("username") String name,@RequestParam("password") String pwd,HttpSession session) {
		session.removeAttribute("shoppingCartSet");
		List<User> userlist = this.userRegistServiceImpl.listAllUser();
		for(int i = 0 ;i < userlist.size();i++) {
			if(((userlist.get(i)).getUsername()).equals(name)&&userlist.get(i).getPassword().equals(pwd)) {
				model.addAttribute("username", name);
				model.addAttribute("password", pwd);
				session.setAttribute("user",userlist.get(i));
				session.setAttribute("shoppingcart",userlist.get(i).getOrderSet());
				return "redirect:book/list1";
			}
		}
		return "login";
		
	}
	/**
	 * 用户点击退出登录按钮，会执行这个控制器，废弃session会话，执行book/list1控制器，跳转到前台展示界面
	 * @param session
	 * @return
	 */
	@RequestMapping("useroff")
	public String useroff(HttpSession session) {
		session.invalidate();
		return "redirect:book/list1";
	}

}
