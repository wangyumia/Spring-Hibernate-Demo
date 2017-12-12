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
	private AdminRegistDaoImpl adminRegistDaoImpl;
	public List<Admin>listAllAdmin(){
		return this.adminRegistDaoImpl.findAllAdmin();
	}
	public void saveAdmin(Admin admin) {
		this.adminRegistDaoImpl.saveAdmin(admin);
	}
}
