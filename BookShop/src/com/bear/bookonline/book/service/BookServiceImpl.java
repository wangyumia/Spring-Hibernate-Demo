package com.bear.bookonline.book.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bear.bookonline.book.dao.BookDaoImpl;
import com.bear.bookonline.entity.Book;
import com.bear.bookonline.entity.BookDetail;
import com.bear.bookonline.entity.BookType;
import com.bear.bookonline.entity.Page;

@Service
@Transactional(readOnly=true)
public class BookServiceImpl {
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
      public  Book QueryById(int id){
          return bookDaoImpl.QueryById(id);
      }
      public List <Book> QueryByTypeid(int typeid){
          return bookDaoImpl.QueryByTypeid(typeid);
      }
      public List<BookType> findAllType(int typeid){
      	return this.bookDaoImpl.findAllType(typeid);
      }
      public List<BookDetail> findAllBookDetail(int bookid){
    	  return this.bookDaoImpl.findAllDetail(bookid);
      }
      public List<BookDetail> findAllBookDetail(String bookname){
    	  return this.bookDaoImpl.findAllDetail(bookname);
      }
      public BookDetail findAllDetail1(int bookid) {
    	  return this.bookDaoImpl.findAllDetail1(bookid);
      }
     

}
