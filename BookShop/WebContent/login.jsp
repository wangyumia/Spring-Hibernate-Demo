<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD Xhtml 1.0 Transitional//EN" "http://www.w3.org/TR/xjsp1/DTD/xjsp1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/index.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/animate-custom.css" />
</head>
<body style="background: #fff url(images/bg.jpg) repeat top left;">

<div id="container_demo" >
	<a class="hiddenanchor" id="toregister"></a>
	<a class="hiddenanchor" id="tologin"></a>
	<div id="wrapper">
		<div id="login" class="animate form">
			<form  method="post" action="<%=basePath %>userlogin" autocomplete="on">
				<h1>登录</h1> 
				<p> 
					<label for="username" class="uname" data-icon="u" >您的用户名</label>
					<input id="username" name="username" required="required" type="text" placeholder="请输入用户名"/>
					
				</p>
				<p> 
					<label for="password" class="youpasswd" data-icon="p">你的密码</label>
					<input id="password" name="password" required="required" type="password" placeholder="请输入密码" />
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
			<form method="post" action="<%=basePath %>user/saveuser" autocomplete="on">
				<h1>注册</h1> 
				<p> 
					<label for="usernamesignup" class="uname" data-icon="u">用户名</label>
					<input id="usernamesignup" name="username" required="required" type="text" placeholder="用户名" />
				</p>
				<p> 
					<label for="tel" class="youmail">联系电话</label>
					<input id="tel" name="tel" required="required" type="tel" placeholder="联系电话"/>
				</p>
				<p>
					<label>你的大学</label>
					<select name="" id="college" >
						<option value="">请选择你的大学</option>
						<option value="">河北师范大学</option>
						<option value="">清华大学</option>
						<option value="">北京大学</option>
						<option value="">南开大学</option>
					</select>
				</p>
				<p>
					<label>你的学院</label>
					<select name="" id="academy">
						<option value="">请选择你的学院</option>
						<option value="">软件学院</option>
						<option value="">文学院</option>
						<option value="">外国语学院</option>
						<option value="">软件学院</option>
					</select>
				</p>
				<p>
					<label>你的专业</label>
					<select name="" id="special" >
						<option value="">请选择你的专业</option>
						<option value="">软件工程</option>
						<option value="">传播学</option>
						<option value="">广告学</option>
						<option value="">艺术学</option>
					</select>
				</p>
				<p> 
					<label for="passwordsignup" class="youpasswd" data-icon="p">密码</label>
					<input id="passwordsignup" name="password" required="required" type="password" placeholder="密码"/>
				</p>
				<p> 
					<label for="passwordsignup_confirm" class="youpasswd" data-icon="p">确认密码</label>
					<input id="passwordsignup_confirm" name="repassword" required="required" type="password" placeholder="确认密码"/>
				</p>
				<p> 
					<label for="address" class="address" data-icon="p">详细地址</label>
					<input id="address" name="address" required="required" type="add" placeholder="地址"/>
				</p>
				<p> 
					<label for="email" class="email" data-icon="p">电子邮箱</label>
					<input id="email" name="email" required="required" type="ema" placeholder="电子邮箱"/>
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