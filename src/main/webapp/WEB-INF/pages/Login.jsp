<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入</title>
<script src="https://kit.fontawesome.com/6cda0c2d7d.js"
	crossorigin="anonymous"></script>
<link rel="shortcut icon" type="image/x-icon" href="assets/images/smalllogo.png" />
</head>
<body>
	
	<%request.getSession().invalidate(); %>
	<jsp:include page="loginNav.jsp" />
	<div class="main" align="center">
		<div class="sign1">
			<figure>
			</figure>
			<h2 class="title">登入</h2>
			<form method="post" action="login">

				<div class=group>
					<label for="account"><i class="fa-solid fa-user"></i> </label> <input
						type="text" name="account" id="account" placeholder="account"
						autocomplete="off" value=account>
				</div>
				<div class=group>
					<label for="password"><i class="fa-solid fa-lock"></i> </label><input
						type="password" name="password" id="password"
						placeholder="password" autocomplete="off" value=password>
				</div>
				<div class=group>
					<input type="checkbox" name="remember me" id="remember me"><label>Remember
						me</label>
				</div>
				<div class="button">
					<input type="submit" name="signin" id="signin" value="登入">
				</div>
			</form>
			<div>
				如果您還沒有註冊，請點擊<a href="Register.jsp">快速註冊</a>
			</div>
		</div>
		</div>
		<Script>
			
		</Script>
</body>
</html>