<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fourth.bean.MemberBean"%>
<%@ page import="fourth.dao.MemberDao"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員後台</title>
<link rel="shortcut icon" type="image/x-icon"
	href="assets/images/smalllogo.png" />
<style>
.tb {
	border-collapse: collapse;
	margin-left: 400px;
	width: 1400px;
	/*自動斷行*/
	word-wrap: break-word;
	table-layout: fixed;
}
</style>
</head>
<body>
	<jsp:include page="BackendHeader.jsp" />
	<jsp:include page="Style.jsp" />
	<br>
	<%-- 	<c:if test="${sessionScope.user == null}"> --%>
	<%-- 		<% --%>
	<!-- 	// request.getRequestDispatcher("/Login.jsp").forward(request, -->
	<!-- 	response); -->
	<%-- 		%> --%>
	<%-- 	</c:if> --%>
	<br>
	<br>
	<br>
	<br>
	<div align="center">
		<a href="addNewUser">新增會員</a>
	</div>
	<br>
	<div align="center">
		<form action="queryAccount" method="post">
			<label> 帳號查詢 : <input type="text" name="keyword_account">
			</label> <input type="submit" name="query" value="查詢">
				<p>${errorMsgMap.QueryError}</p>
		</form>
	</div>
	<hr>
	<div>
		<h3>會員清單</h3>
	</div>
	<table class='tb' border='1'>
		<thead>
			<tr>
				<th>ID</th>
				<th>暱稱</th>
				<th>帳號</th>
				<!-- <th>密碼</th> -->
				<th>身分</th>
				<th>姓名</th>
				<th>大頭貼</th>
				<th>性別</th>
				<th>生日</th>
				<th>手機號碼</th>
				<th>信箱</th>
				<th>註冊日期</th>
				<th>Actions</th>
			</tr>
		</thead>
		<c:forEach var="mb" items="${listMembers}">

			<tbody>

				<tr>
					<td><c:out value="${mb.user_id}" /></td>
					<td><c:out value="${mb.nick}" /></td>
					<td><c:out value="${mb.account}" /></td>
					<!-- <td><c:out value="${mb.password}" /></td> -->
					<td><c:choose>
							<c:when test="${mb.status==1}">
             		 						學生
       							</c:when>
							<c:when test="${mb.status==2}">
              								老師
       							</c:when>
							<c:otherwise>
              						管理員
       							</c:otherwise>
						</c:choose></td>
					<td><c:out value="${mb.name}" /></td>
					<td><img src="${mb.img}" width="150" height="100"></td>
					<td><c:out value="${mb.sex}" /></td>
					<td width="150px"><c:out value="${mb.birthday}" /></td>
					<td width="159px"><c:out value="${mb.cellphone}" /></td>
					<td width="200px"><c:out value="${mb.email}" /></td>
					<td width="300px"><c:out value="${mb.joinDate}" /></td>
					<td><a href="showEditUser?account=${mb.account} ">修改</a> <a
						onclick="if( !(confirm('確認刪除?') ) ) return false"
						href="deleteUser?account=${mb.account} ">刪除</a></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>

</body>
</html>