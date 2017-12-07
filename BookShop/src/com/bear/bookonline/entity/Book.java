package com.bear.bookonline.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
@Table(name="book")
public class Book {
	private int id;
	private String name;
	private BookType bookType;
	private String publisher;
	private double price;
	private String picture;
	private BookDetail bookDetail;
	private Set cartItemSet = new HashSet<CartItem>();
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToOne
	@JoinColumn(name="typeid")
	public BookType getBookType() {
		return bookType;
	}
	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@OneToOne(cascade=CascadeType.ALL) 
	@PrimaryKeyJoinColumn(name="bookid") 
	public BookDetail getBookDetail() {
		return bookDetail;
	}
	public void setBookDetail(BookDetail bookDetail) {
		this.bookDetail = bookDetail;
	}
	@OneToMany(mappedBy="book",targetEntity=CartItem.class,cascade=CascadeType.ALL)
	public Set getCartItemSet() {
		return cartItemSet;
	}
	public void setCartItemSet(Set cartItemSet) {
		this.cartItemSet = cartItemSet;
	}
	
}
