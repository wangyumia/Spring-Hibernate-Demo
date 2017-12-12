package com.bear.bookonline.book.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

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
/**
* 分页查询
* @param hql 查询的条件
* @param offset 开始记录
* @param length 一次查询几条记录
* @return 返回查询记录集合
*/
public class BookDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	public List<Book> findAll(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Book");
		return q.list();
	}
	 public List<Book> queryForPage(int offset, int length) {
	       //查询所有的记录数
	       Query query= (Query) sessionFactory.getCurrentSession().createQuery("from Book");    
	        query.setFirstResult(offset);
	        query.setMaxResults(length);            
	        return query.list(); 
	  }
	 public void save(Book st){
	     sessionFactory.getCurrentSession().save(st);
	       }
	     public void update(Book st) {   
	            sessionFactory.getCurrentSession().update(st);
	       }
	     public void delete(Book st) {      
	            sessionFactory.getCurrentSession().delete(st);
	       }
	     //查询记录总数
	     public int getAllRowCount(){
	         int count=((Long) sessionFactory.getCurrentSession()
	                .createQuery( "select count(*) from Book").iterate().next()).intValue();
	         return count;  
	     }
	     //根据id查询记录
	    public Book QueryById(int id) {
	    	Book st =(Book) sessionFactory.getCurrentSession().get(Book.class, id);
	       return st;
	     }
	    public List<Book> QueryByTypeid(int typeid) {
		    Query q = this.sessionFactory.getCurrentSession().createQuery("from Book where typeid=?");
		    q.setParameter(0, typeid);
		    return q.list();
		}
	    public List<BookType> findAllType(int typeid){
			Query q = this.sessionFactory.getCurrentSession().createQuery("from BookType where typeid=?");
			q.setParameter(0, typeid);
			return q.list();
		}
	    public List<BookDetail> findAllDetail(int bookid){
	    	Query q = this.sessionFactory.getCurrentSession().createQuery("from BookDetail where bookid=?");
	    	q.setParameter(0, bookid);
	    	return q.list();
	    }
	    public List<BookDetail> findAllDetail(String bookname){
	    	Query q = this.sessionFactory.getCurrentSession().createQuery("from BookDetail where bookname=?");
	    	q.setParameter(0,bookname);
	    	return q.list();
	    }
	   
	   public BookDetail findAllDetail1(int bookid) {
		   return this.sessionFactory.getCurrentSession().get(BookDetail.class,bookid);
				   
	   }
	   public void saveShopping(User user,int id) {
			Session session = sessionFactory.getCurrentSession();
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
			session.update(user);
			session.save(order);
			BookDetail bookdetail = this.findAllDetail1(id);
			OrderDetail orderdetail = new OrderDetail();
			orderdetail.setUsername(user.getUsername());
			orderdetail.setBookname(bookdetail.getBookname());
			orderdetail.setBookcount(bookdetail.getBookcount());
			orderdetail.setBookprice(bookdetail.getBookprice());
			
			//建立order与orderdetail的关联
			orderdetail.setOrder(order);
			order.getOrderDetailSet().add(orderdetail);
			
			session.save(orderdetail);
			session.update(order);
			
	}
	public void deleteByOrderDetail(OrderDetail od) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(od);
	}
	public OrderDetail findByOrderDetailid(int id) {
		return this.sessionFactory.getCurrentSession().get(OrderDetail.class, id);
	}
	public List<BookDetail> findAllDetail(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from BookDetail");
		return q.list();
	}
	
}

