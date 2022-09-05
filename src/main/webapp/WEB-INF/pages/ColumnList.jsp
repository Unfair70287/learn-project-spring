<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
   
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
<title>Column List</title>
</head>
<body>
 <center> 
	<h1>Column Management</h1>
	<h2>
		<a href ="/new">Add New Column</a>
		&nbsp;&nbsp;&nbsp;
		<a href = "/list">List All Columns</a>
	</h2>
	</center>
	
	<div align="center">
	<table border = "1" cellpadding = "5">
	<caption><h2>List of Columns</h2></caption>
	
	<tr>
		<th>Article_no</th>
		<th>Date</th>
		<th>User_ID</th>
		<th>Author</th>
		<th>Role</th>
		<th>Contents</th>
		<th>Action</th>
		</tr>
		
		
		
		<c:forEach var="column" items="${listColumn}">
                <tr>
                    <td><c:out value="${column.no}" /></td>
                    <td><c:out value="${column.date}" /></td>
                    <td><c:out value="${column.id}" /></td>
                    <td><c:out value="${column.author}" /></td>
                    <td><c:out value="${column.role}" /></td>
                    <td><c:out value="${column.contents}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${column.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${column.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
		</table>
		</div>
		
</body>
</html>