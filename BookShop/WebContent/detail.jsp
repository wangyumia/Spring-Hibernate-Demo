<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<%
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>

<head>
    <meta charset="UTF-8">
	<link rel="stylesheet" href="<%=basePath %>css/index.css"/>
	<script src="<%=basePath %>js/jquery-1.11.2.min.js"></script>
	<script src="<%=basePath %>js/main.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/mz-packed.js"></script>
	<title>Detail</title>
	<style>
		.a1{font-weight:bold;font-size:20px;color:#000000;margin-bottom:20px;margin-left:20px}
		.a2{margin-left:20px;width:200px;border: 1px white;height:500px;}
		.b{margin-left:20px;width:200px;}
		.b1{padding-left:0px;width:60px;height:50px;}
		.aaa{float:left;width:1000px}
		.aa{width:700px;float:right;margin-top:-560px;padding-left:50px;}
		.right{float:left;width:300px}
		.a21{float:left;padding-left:6px;}
		.a6{margin-top:20px;}
		.a4{margin-top:20px;}
		.qty{font-size:15px;color:#5D4B33;font-weight:bold;margin: 15px 10px 0 10px;}
		.min{width:50px;height:37px;border: 1px solid #ccc;border-radius: 4px;}
	</style>
	<!-- //Custom Theme files -->
	<link href="<%=basePath %>css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
	<link href="<%=basePath %>css/style.css" type="text/css" rel="stylesheet" media="all">
	<!-- js -->
	<script src="<%=basePath %>js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/bootstrap-3.1.1.min.js"></script>
	<script src="<%=basePath %>js/imagezoom.js"></script>
	<!-- FlexSlider -->
	<script defer src="<%=basePath %>js/jquery.flexslider.js"></script>
	<link rel="stylesheet" href="<%=basePath %>css/flexslider.css" type="text/css" media="screen" />
	<script>
		// Can also be used with $(document).ready()
		$(window).load(function() {
		  $('.flexslider').flexslider({
			animation: "slide",
			controlNav: "thumbnails"
		  });
		});
	</script>
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<body style="background:url(<%=basePath %>./images/76.jpg)">

<div class="top" id="item4">
	<div class="container clearfix">
		<ul class="clearfix fr">
			<li><a href="<%=basePath %>login.jsp#tologin" >登录</a></li>
			<li><a href="<%=basePath %>adminlogin.jsp#tologin">管理员登录</a></li>
			<li><a href="<%=basePath %>login.jsp#toregister" >注册</a></li>
			<li><a href="<%=basePath %>member.jsp">个人中心</a></li>
			<li><a href="<%=basePath %>bought.jsp">购物车</a></li>
			<li><a href="<%=basePath %>useroff" style="border: none">退出登录</a></li>
		</ul>
	</div>
</div>

<div class="header">
	<div class="container clearfix">
		<div class="logo fl">
			<a href="<%=basePath %>/index.jsp"><img src="<%=basePath %>images/61.jpg" /></a>
		</div>
		<div class="seacher fl">
			<form action="<%=basePath %>book/findByBookName" method="post">
				<input type="text" placeholder="小伙伴，你想找什么?" name="bookname"/><input type="submit" value="搜 索"/>
			</form>
			<p>热门搜索：&nbsp;<a href="<%=basePath%>book/findByBookId?bookid=1">数据结构</a>&nbsp; &nbsp;<a href="<%=basePath%>book/findByBookId?bookid=2">操作系统</a>&nbsp;&nbsp; <a href="<%=basePath%>book/findByBookId?bookid=10">青年文摘</a></p>
		</div>
		<div class="mm fr clearfix">
			<a href="<%=basePath %>book/list1">我要买</a>
		
		</div>
	</div>
</div>
<div class="main">
	<div class="container clearfix">
		<div class="bread">当前位置：
			<a href="<%=basePath %>book/list1">首页</a> 
			<a href="<%=basePath %>liebiao.jsp">教材区</a> 
			<a href="<%=basePath %>detail.jsp">图书详情</a>
		</div>
		<c:forEach items="${idList}" var="bd" >
		<form action="<%=basePath %>book/addBought">
		<div class="aaa">
			<input type="hidden" name="bookid" value="${bd.bookid }" />
			<div class="a1">${bd.bookname}</div>
			<div class="col-md-4 single-grid">		
					<div class="flexslider">
						<ul class="slides">
							<li data-thumb="${bd.bookimg1}">
								<div class="thumb-image"> <img src="${bd.bookimg1}" data-imagezoom="true" class="img-responsive"> </div>
							</li>
							<li data-thumb="${bd.bookimg2}">
								 <div class="thumb-image"> <img src="${bd.bookimg2}" data-imagezoom="true" class="img-responsive"> </div>
							</li>
							<li data-thumb="${bd.bookimg3}">
							   <div class="thumb-image"> <img src="${bd.bookimg3}" data-imagezoom="true" class="img-responsive"> </div>
							</li> 
						</ul>
					</div>
			</div>	
			
		<div class="aa">
			<div><p style="font-size:15px;color:#5D4B33;font-weight:bold;padding-left:10px">Book Introduction</p></div><br>&nbsp;&nbsp;
			<div><p style="margin-top:30px;text-align:left;padding-left:10px">${bd.introduce}</p></div>
			<div class="a4">
				<p class="qty">Qty :</p><input min="1" type="number" id="quantity" name="quantity" value="1" class="min">	
			</div>
			<div class="a5"><p style="font-size:15px;margin-top:30px;color:#5D4B33;font-weight:bold;padding-left:10px">Price:&nbsp;&nbsp;&nbsp;&nbsp;${bd.bookprice}</p></div>
			<div><p style="font-size:15px;margin-top:30px;color:#5D4B33;font-weight:bold;padding-left:10px">Total Price：${(bd.bookprice)*(bd.bookcount)}</p></div> 
			<div class="a6">
				<input  style="font-size:15px;color:red;font-weight:bold;padding-left:10px;height:40px;background-color:#FFB6C1;width:180px;margin-top:30px;" type="submit"  value="ADD TO CART">
				<input  style="font-size:15px;color:white;font-weight:bold;padding-left:10px;height:40px;background-color:#FF0000;width:180px;margin-left:20px;margin-top:30px;" type="submit"  value="BUY">
			</div>
		</div>
		</div>
		</form>
		</c:forEach>
	</div>
</div>

<div class="foot">
	<div class="container">
		<div class="zhinan">
			<ul class="clearfix">
				<li class="item-li">关于我们
					<ul>
						<li><a href="<%=basePath %>help.jsp">自我介绍</a></li>
						<li><a href="<%=basePath %>help.jsp">联系我们</a></li>
						<li><a href="<%=basePath %>help.jsp">网站公告</a></li>
					</ul>
				</li>
				<li class="item-li">新手指南
					<ul>
						<li><a href="<%=basePath %>help.jsp">如何买书</a></li>
						<li><a href="<%=basePath %>help.jsp">如何卖书</a></li>
						<li><a href="<%=basePath %>help.jsp">修改密码</a></li>
					</ul>
				</li>
				<li class="item-li">配送方式
					<ul>
						<li><a href="<%=basePath %>help.jsp">配送范围</a></li>
						<li><a href="<%=basePath %>help.jsp">配送时间</a></li>
					</ul>
				</li>
				<li class="item-li">售后服务
					<ul>
						<li><a href="<%=basePath %>help.jsp">退款申请</a></li>
						<li><a href="<%=basePath %>help.jsp">退换货处理</a></li>
						<li><a href="<%=basePath %>help.jsp">退换货政策</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<div class="line"></div>

		<div class="bottom">
			<p>友情链接：<a href="#">安工在线</a>&nbsp;&nbsp;<a href="#">万林强</a></p>
			<p>交易时请注意识别信息的真假如有网站内容侵害了您的权益请联系我们删除，举报电话：15068718875</p>
			<p>技术支持：万林强 &nbsp;&nbsp;商务QQ:584845663 &nbsp;&nbsp;邮箱：584845663@qq.com</p>
		</div>
	</div>
</div>


</body>
</html>