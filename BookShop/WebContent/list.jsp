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
	<link rel="stylesheet" href="<%=basePath %>css/swiper3.07.min.css"/>
	<script src="<%=basePath %>js/jquery-1.11.2.min.js"></script>
	<script src="<%=basePath %>js/main.js"></script>
	<script src="<%=basePath %>js/koala.min.1.5.js"></script>
	<title>首页</title>
	<style>
		.swiper-container {
			width: 1100px;
			height: 300px;
			margin: 0 auto;
		}
		table{  border-collapse:collapse;  }   
		td{  border:2px  black;  } 
		.fenye{height:80px;width:1000px;margin-top:300px;}
		.fenye2{font-size:20px}
		.a2{float:left ;height:100px;width:200px;margin-right:180px;align:center}
		.a3{font-weight:bold;align:center;padding-left:20px;}
		.header{    background-color: #5D4B33;padding: 0;position: relative;}
	</style>  
</head>
<body style="background:url(<%=basePath %>./images/76.jpg)">

<div class="top" id="item4">
	<form action="book/list1">
	</form>
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
					<input type="text" name="bookname" placeholder="小伙伴，你想找什么?"/><input type="submit" value="搜 索"/>
			</form>
			
			<p>热门搜索：&nbsp;<a href="<%=basePath%>book/findByBookId?bookid=1">数据结构</a>&nbsp; &nbsp;<a href="<%=basePath%>book/findByBookId?bookid=2">操作系统</a>&nbsp;&nbsp; <a href="<%=basePath%>book/findByBookId?bookid=10">青年文摘</a></p>
			
		</div>
		<div class="mm fr clearfix">
			<a href="<%=basePath %>book/list1">我要买</a>
		</div>
	</div>
</div>
<div class="banner container">
	<div class="clearfix">
		<div class="about fl">
			<h1>IBOOK</h1>
			<img src="<%=basePath %>images/64.jpg" alt=""/>
			<p><span>IBOOK</span>是一个网上书城。是一个专为爱阅读的people精心做成的网站。它不仅是出版发行部门开拓图书市场，开通货源渠道的驿站，更是广大读者朋友读书、选书、购书的最佳场所，傲然矗立在图书领域，成为东北乃至更广大地域走向知识经济新时代的桥梁和纽带。</p>
		</div>
		<div id="fsD1" class="focus fl">
			<div id="D1pic1" class="fPic">
				<div class="fcon">
					<a href="detail.jsp"><img src="<%=basePath %>images/50.jpg" /></a>
					
				</div>
				<div class="fcon">
					<a href="detail.jsp"><img src="<%=basePath %>images/51.jpg" /></a>
					
				</div>
				<div class="fcon">
					<a href="detail.jsp"><img src="<%=basePath %>images/55.jpg" /></a>
					
				</div>
				<div class="fcon">
					<a href="detail.jsp"><img src="<%=basePath %>images/53.jpg" /></a>
					
				</div>
				<div class="fcon">
					<a href="detail.jsp"><img src="<%=basePath %>images/54.jpg" /></a>
					
				</div>
			</div>
			<div class="fbg">
				<div class="D1fBt" id="D1fBt">
					<a href="javascript:void(0)" class="current"><i>1</i></a>
					<a href="javascript:void(0)"><i>2</i></a>
					<a href="javascript:void(0)"><i>3</i></a>
					<a href="javascript:void(0)"><i>4</i></a>
					<a href="javascript:void(0)"><i>5</i></a>
				</div>
			</div>
		</div>
		<div class="help fr">
			<h2>最新公告</h2>
			<ul>
				<li><a href="<%=basePath %>notice-detail.jsp">这是IBOOK最新公告1</a></li>
				<li><a href="<%=basePath %>notice-detail.jsp">这是IBOOK最新公告2</a></li>
				<li><a href="<%=basePath %>notice-detail.jsp">这是IBOOK最新公告3</a></li>
				<li><a href="<%=basePath %>notice-detail.jsp">这是IBOOK最新公告4</a></li>
				<li><a href="<%=basePath %>notice-detail.jsp">这是IBOOK最新公告5</a></li>
			</ul>
			<h2>新手帮助</h2>
			<ul>
				<li><a href="<%=basePath %>help.jsp">如何买书</a></li>
				<li><a href="<%=basePath %>help.jsp">如何买书</a></li>
				<li><a href="<%=basePath %>help.jsp">如何买书</a></li>
				<li><a href="<%=basePath %>help.jsp">如何买书</a></li>
			</ul>
		</div>
	</div>
<div class="list-main">
	<div class="container">
		<div class="bread" style="margin-bottom: 0;">
			<h2>当前位置：<a href="<%=basePath %>book/list1">首页</a></h2>	 
		</div>
		<ul class="select">
			<li class="select-list">
				<dl id="select3">
					<dt>类别：</dt>
					<dd style="color:black;"><a href="<%=basePath %>book/findByTypeid?typeid=1">小说</a></dd>
					<dd><a href="<%=basePath %>book/findByTypeid?typeid=2">教科书</a></dd>
					<dd><a href="<%=basePath %>book/findByTypeid?typeid=3">漫画书</a></dd>
					<dd><a href="<%=basePath %>book/findByTypeid?typeid=4">杂志</a></dd>
				</dl>
			</li>
			<li class="select-result">
				<dl>
					<dt style="margin-left:20px;">已选条件：</dt>
					<dd class="select-no">暂时没有选择过滤条件</dd>
				</dl>
			</li>
		</ul>
		<div class="tabs book clearfix">
			<div class="a1">
    			<c:forEach items="${list}" var="book" varStatus="status">  
    				<div class="a2">
				 		<div><a href="<%=basePath%>book/findByBookId?bookid=${book.id}"><img alt="无法显示该图片" src="${book.picture }" style="border: 1px solid #ccc;"></a></div>
				 		<div class="a3">${book.name }</div>
						<div class="a3">${book.price }</div>
						<div class="a3">${book.publisher }</div>
					</div>
			    </c:forEach> 
			<div class="clearfix"></div>
				<br>
   					<table class="fenye">
      					 <tr>
            				<td colspan="6" align="center" bgcolor="white" class="fenye2">共${page.totalRecords}条记录 共${page.totalPages}页 当前第${page.pageNo}页  
            				&nbsp;&nbsp;      
			                <a href="<%=request.getContextPath()%>/book/list1?pageNo=${page.topPageNo}"><input type="button" name="fristPage" value="首页" class="fenye2"/></a>&nbsp;
			                <c:choose>
			                  <c:when test="${page.pageNo!=1}">             
			                      <a href="<%=request.getContextPath()%>/book/list1?pageNo=${page.previousPageNo }"><input type="button" name="previousPage" value="上一页"  class="fenye2"/></a> &nbsp;               
			                  </c:when>
			                  <c:otherwise>   
			                      <input type="button" disabled="disabled" name="previousPage" value="上一页" />       
			                  </c:otherwise>
			                </c:choose>
			                <c:choose>
			                  <c:when test="${page.pageNo != page.totalPages}">
			                    <a href="<%=request.getContextPath()%>/book/list1?pageNo=${page.nextPageNo }"><input type="button" name="nextPage" value="下一页" class="fenye2"/></a>&nbsp;
			                  </c:when>
			                  <c:otherwise>    
			                      <input type="button" disabled="disabled" name="nextPage" value="下一页" />
			                  </c:otherwise>
			                </c:choose>
			                <a href="<%=request.getContextPath()%>/book/list1?pageNo=${page.bottomPageNo}"><input type="button" name="lastPage" value="尾页" class="fenye2"/></a>&nbsp;
			            </td>
        			</tr>
     			</table>
        	<br>
			
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
<script type="text/javascript">
	Qfast.add('widgets', { path: "<%=basePath %>js/terminator2.2.min.js", type: "js", requires: ['fx'] });
	Qfast(false, 'widgets', function () {
		K.tabs({
			id: 'fsD1',   //焦点图包裹id
			conId: "D1pic1",  //** 大图域包裹id
			tabId:"D1fBt",
			tabTn:"a",
			conCn: '.fcon', //** 大图域配置class
			auto: 1,   //自动播放 1或0
			effect: 'fade',   //效果配置
			eType: 'click', //** 鼠标事件
			pageBt:true,//是否有按钮切换页码
			bns: ['.prev', '.next'],//** 前后按钮配置class
			interval: 3000  //** 停顿时间
		})
	})
</script>
</body>
</html>