package com.bear.bookonline.book.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bear.bookonline.entity.Book;
import com.bear.bookonline.entity.BookDetail;
import com.bear.bookonline.entity.BookType;
import com.bear.bookonline.entity.CartItem;
import com.bear.bookonline.entity.Order;
import com.bear.bookonline.entity.OrderDetail;
import com.bear.bookonline.entity.ShoppingCart;
import com.bear.bookonline.entity.User;

@Repository

public class BookDaoImpl {
	@Resource
	//注入session工厂，负责创建session
	private SessionFactory sessionFactory;
	
	/**
	 * 查询book表中的所有数据
	 * @return 一个列表
	 */
	public List<Book> findAll(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Book");
		return q.list();
	}
	/**
	* 分页查询
	* @param hql 查询的条件
	* @param offset 开始记录
	* @param length 一次查询几条记录
	* @return 返回查询记录集合
	*/
	 public List<Book> queryForPage(int offset, int length) {
	       //从book表中查询所有的记录数
	       Query query= (Query) sessionFactory.getCurrentSession().createQuery("from Book");  
	       //设置第一条记录起始的位置
	        query.setFirstResult(offset);
	        //设置最大记录数
	        query.setMaxResults(length);            
	        return query.list(); 
	  }
	 //保存Book对象
	 public void save(Book st){
	     sessionFactory.getCurrentSession().save(st);
	 }
	 //更新Book对象
	 public void update(Book st) {   
	     sessionFactory.getCurrentSession().update(st);
	  }
	 //删除Book对象
	 public void delete(Book st) {      
	     sessionFactory.getCurrentSession().delete(st);
	 }
	 //查询记录总数
	 public int getAllRowCount(){
	     int count=((Long) sessionFactory.getCurrentSession().createQuery( "select count(*) from Book").iterate().next()).intValue();
	         return count;  
	 }
	 /**
	  * 根据book 中的id 查询数据，得到一个book对象
	  * @param id
	  * @return book 对象
	  */
	 public Book QueryById(int id) {
	     Book st =(Book) sessionFactory.getCurrentSession().get(Book.class, id);
	     return st;
	 }
	 /**
	  * 同过页面上传进来的图书类型的id值 来查询图书的信息
	  * 并将每一类图书分类
	  * @param typeid
	  * @return 一个带有类型的图书列表
	  */
	 public List<Book> QueryByTypeid(int typeid) {
		 Query q = this.sessionFactory.getCurrentSession().createQuery("from Book where typeid=?");
		 q.setParameter(0, typeid);
		 return q.list();
	 }
	 /**
	  * 通过typeid 在booktype表中查询到图书的所有类型信息
	  * @param typeid
	  * @return 
	  */
	 public List<BookType> findAllType(int typeid){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from BookType where typeid=?");
		q.setParameter(0, typeid);
		return q.list();
	 }
	 //查询所有的图书类型
	 public List<BookType> findAllType(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from BookType");
		return q.list();
	} 
	 
	 /**
	  * 根据bookid去bookdetail表中查询bookdetail的所有信息 
	  * @param bookid  页面传过来的采参数
	  * @return bookdetail 列表
	  */
	 public List<BookDetail> findAllDetail(int bookid){
	   	Query q = this.sessionFactory.getCurrentSession().createQuery("from BookDetail where bookid=?");
	    q.setParameter(0, bookid);
	    return q.list();
	}
	 /**
	  * 根据bookname 查询bookdetail表中的所有数据
	  * @param bookname 页面上传进来的参数
	  * @return bookdetail 列表
	  */
	 public List<BookDetail> findAllDetail(String bookname){
	    Query q = this.sessionFactory.getCurrentSession().createQuery("from BookDetail where bookname=?");
	    q.setParameter(0,bookname);
	    return q.list();
	}
	
