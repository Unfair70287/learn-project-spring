<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", -1); // Prevents caching at the proxy server
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update</title>
<style>
.write {
	border: 3px dotted black
}
</style>

</head>
<body>
	<jsp:include page="Header.jsp" />
	<form action="updateAction" method="post">
		<fieldset>
			<legend>修改專欄</legend>
			
			<div class="st1">
				<label for="" class="t1">文章編號</label> <input class="st2" type="text"
					name="article_no" value="<%=request.getParameter("article_no")%>" readonly>
			</div>
			<br>
			<div class="st1">
				<label for="" class="t1">發佈時間:</label> <input class="st2"
					type="date" name="publish_time"
					value="<%=request.getParameter("publish_time")%>">
			</div>
			<div class="st1">
				<br> <label for="account1" class="t1">使用者編號:</label> <input
					class="st2" type="text" id="account1" autocomplete="off"
					name="user_id" value="<%=request.getParameter("user_id")%>">
			</div>
			<br>
			<div class="st1">
				<label for="pwd1" class="t1">作者:</label><input class="st2"
					type="text" id="pwd1" name="author"
					value="<%=request.getParameter("author")%> ">
			</div>
			<br>
			<div class="st1">
				<label for="" class="t1">權限:</label> <input class="st2" type="text"
					name="role" value="<%=request.getParameter("role")%>"> <br>
			</div>
			<br> <label class="t1">內容:</label>
			<textarea class="write" cols="10" rows="10" name="contents"><%=request.getParameter("contents")%></textarea>

		</fieldset>
		<center>
			<div class="sub">
				<input type="submit" value="送出">
				 <input type="hidden" name="update" value="update">
				  <input type="submit" name="backToQuery" value="返回">
			</div>
		</center>
	</form>
</body>
</html>