package com.bear.bookonline.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="shoppingcart")
public class ShoppingCart {
	private int id;
	private User user;
	private double bookprice;
	private Set CartItemSet =new HashSet<CartItem>();
	@Id
	@GeneratedValue(generator="foreign")    
	@GenericGenerator(name="foreign",strategy="foreign",parameters={@Parameter(name="property",value="user")})
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@OneToOne(mappedBy="shoppingCart")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@OneToMany(mappedBy="shoppingCart", targetEntity=CartItem.class, cascade=CascadeType.ALL)
	
	public Set getCartItemSet() {
		return CartItemSet;
	}
	public void setCartItemSet(Set cartItemSet) {
		CartItemSet = cartItemSet;
	}
	public double getBookprice() {
		return bookprice;
	}
	public void setBookprice(double bookprice) {
		this.bookprice = bookprice;
	}
	
	
}
