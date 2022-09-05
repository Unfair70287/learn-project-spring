<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,fourth.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script>
	function post(url, params) {
		var temp = document.createElement(“form”);
		temp.action = url;
		temp.method = “post”;
		temp.style.display = “none”;
		for (var x in params) {
		var opt = document.createElement(“textarea”);
		opt.name = x;
		opt.value = params[x];
		temp.appendChild(opt);
		}
		document.body.appendChild(temp);
		temp.submit();
		return temp;
	}
</script>
</head>
<body>
	<%=request.getAttribute("ecpay") %>
</body>
</html>