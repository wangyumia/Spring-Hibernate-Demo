<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<%
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>

<head>
    <meta charset="UTF-8">
	<link rel="stylesheet" href="<%=basePath %>css/index.css"/>
	<script src="<%=basePath %>js/main.js"></script>
	<title>Help</title>
	<style>
		.header{    background-color: #5D4B33;padding: 0;position: relative;}
	</style>
</head>
<body >

<div class="top" id="item4">
	<div class="container clearfix">
		<ul class="clearfix fr">
			<li><a href="<%=basePath %>login.jsp#tologin" >登录</a></li>
			<li><a href="<%=basePath %>login.jsp#toregister" >注册</a></li>
			<li><a href="<%=basePath %>member.jsp" >个人中心</a></li>
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
			<form action="" method="post">
				<input type="text" placeholder="小伙伴，你想找什么?"/><input type="submit" value="搜 索"/>
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
			<a href="<%=basePath %>help.jsp">帮助中心</a> >
			<a href="<%=basePath %>help.jsp">如何买书</a>
		</div>
		<div class="help-l fl">
			<div class="help-item">
				<div class="help-item-title">关于我们
					<a href="javascript:void(0)" class="abs"></a>
				</div>
				<div class="help-item-list">
					<ul>
						<li><a href="<%=basePath %>help.jsp">自我介绍</a></li>
						<li><a href="<%=basePath %>help.jsp">联系我们</a></li>
						<li><a href="<%=basePath %>help.jsp">网站公告</a></li>
					</ul>
				</div>
			</div>
			<div class="help-item">
				<div class="help-item-title">新手指南
					<a href="javascript:void(0)" class="abs"></a>
				</div>
				<div class="help-item-list">
					<ul>
						<li><a href="<%=basePath %>help.jsp">如何买书</a></li>
						<li><a href="<%=basePath %>help.jsp">如何卖书</a></li>
						<li><a href="<%=basePath %>password.jsp">修改密码</a></li>
					</ul>
				</div>
			</div>
			<div class="help-item">
				<div class="help-item-title">配送方式
					<a href="javascript:void(0)" class="abs"></a>
				</div>
				<div class="help-item-list">
					<ul>
						<li><a href="<%=basePath %>help.jsp">配送范围</a></li>
						<li><a href="<%=basePath %>help.jsp">配送时间</a></li>
					</ul>
				</div>
			</div>
			<div class="help-item">
				<div class="help-item-title">售后服务
					<a href="javascript:void(0)" class="abs"></a>
				</div>
				<div class="help-item-list">
					<ul>
						<li><a href="<%=basePath %>help.jsp">退款申请</a></li>
						<li><a href="<%=basePath %>help.jsp">退换货处理</a></li>
						<li><a href="<%=basePath %>help.jsp">退换货政策</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="help-r fr">
			<div class="help-item-title">如何买书</div>
			<div class="help-main">
				<h2>1.注册登录</h2>
				<p>第一步：点击易书网首页顶部免费注册进入注册页面。</p>
				<img src="images/57.jpg" alt=""/>
				<p>第二步：您可通过邮箱/手机号码进行注册，按照提示填写准确信息，点击提交“注册”。</p>
				<img src="images/59.jpg" alt=""/>
				<p>第三步：注册完成后，点击易书网首页顶部“登录”正常登录账户即可。</p>
				<h2>2.搜索商品</h2>
				<p>第一步：搜索自己想要的书籍</p>
				<img src="images/60.jpg" alt=""/>
				<p>第二步：选好进入详情</p>
				<h2>3.购买书籍</h2>
				<p>点击加入购物车进行购买</p>
				<img src="<%=basePath %>images/60.jpg" alt=""/>
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