	 /**
	  * 根据bookid 查询，返回一个BookDetail对象
	  * @param bookid
	  * @return  BookDetail对象
	  */
	public BookDetail findAllDetail1(int bookid) {
		 return this.sessionFactory.getCurrentSession().get(BookDetail.class,bookid);
				   
	}
	/**将要买的图书保存到购物车里面
	 * 用户和自己的购物车对应一一对应
	 * @param user
	 * @param id
	 */
    public void saveShopping(User user,int id) {
    	//得到一个session对象
    	Session session = sessionFactory.getCurrentSession();
    	/**
    	 * 创建用户的订单，如果用户的订单为空，则创建一个订单
    	 * 如果不为空的话，就得到用户的所有订单
    	 */
		Order order = null;
		if(user.getOrderSet().size()<=0) {
			order = new Order();
		}else {
			Set<Order> orderset = user.getOrderSet();
			for(Order o :orderset) {
				order = o;
			}
		}
			//建立用户和订单之间的联系
			order.setUser(user);
			user.getOrderSet().add(order);
			//更新用户
			session.update(user);
			//保存用户的订单信息
			session.save(order);
			//将id传进findAllDetail1方法中，得到查到的bookdetail对象
			BookDetail bookdetail = this.findAllDetail1(id);
			//创建一个订单详情
			OrderDetail orderdetail = new OrderDetail();
			//在订单详情中设置用户的信息和图书的详细信息
			orderdetail.setUsername(user.getUsername());
			orderdetail.setBookname(bookdetail.getBookname());
			orderdetail.setBookcount(bookdetail.getBookcount());
			orderdetail.setBookprice(bookdetail.getBookprice());
			
			//建立order与orderdetail的关联
			orderdetail.setOrder(order);
			order.getOrderDetailSet().add(orderdetail);
			
			
			//保存订单详情更新订单信息
			session.save(orderdetail);
			session.update(order);
			
	}
    //删除订单详情中的订单信息
	public void deleteByOrderDetail(OrderDetail od) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(od);
	}
	//根据id得到OrderDetail对象
	public OrderDetail findByOrderDetailid(int id) {
		return this.sessionFactory.getCurrentSession().get(OrderDetail.class, id);
	}
	
	public List<BookDetail> findAllDetail(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from BookDetail");
		return q.list();
	}
	//根据类型名字返回一个BookType类型的对象
	public BookType findAllType(String typename) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from BookType where typename=?");
		q.setParameter(0, typename);
		return (BookType) q.uniqueResult();
	}
	
	/**
	 * 在后台实现增加图书的功能
	 * 根据类型名字来查询图书的类型
	 * @param bookdetail
	 * @param typename
	 */
	public void save(BookDetail bookdetail,String typename) {
		
		BookType bt = this.findAllType(typename);
		
		Book book = new Book();
		book.setName(bookdetail.getBookname());
		book.setPrice(bookdetail.getBookprice());
		book.setPicture(bookdetail.getBookimg1());
		book.setBookType(bt);
		
		//Book  和BookDetail 建立关联
		book.setBookDetail(bookdetail);
		bookdetail.setBook(book);
		//保存book和bookdetail
		Session session = this.sessionFactory.getCurrentSession();
		session.save(book);
		session.save(bookdetail);
	}
	
	/**根据bookid从bookdetail中删除指定的对象
	 * 
	 * @param bookid
	 */
	public void deleteByBookDetailid(int bookid) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from BookDetail where bookid=?");
		q.setParameter(0, bookid);
		BookDetail bd = (BookDetail) q.uniqueResult();
		
		session.delete(bd);
	}
	/**
	 *  查询所有图书的类型
	 * @return 
	 */
	
	public BookType findAllType1(int typeid) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from BookType where typeid=?");
		q.setParameter(0, typeid);
		return (BookType) q.uniqueResult();
	}
	/**
	 * 对后台数据进行修改
	 * 
	 * @param bookdetail
	 * @param typeid
	 */
	public void updateBook(BookDetail bookdetail,int typeid) {
		//得到通过typeid得到BookType类型的对象
		BookType bt = this.findAllType1(typeid);
		//通过bookdeatail得到Book对象  不能去new 一个Book对象，那样是空的对象，里面没有数据
		Book book = bookdetail.getBook();
		book.setName(bookdetail.getBookname());
		book.setPrice(bookdetail.getBookprice());
		book.setPicture(bookdetail.getBookimg1());
		book.setBookType(bt);
		//book和bookdetail 建立 关联关系
		book.setBookDetail(bookdetail);
		bookdetail.setBook(book);
		//更新book和bookdetail 表中的数据
		Session session = this.sessionFactory.getCurrentSession();
		session.update(book);
		session.update(bookdetail);
	}
	
}

