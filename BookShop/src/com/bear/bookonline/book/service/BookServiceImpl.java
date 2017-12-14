package com.bear.bookonline.book.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bear.bookonline.book.dao.BookDaoImpl;
import com.bear.bookonline.entity.Book;
import com.bear.bookonline.entity.BookDetail;
import com.bear.bookonline.entity.BookType;
import com.bear.bookonline.entity.OrderDetail;
import com.bear.bookonline.entity.Page;
import com.bear.bookonline.entity.ShoppingCart;
import com.bear.bookonline.entity.User;

@Service
@Transactional
public class BookServiceImpl {
	//将 BookDaoImpl注入给BookServiceImpl
	@Resource
	private BookDaoImpl bookDaoImpl;
    /**
     * 分页查询 
     * @param currentPage 当前页号：现在显示的页数
     * @param pageSize 每页显示的记录条数
     * @return 封闭了分页信息(包括记录集list)的Bean
     * */
	public List<Book> listAll(){
		return this.bookDaoImpl.findAll();
	}
	  public Page queryForPage(int currentPage,int pageSize) {
          Page page = new Page();       
          //总记录数
          int allRow = bookDaoImpl.getAllRowCount();
          //当前页开始记录
          int offset = page.countOffset(currentPage,pageSize);  
          //分页查询结果集
          List<Book> list = bookDaoImpl.queryForPage(offset, pageSize); 
          page.setPageNo(currentPage);
          page.setPageSize(pageSize);
          page.setTotalRecords(allRow);
          page.setList(list);    
          return page;
      }
       public void Servicesave(Book st){
    	   bookDaoImpl.save(st);
       }
      public void Serviceupdate(Book st){
    	  bookDaoImpl.update(st);
      }
      public void Servicedelete(Book st){
    	  bookDaoImpl.delete(st);
      }
      public int ServicegetCount(){
          return bookDaoImpl.getAllRowCount();
      }
      
      //根据book 表中的id 来进行查询
      public  Book QueryById(int id){
          return bookDaoImpl.QueryById(id);
      }
      
      //根据图书类型的id来将图书分类
      public List <Book> QueryByTypeid(int typeid){
          return bookDaoImpl.QueryByTypeid(typeid);
      }
      //根据图书类型的id来查询图书类型的信息
      public List<BookType> findAllType(int typeid){
      	return this.bookDaoImpl.findAllType(typeid);
      }
      //查询到所有图书的类型信息
      public List<BookType> findAllType(){
    	  return this.bookDaoImpl.findAllType();
      }
      //通过typeid 来查询所有的图书类型
      public BookType findAllType1(int typeid){
        	return this.bookDaoImpl.findAllType1(typeid);
       }
      //调用dao层findAllDetail方法
      public List<BookDetail> findAllBookDetail(int bookid){
    	  return this.bookDaoImpl.findAllDetail(bookid);
      }
      //调用dao层findAllDetail方法
      public List<BookDetail> findAllBookDetail(String bookname){
    	  return this.bookDaoImpl.findAllDetail(bookname);
      }
      //调用dao层findAllDetail1方法
      public BookDetail findAllDetail1(int bookid) {
    	  return this.bookDaoImpl.findAllDetail1(bookid);
      }
      //调用dao层findByOrderDetailid方法
      public OrderDetail findByOrderDetailid(int id) {
    	  return this.bookDaoImpl.findByOrderDetailid(id);
      }
      //调用dao层saveShopping方法
      public void saveShopping(User user,int id) {
    	  this.bookDaoImpl.saveShopping(user, id);
     }
      //调用dao层deleteByOrderDetail方法
     public void deleteByOrderDetail(OrderDetail od) {
    	 this.bookDaoImpl.deleteByOrderDetail(od);
     }
     //调用dao层findAllDetail方法
     public List<BookDetail> findAllDetail(){
    	 return this.bookDaoImpl.findAllDetail();
     }
     //调用dao层saveBook方法
     public void saveBook(BookDetail bookdetail,String typename) {
    	 this.bookDaoImpl.save(bookdetail,typename);
     }
     //调用dao层deleteBook方法
     public void deleteBook(int bookid) {
    	 this.bookDaoImpl.deleteByBookDetailid(bookid);
     }
     //调用dao层updateBook方法
     public void updateBook(BookDetail bookdetail,int typeid) {
    	 this.bookDaoImpl.updateBook(bookdetail,typeid);
     }
     
}
