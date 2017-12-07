package com.bear.bookonline.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="user")
public class User {
	private int userid;
	private String username;
	private String telephone;
	private String address;
	private String email;
	private String password;
	private Set<Order> orderSet = new HashSet<Order>();
	private ShoppingCart shoppingCart;
	private Set logSet = new HashSet<Log>();
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(mappedBy="user", targetEntity=Order.class,  cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<Order> getOrderSet() {
		return orderSet;
	}
	public void setOrderSet(Set orderSet) {
		this.orderSet = orderSet;
	}
	@OneToMany(mappedBy="user", targetEntity=Log.class, 
	        cascade=CascadeType.ALL)

	public Set getLogSet() {
		return logSet;
	}
	public void setLogSet(Set logSet) {
		this.logSet = logSet;
	}
	@OneToOne(cascade=CascadeType.ALL) 
	@PrimaryKeyJoinColumn(name="id") 
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
