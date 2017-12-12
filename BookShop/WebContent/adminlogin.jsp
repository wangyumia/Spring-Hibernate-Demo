<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AdminLogin</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/index.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/animate-custom.css" />
</head>
<body style="background: #fff url(images/bg.jpg) repeat top left;">

<div id="container_demo" >
	<a class="hiddenanchor" id="toregister"></a>
	<a class="hiddenanchor" id="tologin"></a>
	<div id="wrapper">
		<div id="login" class="animate form">
			<form  method="post" action="<%=basePath %>adminlogin" autocomplete="on">
				<h1>管理员登录</h1> 
				<p> 
					<label for="username" class="uname" data-icon="u" >您的用户名</label>
					<input id="username" name="adminname" required="required" type="text" placeholder="请输入用户名"/>
					
				</p>
				<p> 
					<label for="password" class="youpasswd" data-icon="p">你的密码</label>
					<input id="password" name="adminpassword" required="required" type="password" placeholder="请输入密码" />
				</p>
				<p class="keeplogin"> 
					<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
					<label for="loginkeeping">保持登录状态</label>
				</p>
				<p class="login button"> 
					<input type="submit" value="登录" /> 
				</p>
				<p class="change_link">
					不是成员?<a href="#toregister" class="to_register">加入我们</a>
				</p>
			</form>
		</div>

		<div id="register" class="animate form">
			<form method="post" action="<%=basePath %>admin/saveadmin" autocomplete="on">
				<h1>注册</h1> 
				<p> 
					<label for="usernamesignup" class="uname" data-icon="u">用户名</label>
					<input id="usernamesignup" name="adminname" required="required" type="text" placeholder="用户名" />
				</p>
				<p> 
					<label for="passwordsignup" class="youpasswd" data-icon="p">密码</label>
					<input id="passwordsignup" name="adminpassword" required="required" type="password" placeholder="密码"/>
				</p>
				<p> 
					<label for="passwordsignup_confirm" class="youpasswd" data-icon="p">确认密码</label>
					<input id="passwordsignup_confirm" name="repassword" required="required" type="password" placeholder="确认密码"/>
				</p>
				<p class="signin button"> 
					<input type="submit" value="注册"/> 
				</p>
				<p class="change_link">  
					已经是成员?<a href="#tologin" class="to_register"> 去登录 </a>
				</p>
			</form>
		</div>
		
	</div>
	
</div>
	
</body>
</html>