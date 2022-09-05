<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員註冊</title>
<link rel="stylesheet" href="css/style.css">
<script src="https://kit.fontawesome.com/6cda0c2d7d.js"
	crossorigin="anonymous"></script>


<link rel="shortcut icon" type="image/x-icon"
	href="assets/images/smalllogo.png" />
</head>
<body>
	<jsp:include page="loginNav.jsp" />
	<input type="hidden" id="status"
		value="<%=request.getAttribute("status")%>">

	<div class="main" align="center">
		<div class="sign1">
			<figure>
			</figure>
			<h2 class="title">註冊</h2>
			<form action="newRegister" method="post" modelAttribute="register" class="register-form" id="Register-form" onSubmit="return isValid(this);">
				<input type="hidden" name="command" value="login">
				<div class=group>
					<label for="account"><i class="fa-solid fa-user"></i> </label> <input
						type="text" name="account" id="account" placeholder="account"
						autocomplete="off" value="id" required>
				</div>
				<div class=group>
					<label for="password"><i class="fa-solid fa-lock"></i> </label><input
						type="password" name="password" id="password"
						placeholder="password" autocomplete="off" value="pwd"> <span
						id="message1" style="color: red"> </span>
				</div>
				<div class=group>
					<label for="password"><i class="fa-solid fa-lock"></i> </label><input
						type="password" name="password1" id="password1"
						placeholder="repeat password" autocomplete="off" value="pwd">
					<span id="message2" style="color: red"> </span>
				</div>
				<div class=group>
					<label for="email"><i class="fa-solid fa-envelope"></i></label><input
						type="email" name="email" id="email" placeholder="email"
						autocomplete="off" value="email@gmail.com">
				</div>
				<p>${errorMsgMap.RegisterError}</p>
				<div class="button">
					<input type="submit" name="signin" id="signin"
						onclick="matchPassword()" value="註冊">
				</div>
			</form>
			<div>
				已有帳號<a href="login.controller">登入</a>
			</div>
		</div>
		<script language="javascript">
			function isValid(form) {
				if (form.account.value == "") {
					alert("使用者名稱不能為空");
					return false;
				}
				if (form.password.value != form.password1.value) {
					alert("兩次輸入的密碼不同！");
					return false;
				} else if (form.password.value == "") {
					alert("使用者密碼不能為空！");
					return false;
				} else
					return true;
			}
		</script>
</body>

</html>