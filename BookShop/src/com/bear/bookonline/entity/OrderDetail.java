package com.bear.bookonline.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private String bookimg1;
	private Order order;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
		this.totalprice =(this.bookprice)*(this.bookcount);
	}
	@ManyToOne(cascade = CascadeType.MERGE,optional = false,fetch = FetchType.LAZY)
	@JoinColumn(name="orderid")
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getBookimg1() {
		return bookimg1;
	}
	public void setBookimg1(String bookimg1) {
		this.bookimg1 = bookimg1;
	}
	
}
