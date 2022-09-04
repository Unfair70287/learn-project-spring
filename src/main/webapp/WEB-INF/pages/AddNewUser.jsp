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
<title>新增使用者</title>
<link rel="shortcut icon" type="image/x-icon"
	href="assets/images/smalllogo.png" />
<style>
.tb {
	margin-left: 300px;
}
</style>
</head>
<body>
	<jsp:include page="BackendHeader.jsp" />
	<jsp:include page="Style.jsp" />
	<br>
	<br>
	<br>
	<%-- 	<c:if test="${sessionScope.user == null}"><% request.getRequestDispatcher("/Login.jsp").forward(request, response); %></c:if> --%>
	<%
	String action = "";
	%>
	<c:if test="${mb != null}">
		<%
		action = "update";
		%>
	</c:if>
	<c:if test="${mb == null}">
		<%
		action = "insertNewUser";
		%>
	</c:if>
	<header>
		<br> <br>
		<div align="center">
			<h2>
				<c:if test="${mb != null}">
                        修改會員
                    </c:if>
				<c:if test="${mb == null}">
                        新增會員
                    </c:if>
			</h2>
		</div>
	</header>
	<hr>
	<form action="<%=action%>" method="post"
		onSubmit="return checkNull(this)">
		<table class="tb" cellspacing="2" cellpadding="1" border="50" width="60%">

			<c:if test="${mb != null}">
				<input type="hidden" name="user_id" value="${mb.user_id}" />
			</c:if>
			<tr>
				<td>綽號:</td>
				<td><input type="text" title="綽號" name="nick" size="10"
					maxlength="10" value="<c:out value='${mb.nick}' />" />(請輸入0~10個字)</td>
			</tr>
			<tr>
				<td>帳號:</td>
				<td><input type="text" title="帳號" name="account" maxlength="10"
					value="<c:out value='${mb.account}' />" /></td>
			</tr>
			<tr>
				<td>密碼:</td>
				<td><input type="text" title="密碼" name="password"
					maxlength="20" value="<c:out value='${mb.password}' />" /></td>
			</tr>
			<tr>
				<td>身分:</td>
				<td><select name="status" title="身分">
						<option value="1" <c:if test="${mb.status=='1'}"></c:if>>學生</option>
						<option value="2" <c:if test="${mb.status=='2'}"></c:if>>老師</option>
						<option value="3" <c:if test="${mb.status=='3'}"></c:if>>管理員</option>
				</select></td>
			</tr>
			<tr>
				<td>姓名:</td>
				<td><input type="text" title="姓名" name="name" maxlength="10"
					value="<c:out value='${mb.name}' />" /></td>
			</tr>
			<tr>
				<td>大頭貼:</td>
				<td><input type="file" title="大頭貼" name="img"
					value="<c:out value='${mb.img}' />" /></td>
			</tr>
			<tr>
				<td>性別:</td>
				<td><select name="sex">
						<option value="男生" <c:if test="${mb.sex=='男生'}"></c:if>>男生</option>
						<option value="女生" <c:if test="${mb.sex=='女生'}"></c:if>>女生</option>
				</select></td>
			</tr>
			<tr>
				<td>生日:</td>
				<td><input type="date" title="生日" name="birthday"
					value="<c:out value='${mb.birthday}' />" /></td>
			</tr>
			<tr>
				<td>聯絡電話:</td>
				<td><input type="text" title="連絡電話" name="cellphone" size="20"
					value="<c:out value='${mb.cellphone}' />" /></td>
			</tr>
			<tr>
				<td>電子郵件:</td>
				<td><input type="text" title="電子郵件" name="email" size="20"
					maxlength="100" value="<c:out value='${mb.email}' />" /></td>
			</tr>
			<tr>
				<td>加入時間:</td>
				<td><input type="date" title="加入時間" name="joinDate" size="50"
					maxlength="20" value="<c:out value='${mb.joinDate}' />" /></td>
			</tr>

		</table>
		<br>
		<div align="center">
			<input type="submit" value="儲存" />
		</div>
	</form>
	<script type="text/javascript">
		function checkNull(form) {
			for (i = 0; i < form.length; i++) {
				if (form.elements[i].value == "") {
					alert("【 " + form.elements[i].title + " 】" + "不能為空!!!");
					form.elements[i].focus(); //當前元素獲取焦點
					return false;
				}
			}
		}
	</script>

</body>
</html>