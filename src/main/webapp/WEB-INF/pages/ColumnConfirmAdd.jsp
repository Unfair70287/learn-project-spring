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
<title>ConfirmAdd</title>
<style>
</style>
</head>
<body>
	<jsp:include page="Header.jsp" />

	<form action="ColumnServlet" method="get" enctype="multipart/form-data">
		<fieldset>
			<legend>新增專欄</legend>
			<table>
				<td class="st1"><label for="" class="t1">發佈時間:</label> <%=request.getParameter("publish_time")%>
				</td>
				<td class="st1"><label for="account1" class="t1">使用者編號:</label >
					<%=request.getParameter("user_id")%></td>

				<td class="st1"><label for="pwd1" class="t1">作者:</label> <%=request.getParameter("author")%>
				</td>

				<td class="st1"><label for="" class="t1">權限:</label> <%=request.getParameter("role")%>

				</td>
			</table>
			<table>
				<td class="st1"><label class="t1"></label> <%=request.getParameter("contents")%>
				</td>
			</table>
		</fieldset>


		<center>
			<div class="sub">
				<input type="submit" name="confirm">
				<button><a href="ColumnAdd.jsp">返回</a></button>

			</div>
		</center>
	</form>
</body>
</html>