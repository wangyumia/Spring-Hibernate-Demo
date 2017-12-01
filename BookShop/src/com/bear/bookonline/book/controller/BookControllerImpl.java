package com.bear.bookonline.book.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bear.bookonline.book.service.BookServiceImpl;
import com.bear.bookonline.entity.Book;
import com.bear.bookonline.entity.BookDetail;
import com.bear.bookonline.entity.BookType;
import com.bear.bookonline.entity.Page;

@Controller
@RequestMapping("/book")
public class BookControllerImpl {
	@Resource
	private BookServiceImpl bookServiceImpl;
	@RequestMapping("/list1")
	/*public String list(@RequestParam(value="pageNum",default)Model model) {
		List<Book> list=this.bookServiceImpl.listAll();
		model.addAttribute("list", list);
		return "list";
	}
	*/
	//找到所有的记录并实现了分页
	public String findAll(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) {   
	        String pageNo = request.getParameter("pageNo");
	        if (pageNo == null) {
	            pageNo = "1";
	        }
	        Page page = bookServiceImpl.queryForPage(Integer.valueOf(pageNo), 3);
	        request.setAttribute("page", page);
	        List<Book> list = page.getList();
	        modelMap.put("list", list);
	        return "list";
	}
	@RequestMapping("/findByTypeid")
	public String findByTypeid(Model model,@RequestParam("typeid") int typeid) {
		List<Book> sublist = this.bookServiceImpl.QueryByTypeid(typeid);
		List<BookType> typeList = this.bookServiceImpl.findAllType(typeid);
		model.addAttribute("sublist", sublist);
		model.addAttribute("typeList", typeList);
		return "liebiao";
	}
	@RequestMapping("/findByBookId")
	public String findByBookId(Model model,@RequestParam("bookid") int bookid) {
		List<BookDetail>idList = this.bookServiceImpl.findAllBookDetail(bookid);
		model.addAttribute("idList", idList);
		return "detail";
	}
	@RequestMapping("/findByBookName")
	public String findByBookName(Model model,@RequestParam("bookname") String bookname) {
		List<BookDetail>idList = this.bookServiceImpl.findAllBookDetail(bookname);
		model.addAttribute("idList", idList);
		return "detail";
	}
	
	@RequestMapping("/addBought")
	public String findByBookId(Model model,@RequestParam(value="bookid") int bookid,HttpSession session) {
		List shoppingCartList = (List)session.getAttribute("shoppingCartList");
		if(shoppingCartList == null) {
			shoppingCartList = new ArrayList<>();
		}
		BookDetail bd = this.bookServiceImpl.findAllDetail1(bookid);
		shoppingCartList.add(bd);
		session.setAttribute("shoppingCartList", shoppingCartList);
		return "bought";
		}
	@RequestMapping("/deleteBought")
	public String findByBookId(@RequestParam("bookid") int bookid,HttpSession session) {
		List scList = (List)session.getAttribute("scList");
		BookDetail bd = this.bookServiceImpl.findAllDetail1(bookid);
		scList.remove(bd);
		session.setAttribute("scList", scList);
		return "list";
	}
}

