package com.bear.bookonline.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="orderdetail")
public class OrderDetail {
	private int orderDetailid;
	private String username;
	private String bookname;
	private int bookcount;
	private double bookprice;
	private double totalprice;
	private Order order;
	@Id
	@GeneratedValue(generator="foreign")    
	@GenericGenerator(name="foreign",
	       strategy="foreign",     
	    	       parameters={@Parameter(
	    	    	       name="property",value="order")})
	public int getOrderDetailid() {
		return orderDetailid;
	}
	public void setOrderDetailid(int orderDetailid) {
		this.orderDetailid = orderDetailid;
	}
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getBookcount() {
		return bookcount;
	}
	public void setBookcount(int bookcount) {
		this.bookcount = bookcount;
	}
	public double getBookprice() {
		return bookprice;
	}
	public void setBookprice(double bookprice) {
		this.bookprice = bookprice;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	@OneToOne(mappedBy="orderDetail")
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
}
