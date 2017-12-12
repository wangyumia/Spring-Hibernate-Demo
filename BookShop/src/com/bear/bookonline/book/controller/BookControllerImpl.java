package com.bear.bookonline.book.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bear.bookonline.book.service.BookServiceImpl;
import com.bear.bookonline.entity.Book;
import com.bear.bookonline.entity.BookDetail;
import com.bear.bookonline.entity.BookType;
import com.bear.bookonline.entity.CartItem;
import com.bear.bookonline.entity.Order;
import com.bear.bookonline.entity.OrderDetail;
import com.bear.bookonline.entity.Page;
import com.bear.bookonline.entity.ShoppingCart;
import com.bear.bookonline.entity.User;

@Controller
@RequestMapping("book")
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
	public String findByBookid(Model model,@RequestParam(value="bookid") int id,HttpSession session) {
		User user = (User)session.getAttribute("user");
		this.bookServiceImpl.saveShopping(user, id);
		Set<Order> shoppingCartSet = (Set<Order>)session.getAttribute("shoppingcart");
		session.setAttribute("shoppingCartSet",shoppingCartSet);
		
		for(Order order : user.getOrderSet()) {
			double sum = 0;
			for(OrderDetail oderdetail : order.getOrderDetailSet()) {
				sum = sum + oderdetail.getTotalprice();
				session.setAttribute("totalPrice",sum);
			}
		}
		return "redirect:list1";
	}
	@RequestMapping("/delete")
	public String findByBookId(@RequestParam("orderdetailid") int orderdetailid,HttpSession session) {
		User user = (User)session.getAttribute("user");
		Set<Order> orderSet = user.getOrderSet();
		for(Order order:orderSet) {
			for(OrderDetail oderDetail : order.getOrderDetailSet()) {
				if(oderDetail.getOrderDetailid() == orderdetailid) {
					order.getOrderDetailSet().remove(oderDetail);
				}
			}
		}
		OrderDetail orderDetail = this.bookServiceImpl.findByOrderDetailid(orderdetailid);
		this.bookServiceImpl.deleteByOrderDetail(orderDetail);
		Set<Order>shoppingCartSet = user.getOrderSet();
		session.setAttribute("shoppingCartSet", shoppingCartSet);
		
		for(Order order : user.getOrderSet()) {
			double sum = 0;
			for(OrderDetail oderdetail : order.getOrderDetailSet()) {
				sum = sum + oderdetail.getTotalprice();
				session.setAttribute("totalPrice",sum);
			}
		}
		return "bought";
	}
	
}

