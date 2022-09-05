<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,fourth.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">

<link rel="shortcut icon" type="image/x-icon"
	href="assets/images/smalllogo.png" />
</head>
<style>
.confirm {
	align: center;
	justify-content: center;
}
</style>
<body>
	<c:choose>
		<c:when test="${sessionScope.user.status == 3}">
			<jsp:include page="BackendHeader.jsp" />

			<jsp:include page="orderAdminUpdate.jsp" />

		</c:when>

		<c:otherwise>
			<jsp:include page="Header.jsp" />

			<jsp:include page="orderUserUpdate.jsp" />

		</c:otherwise>
	</c:choose>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
</body>
</html>