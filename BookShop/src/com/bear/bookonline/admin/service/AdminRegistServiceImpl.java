package com.bear.bookonline.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bear.bookonline.admin.dao.AdminRegistDaoImpl;
import com.bear.bookonline.entity.Admin;

@Service
@Transactional
public class AdminRegistServiceImpl {
	@Resource
	//将dao层获取到的数据库信息注入给sevice层
	private AdminRegistDaoImpl adminRegistDaoImpl;
	//调用dao层的方法将管理员信息存储到列表中
	public List<Admin>listAllAdmin(){
		return this.adminRegistDaoImpl.findAllAdmin();
	}
	//调用dao层的方法保存管理员信息
	public void saveAdmin(Admin admin) {
		this.adminRegistDaoImpl.saveAdmin(admin);
	}
}
