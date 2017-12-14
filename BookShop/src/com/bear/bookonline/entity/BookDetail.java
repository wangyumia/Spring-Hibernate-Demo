package com.bear.bookonline.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="bookdetail")
public class BookDetail {
	private int bookid;
	private String bookname;
	private int bookcount;
	private String introduce;
	private double bookprice;
	private String bookimg1;
	private String bookimg2;
	private String bookimg3;
	private Book book;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getBookId() {
		return bookid;
	}
	public void setBookId(int bookid) {
		this.bookid = bookid;
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
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public double getBookprice() {
		return bookprice;
	}
	public void setBookprice(double bookprice) {
		this.bookprice = bookprice;
	}
	
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookimg1() {
		return bookimg1;
	}
	public void setBookimg1(String bookimg1) {
		this.bookimg1 = bookimg1;
	}
	public String getBookimg2() {
		return bookimg2;
	}
	public void setBookimg2(String bookimg2) {
		this.bookimg2 = bookimg2;
	}
	public String getBookimg3() {
		return bookimg3;
	}
	public void setBookimg3(String bookimg3) {
		this.bookimg3 = bookimg3;
	}
	@OneToOne(mappedBy="bookDetail",cascade=CascadeType.ALL)
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
}
