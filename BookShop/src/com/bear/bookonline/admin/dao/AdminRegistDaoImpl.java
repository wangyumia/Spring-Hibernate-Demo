package com.bear.bookonline.admin.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bear.bookonline.entity.Admin;

@Repository
public class AdminRegistDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	public List<Admin> findAllAdmin(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Admin");
		return q.list();
	}
	public void saveAdmin(Admin admin) {
		this.sessionFactory.getCurrentSession().save(admin);
	}
	
}
