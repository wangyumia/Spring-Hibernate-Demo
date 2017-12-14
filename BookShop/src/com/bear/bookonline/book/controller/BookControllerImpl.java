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
	//将BookServiceImpl 注入给BookControllerImpl
	private BookServiceImpl bookServiceImpl;
	@RequestMapping("/list1")
	/*public String list(@RequestParam(value="pageNum",default)Model model) {
		List<Book> list=this.bookServiceImpl.listAll();
		model.addAttribute("list", list);
		return "list";
	}
	*/
	/**
	 * 找到所有的记录并实现了每3个数据分成一页
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
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
	/**
	 * 从数据库中查询到bookdetail表的所有数据，存储到detailList列表中，然后返回到Index页面，在后台展示所有数据
	 * @param session
	 * @return 后台展示界面
	 */
	@RequestMapping("/list")
	public String findAllDetail(HttpSession session) {
		List<BookDetail> detailList =this.bookServiceImpl.findAllDetail();
		session.setAttribute("detailList", detailList);
		return "Index";
 	}
	/**
	 * 通过获取页面上的图书类型进行查询
	 * @param model
	 * @param typeid
	 * @return 显示某一种类型的图书页面
	 */
	@RequestMapping("/findByTypeid")
	public String findByTypeid(Model model,@RequestParam("typeid") int typeid) {
		//获取到某一种类型的图书信息
		List<Book> sublist = this.bookServiceImpl.QueryByTypeid(typeid);
		//获取到所有的图书类型
		List<BookType> typeList = this.bookServiceImpl.findAllType(typeid);
		model.addAttribute("sublist", sublist);
		model.addAttribute("typeList", typeList);
		return "liebiao";
	}
	
	/**
	 * 根据bookid 查询数据库表bookdetail ，将结果存进一个idList列表中
	 * @param model
	 * @param bookid
	 * @return 详情页面
	 */
	@RequestMapping("/findByBookId")
	public String findByBookId(Model model,@RequestParam("bookid") int bookid) {
		List<BookDetail>idList = this.bookServiceImpl.findAllBookDetail(bookid);
		model.addAttribute("idList", idList);
		return "detail";
	}
	/**
	 * 根据bookname 查询数据库表bookdetail ，将结果存进一个idList列表中
	 * @param model
	 * @param bookid
	 * @return 详情页面
	 */
	
	@RequestMapping("/findByBookName")
	public String findByBookName(Model model,@RequestParam("bookname") String bookname) {
		List<BookDetail>idList = this.bookServiceImpl.findAllBookDetail(bookname);
		model.addAttribute("idList", idList);
		return "detail";
	}
	/**将要购买的图书保存到购物车里面
	 * 先得到用户对象和订单信息
	 * 将订单信息保存进购物车 
	 * 然后计算总价格
	 * 最后返回
	 * @param model
	 * @param id
	 * @param session
	 * @return 分页的主页面
	 */
	@RequestMapping("/addBought")
	public String findByBookid(Model model,@RequestParam(value="bookid") int id,HttpSession session) {
		//获取到登录时保存的用户对象
		User user = (User)session.getAttribute("user");
		//调用bookServiceImpl中的保存图书进入购物车的方法
		this.bookServiceImpl.saveShopping(user, id);
		//得到订单中的信息
		Set<Order> shoppingCartSet = (Set<Order>)session.getAttribute("shoppingcart");
		session.setAttribute("shoppingCartSet",shoppingCartSet);
		//计算订单中的总价格
		for(Order order : user.getOrderSet()) {
			double sum = 0;
			for(OrderDetail oderdetail : order.getOrderDetailSet()) {
				sum = sum + oderdetail.getTotalprice();
				session.setAttribute("totalPrice",sum);
			}
		}
		return "redirect:list1";
	}
	/**
	 * 删除购物车的图书信息
	 * @param orderdetailid  根据订单详情的id来进行匹配是否是要删除的那个图书
	 * @param session
	 * @return 购物车页面
	 */
	@RequestMapping("/delete")
	public String findByBookId(@RequestParam("orderdetailid") int orderdetailid,HttpSession session) {
		User user = (User)session.getAttribute("user");
		Set<Order> orderSet = user.getOrderSet();
		//匹配成功，删除这个订单
		for(Order order:orderSet) {
			for(OrderDetail oderDetail : order.getOrderDetailSet()) {
				if(oderDetail.getOrderDetailid() == orderdetailid) {
					order.getOrderDetailSet().remove(oderDetail);
				}
			}
		}
		OrderDetail orderDetail = this.bookServiceImpl.findByOrderDetailid(orderdetailid);
		this.bookServiceImpl.deleteByOrderDetail(orderDetail);
		//重新存入订单
		Set<Order>shoppingCartSet = user.getOrderSet();
		session.setAttribute("shoppingCartSet", shoppingCartSet);
		//删除之后再次进行总价格的计算
		for(Order order : user.getOrderSet()) {
			double sum = 0;
			for(OrderDetail oderdetail : order.getOrderDetailSet()) {
				sum = sum + oderdetail.getTotalprice();
				session.setAttribute("totalPrice",sum);
			}
		}
		return "bought";
	}
	/**
	 * 在后台实现添加图书的功能
	 * 获取到以下jsp页面上的参数
	 * @param name  
	 * @param typename
	 * @param introduce
	 * @param price
	 * @param img
	 * @param session  
	 * @return Index2页面
	 */
	@RequestMapping("/addbook")
	public String addBook(@RequestParam("bookname") String name,@RequestParam("booktype") String typename,@RequestParam("introduce") String introduce,@RequestParam("bookprice") int price,@RequestParam("bookimg") String img,
			HttpSession session) {
		//new一个BookDetail对象，设置其中的属性值
		BookDetail bookdetail = new BookDetail();
		bookdetail.setBookimg1(img);
		bookdetail.setBookname(name);
		bookdetail.setIntroduce(introduce);
		bookdetail.setBookprice(price);
		//调用bookServiceImplh中的方法保存数据
		this.bookServiceImpl.saveBook(bookdetail,typename);
		//遍历bookdetail表，得到图书信息列表
		List<BookDetail> detailList =this.bookServiceImpl.findAllDetail();
		session.setAttribute("detailList", detailList);
		return "Index2";
	}
	/**
	 * 在后台实现删除图书信息
	 * @param bookid 根据bookid 删除这本书的所有信息
	 * @param session  进行保存
	 * @return   Index2页面
	 */
	@RequestMapping("/deletebook")
	public String deleteBook(@RequestParam("bookid") int bookid,HttpSession session) {
		 this.bookServiceImpl.deleteBook(bookid);
		 List<BookDetail> detailList =this.bookServiceImpl.findAllDetail();
		 session.setAttribute("detailList", detailList);
		 return "Index2";
	}
	/**
	 * 根据bookid 查询出图书详情对象，同时查出所有图书的类型集合
	 * @param session
	 * @param bookid
	 * @return 后台修改页面
	 */
	@RequestMapping("/getbook")
	 public String selectAllType(HttpSession session,@RequestParam("bookid") int bookid) {
		BookDetail bookdetail = this.bookServiceImpl.findAllDetail1(bookid);
		List <BookType> typeList = this.bookServiceImpl.findAllType();
		session.setAttribute("typeList", typeList);
		session.setAttribute("bookdetail", bookdetail);
		return "adminUpdate";
	}
	/**
	 * 根据后台修改页面的数据对数据库中的数据进行修改
	 * @param name
	 * @param bookimg1
	 * @param introduce
	 * @param price
	 * @param session  获取到上面getbook中查询到的bookdetail对象
	 * @return 后台展示界面
	 */
	@RequestMapping("/updateBooks")
	public String updateBook(@RequestParam("bookname") String name,@RequestParam("bookimg1") String bookimg1,@RequestParam("introduce") String introduce, @RequestParam("bookprice") int price,@RequestParam("bookType") int typeid,HttpSession session ) {
		BookDetail bookdetail = (BookDetail) session.getAttribute("bookdetail");
		bookdetail.setBookname(name);
		bookdetail.setBookimg1(bookimg1);
		bookdetail.setBookprice(price);
		bookdetail.setIntroduce(introduce);
		this.bookServiceImpl.updateBook(bookdetail,typeid);
		List<BookDetail> detailList =this.bookServiceImpl.findAllDetail();
		session.setAttribute("detailList", detailList);
		return "Index2";
		
	}
	
	
	
}

