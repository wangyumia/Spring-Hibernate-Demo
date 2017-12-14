package com.bear.bookonline.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bear.bookonline.entity.User;
import com.bear.bookonline.user.dao.UserRegistDaoImpl;

@Service
@Transactional
public class UserRegistServiceImpl {
	@Resource
	//将dao层获取到的数据库信息注入给sevice层
	private UserRegistDaoImpl userRegistDaoImpl;
	
	//调用dao层的方法将用户信息存储到列表中
	public List<User> listAllUser(){
		return this.userRegistDaoImpl.findAllUser();
	}
	//调用dao层的方法保存用户信息
	public void saveUser(User user) {
		this.userRegistDaoImpl.saveUser(user);
	}
}
