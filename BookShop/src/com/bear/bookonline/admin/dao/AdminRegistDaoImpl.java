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
	//给它注入SessionFactory,负责创建session 对象
	
	private SessionFactory sessionFactory;
	
	/**
	 * 用hql语句在数据库admin表中查询所有管理员的信息，返回给q
	 * @return
	 */
	public List<Admin> findAllAdmin(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Admin");
		return q.list();
	}
	//保存新注册的管理员信息
	public void saveAdmin(Admin admin) {
		this.sessionFactory.getCurrentSession().save(admin);
	}
	
}
