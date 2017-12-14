<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<%
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<head>
    <meta charset="UTF-8">
	<link rel="stylesheet" href="<%=basePath %>css/index.css"/>
	<link rel="stylesheet" href="<%=basePath %>css/font-awesome.min.css"/>
	<script src="<%=basePath %>js/main.js"></script>
	<title>IBOOK</title>
	<style>
		.attr{height:30px;margin-left:200px;width:30px;font-size:15px;color:#999;}
		.attr1{height:30px;margin-left:200px;width:30px;font-size:15px;color:#999;float:left;margin-top:-30px;}
		.attr2{height:30px;margin-left:300px;width:50px;font-size:15px;color:#999;float:left;margin-top:-30px;}
		.attr3{height:30px;margin-left:800px;width:30px;font-size:15px;color:#999;float:left;margin-top:-30px;}
		.header{background-color: #5D4B33;padding: 0;position: relative;}
	</style>
</head>

<body >

<div class="top" id="item4">
	<div class="container clearfix">
		<ul class="clearfix fr">
			<li><a href="<%=basePath %>login.jsp#tologin" >登录</a></li>
			<li><a href="<%=basePath %>adminlogin.jsp#tologin">管理员登录</a></li>
			<li><a href="<%=basePath %>login.jsp#toregister" >注册</a></li>
			<li><a href="<%=basePath %>member.jsp" >个人中心</a></li>
			<li><a href="<%=basePath %>bought.jsp" >购物车</a></li>
			<li><a href="<%=basePath %>useroff" style="border: none">退出登录</a></li>
		</ul>
	</div>
</div>

<div class="header">
	<div class="container clearfix">
		<div class="logo fl">
			<img src="<%=basePath %>images/61.jpg" /></a>
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

<div class="help-wrap">
	<div class="container clearfix">
		<div class="bread">当前位置：
			<a href="<%=basePath %>book/list1">首页</a> >
			<a href="<%=basePath %>member.jsp">个人中心</a> >
			<a href="<%=basePath %>bought.jsp">已买书籍</a>
		</div>
		<div class="help-l fl">
			<div class="help-item">
				<div class="help-item-title">个人中心
					<a href="javascript:void(0)" class="abs"></a>
				</div>
				<div class="help-item-list">
					<ul>
						<li><a href="<%=basePath %>member.jsp">个人信息</a></li>
						<li><a href="<%=basePath %>password.jsp">修改密码</a></li>
					</ul>
				</div>
			</div>
			<div class="help-item">
				<div class="help-item-title">书籍管理
					<a href="javascript:void(0)" class="abs"></a>
				</div>
				<div class="help-item-list">
					<ul>
						
						<li><a href="<%=basePath %>bought.jsp">已买书籍</a></li>
						
					</ul>
				</div>
			</div>
		</div>
		<div class="help-r fr">
			<div class="help-item-title">已买书籍</div>
			<div class="help-main">
				<div class="product-item clearfix">
					<div class="name fl">
						<span style="margin-left: 100px;font-family: Microsoft Yahei,Verdana,Arial;color: #999;font-size:15px;">书名</span>
					</div>
					<div class="attr">
						<p>价格</p>
					</div>
					<div class="attr1">
						<p>数量</p>
					</div>
					<div class="attr2">
						<p>总价格</p>
					</div>
					<div class="attr3">
						<p>状态</p>
					</div>
					
				</div>
				<c:forEach items="${shoppingCartSet}" var="s">
				<c:forEach items="${s.orderDetailSet}" var="o">
				<div class="pro">
					<div class="product-attr">
						<div class="product-name fl">
							<div class="pic-thumb fl"><a href="<%=basePath %>detail.jsp"><img  class="middle" src="${o.bookimg1 }"></a></div>
							<div class="product-title fl">
								<a href="<%=basePath %>detail.jsp" class="ellipsis"><p style="margin-left:5px;">${o.bookname}</p></a><br>
								
							</div>
						</div>
						<div class="product-price fr">
							<ul class="clearfix">
								<li><p style="margin-left:-700px;margin-top:20px;">${o.bookprice}</p></li>
								<li><p style="margin-left:-600px;margin-top:20px;">${o.bookcount}</li>
								<li><p style="margin-left:-500px;margin-top:20px;">${o.totalprice}</li>
								<li class="edit" style="width: 110px">
									<span class="cancel"><a href="<%=basePath %>book/delete?orderdetailid=${o.orderDetailid}">取消交易</a></span>
								</li>
							</ul>
						</div>
					</div>
				</div>
				</c:forEach>
				</c:forEach>
				<div style="padding-left:800px;">
					<a href="<%=basePath%>book/list1"><input type="submit" value="提交订单" style="background-color:#DA4F49;width:100px;height:40px;"/></a>
				</div>
			</div>
		</div>
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