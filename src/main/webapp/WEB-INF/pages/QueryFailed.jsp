<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
response.setContentType("text/html;charset=UTF-8");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查詢結果</title>
</head>
<body>
<jsp:include page="BackendHeader.jsp"/>

<br><br><br><br><br><br>
<h1><center>查無資料!!</center></h1>
<br><br><br>
<center><a href="CourseServlet"><input type="submit" name="return" value="返回課程列表"></a></center>

</body>
</html>