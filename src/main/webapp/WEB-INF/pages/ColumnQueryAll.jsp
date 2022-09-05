<%@page import="org.springframework.ui.Model"%>
<%@page
	import="org.eclipse.jdt.internal.compiler.env.IUpdatableModule.UpdateKind"%>
<%@page import="fourth.dao.ColumnDAO1"%>
<%@page import="java.util.*"%>
<%@page import="fourth.bean.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="fourth.dao.ColumnDAO1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%
response.setContentType("text/html;charset=UTF-8");
response.setCharacterEncoding("UTF-8");
request.setCharacterEncoding("UTF-8");

response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", -1); // Prevents caching at the proxy server
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>專欄</title>
<style>
.listname {
	text-align: center
}
</style>
</head>



<body>
	<jsp:include page="Header.jsp" />


	<center>
		<h1>專欄列表</h1>
		<h2></h2>
	</center>


	<a href="ColumnAdd">
		<button>新增專欄</button>
	</a>


	<form action="searchAction" method="post" enctype="multipart/form-data">
		<input type="text" name="search"> <input type="submit"
			name="searchno" value="查詢">
	</form>



	<table border="1">


		<tr>
			<th>文章編號</th>
			<th>發表日期</th>
			<th>使用者編號</th>
			<th>作者名稱</th>
			<th>權限</th>
			<th>內容</th>
			<th>功能</th>
		</tr>

		<c:choose>
			<c:when test="${column != null }">
				<c:set var="col" value="${column }" />
				<td>${col.article_no }</td>
				<td>${col.publish_time }</td>
				<td>${col.user_id}</td>
				<td>${col.author }</td>
				<td>${col.role }</td>
				<td>${col.contents }</td>
			</c:when>

			<c:otherwise>
				<%
					List<ColumnBean> selectAllColumns = (List<ColumnBean>) request.getAttribute("queryall");

					for (ColumnBean c : selectAllColumns) {
					%>
				<tr>

					<td><%=c.getArticle_no()%></td>
					<td><%=c.getPublish_time()%></td>
					<td><%=c.getUser_id()%></td>
					<td><%=c.getAuthor()%></td>
					<td><%=c.getRole()%></td>
					<td
						style="width: 100px; overflow: hidden; white-space: nowrap; word-break: keep-all;"><div
							style="width: 100px; overflow: hidden; white-space: nowrap;"><%=c.getContents()%></div></td>

					<td><a
						href="Update?article_no=<%=c.getArticle_no()%>&publish_time=<%=c.getPublish_time()%>&user_id=<%=c.getUser_id()%>&author=<%=c.getAuthor()%>&role=<%=c.getRole()%>&contents=<%=c.getContents()%>"><button
								name="edit" value="edit">編輯</button></a></td>


					<form action="more?article_no=<%=c.getArticle_no()%>" method="post">
					<td><input type="submit" name="more" value="更多"> <input
						type="hidden" name="article_no" value="<%=c.getArticle_no()%>"></td>
					</form>

					<form action="ColumnDelete?article_no=<%=c.getArticle_no()%>"
						method="post" enctype="multipart/form-data">
					<td><input type="submit" name="delete" value="刪除"></td>
					<input type="hidden" name="article_no"
						value="<%=c.getArticle_no()%>">
					</form>

				</tr>
				<%
					}
					%>
			</c:otherwise>
		</c:choose>
	</table>


</body>
</html>