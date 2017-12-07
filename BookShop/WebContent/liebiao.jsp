<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=basePath %>/css/index.css"/>
<script src="<%=basePath %>/js/jquery-1.7.2.min.js"></script>
<script src="<%=basePath %>/js/main.js"></script>
<style>
		.c1{font-size:20px;font-weight:bold;color:#000000;}
		.c3{float:left;width:340px;margin-top:50px;padding-left:20px}
		.item-li{float:left}
</style> 
</head>
<body>
<div class="top" id="item4">
	<div class="container clearfix">
		<ul class="clearfix fr">
			<li><a href="<%=basePath %>login.jsp#tologin" >登录</a></li>
			<li><a href="<%=basePath %>login.jsp#toregister" >注册</a></li>
			<li><a href="<%=basePath %>member.jsp">个人中心</a></li>
			<li><a href="<%=basePath %>bought.jsp" style="border: none">购物车</a></li>
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

<div class="list-main">
	<div class="container">
		<div class="bread" style="margin-bottom: 0;">当前位置：
			<a href="<%=basePath %>book/list1">列表</a> >
			
		</div>
		<ul class="select">
			
			<li class="select-list">
				<dl id="select3">
					<dt>类别：</dt>
					<dd><a href="<%=basePath %>book/findByTypeid?typeid=1">小说</a></dd>
					<dd><a href="<%=basePath %>book/findByTypeid?typeid=2">教科书</a></dd>
					<dd><a href="<%=basePath %>book/findByTypeid?typeid=3">漫画书</a></dd>
					<dd><a href="<%=basePath %>book/findByTypeid?typeid=4">杂志</a></dd>
				</dl>
			</li>
		</ul>
		<c:forEach var="booktype" items="${typeList }">
			<div class="c1">${booktype.typename }</div>
		</c:forEach>
		<c:forEach var="b" items="${sublist }">
		<div class="c2">
			<div class="c3">
				<div class="c4" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px '">
					<div class="c5"><a href="<%=basePath %>book/findByBookId?bookid=${b.id}" target="_blank"><img src="${b.picture }" alt="无法显示该图片"></a></div>
					<div class="c6"><a href="<%=basePath %>book/findByBookId?bookid=${b.id}" target="_blank">${b.name }</a></div>
					<div class="c7">${b.publisher }</div>
					<div class="c8">${b.price }</div>
				</div>
			</div>
		</div>
	</c:forEach>
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