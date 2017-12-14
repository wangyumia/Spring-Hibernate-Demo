package com.bear.bookonline.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bear.bookonline.entity.User;

@Repository
public class UserRegistDaoImpl {
	@Resource
	//给它注入SessionFactory,负责创建session 对象
	private SessionFactory sessionFactory;
	
	/**
	 * 用hql语句在数据库admin表中查询所有用户的信息，返回给q
	 * @return
	 */
	public List<User>findAllUser(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from User");
		return q.list();
	}
	
	//保存新注册的用户信息
	public void saveUser(User user) {
		this.sessionFactory.getCurrentSession().save(user);
	}
}
