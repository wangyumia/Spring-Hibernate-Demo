<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<script src="<%=basePath %>js/jquery-1.11.2.min.js"></script>
	<script src="<%=basePath %>js/main.js"></script>
	<script type="text/javascript">
		//图片上传预览    IE是用了滤镜。
		function previewImage(file)
		{
			var MAXWIDTH  = 260;
			var MAXHEIGHT = 180;
			var div = document.getElementById('preview');
			if (file.files && file.files[0])
			{
				div.innerjsp ='<img id=imghead>';
				var img = document.getElementById('imghead');
				img.onload = function(){
					var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
					img.width  =  rect.width;
					img.height =  rect.height;
//                 img.style.marginLeft = rect.left+'px';
					img.style.marginTop = rect.top+'px';
				}
				var reader = new FileReader();
				reader.onload = function(evt){img.src = evt.target.result;}
				reader.readAsDataURL(file.files[0]);
			}
			else //兼容IE
			{
				var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
				file.select();
				var src = document.selection.createRange().text;
				div.innerjsp = '<img id=imghead>';
				var img = document.getElementById('imghead');
				img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
				var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
				status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
				div.innerjsp = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
			}
		}
		function clacImgZoomParam( maxWidth, maxHeight, width, height ){
			var param = {top:0, left:0, width:width, height:height};
			if( width>maxWidth || height>maxHeight )
			{
				rateWidth = width / maxWidth;
				rateHeight = height / maxHeight;

				if( rateWidth > rateHeight )
				{
					param.width =  maxWidth;
					param.height = Math.round(height / rateWidth);
				}else
				{
					param.width = Math.round(width / rateHeight);
					param.height = maxHeight;
				}
			}

			param.left = Math.round((maxWidth - param.width) / 2);
			param.top = Math.round((maxHeight - param.height) / 2);
			return param;
		}
	</script>
	<title>易书网</title>
</head>
<style>
	.help-main {
		padding: 0;
	}
	select{
		padding: 3px 10px;
	}
</style>
<body >

<div class="top" id="item4">
	<div class="container clearfix">
		<ul class="clearfix fr">
			<li><a href="<%=basePath %>login.jsp#tologin" >登录</a></li>
			<li><a href="<%=basePath %>login.jsp#toregister" >注册</a></li>
			<li><a href="<%=basePath %>member.jsp">个人中心</a></li>
			<li><a href="<%=basePath %>bought.jsp"  style="border: none" >购物车</a></li>
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

<div class="help-wrap">
	<div class="container clearfix">
		<div class="bread">当前位置：
			<a href="<%=basePath %>book/list1">首页</a> 
			<a href="<%=basePath %>member.jsp">个人中心</a> 
			<a href="<%=basePath %>edit.jsp">编辑发布</a>
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
			<div class="help-item-title">发布书籍</div>
			<div class="help-main">
				<form action="" method="post">
					<div class="product-edit-item clearfix">
						<div class="product-edit-item-l fl">
							<div class="fr"><i class="middle">*</i>图书分类1：</div>
						</div>
						<div class="product-edit-item-r fl">
							<select name=""  >
								<option value="">图书所属学校</option>
								<option value="">江西师范大学</option>
								<option value="">清华大学</option>
								<option value="">北京大学</option>
								<option value="">南开大学</option>
							</select>
						</div>
					</div>
					<div class="product-edit-item clearfix">
						<div class="product-edit-item-l fl">
							<div class="fr"><i class="middle">*</i>图书分类2：</div>
						</div>
						<div class="product-edit-item-r fl">
							<select name=""  >
								<option value="">图书所属学院</option>
								<option value="">传播学院</option>
								<option value="">文学院</option>
								<option value="">外国语学院</option>
								<option value="">软件学院</option>
							</select>
						</div>
					</div>
					<div class="product-edit-item clearfix">
						<div class="product-edit-item-l fl">
							<div class="fr"><i class="middle">*</i>图书分类3：</div>
						</div>
						<div class="product-edit-item-r fl">
							<select name=""  >
								<option value="">图书所属专业</option>
								<option value="">教育技术学</option>
								<option value="">传播学</option>
								<option value="">广告学</option>
								<option value="">艺术学</option>
							</select>
						</div>
					</div>
					<div class="product-edit-item clearfix">
						<div class="product-edit-item-l fl">
							<div class="fr"><i class="middle">*</i>图书分类4：</div>
						</div>
						<div class="product-edit-item-r fl">
							<select name=""  >
								<option value="">图书所属年级</option>
								<option value="">大一</option>
								<option value="">大二</option>
								<option value="">大三</option>
								<option value="">大四</option>
							</select>
						</div>
					</div>
					<div class="product-edit-item clearfix">
						<div class="product-edit-item-l fl clearfixc">
							<div class="fr"><i class="middle">*</i>图书名称：</div>
						</div>
						<div class="product-edit-item-r fl">
							<input type="text" value="福尔摩斯探案全集" style="width: 410px">
							<p >图书标题名称长度至少3个字符，最长50个汉字</p>
						</div>
					</div>
					<div class="product-edit-item clearfix">
						<div class="product-edit-item-l fl clearfixc">
							<div class="fr"><i class="middle">*</i>图书价格：</div>
						</div>
						<div class="product-edit-item-r fl">
							<input type="text" value="150.00" style="width: 60px"><em class="add-on"><i class="icon-renminbi"></i></em>
							<p >价格必须是0.01~9999999之间的数字，且不能高于市场价。<br>此价格为图书实际销售价格，如果图书存在规格，该价格显示最低价格。</p>
						</div>
					</div>
					<div class="product-edit-item clearfix">
						<div class="product-edit-item-l fl clearfixc">
							<div class="fr"><i class="middle">*</i>图书描述：</div>
						</div>
						<div class="product-edit-item-r fl">
							<textarea name=""  cols="30" rows="10"></textarea>
							<p >请如实描述你所发布书籍的详细情况，以方便其他会员购买！</p>
						</div>
					</div>
					<div class="product-edit-item clearfix">
						<div class="product-edit-item-l fl clearfixc">
							<div class="fr"><i class="middle">*</i>上传封面：</div>
						</div>
						<div class="product-edit-item-r fl">
							<div id="preview">
								<img id="imghead" border=0 src="images/book.jpg" />
							</div>
							<input type="file" onchange="previewImage(this)" />
							<p >请上传图书封面，尽量保持图片清晰</p>
						</div>
					</div>
					<div class="product-edit-item clearfix">
						<div class="product-edit-item-l fl clearfixc" style="border: none;border-top:1px solid #E6E6E6">
						</div>
						<div class="product-edit-item-r fl" style="border: none;border-top:1px solid #E6E6E6">
						</div>
					</div>
					<div class="upload"><label><input type="submit" value="点击保存"></label></div>
				</form>
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