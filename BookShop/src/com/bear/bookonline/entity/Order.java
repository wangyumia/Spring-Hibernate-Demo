package com.bear.bookonline.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	private int orderid;
	private String username;
	private User user;
	private Set<OrderDetail> orderDetailSet = new HashSet<OrderDetail>();
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	@ManyToOne(cascade = CascadeType.MERGE,optional = false,fetch = FetchType.LAZY)
	@JoinColumn(name="userid")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@OneToMany(mappedBy="order",targetEntity=OrderDetail.class,cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	public Set<OrderDetail> getOrderDetailSet() {
		return orderDetailSet;
	}
	public void setOrderDetailSet(Set orderDetailSet) {
		this.orderDetailSet = orderDetailSet;
	}
	
}
