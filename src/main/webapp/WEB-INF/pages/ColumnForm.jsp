<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Column Management</title>
</head>
<body>
	<center>
	<h1>Column Management</h1>
	<h2>
	<a href = "/new">Add New Column</a>
	&nbsp;&nbsp;&nbsp;
     <a href="/list">List All Columns</a>
	</h2>
	</center>
	
	<div align = "center"></div>
	<c:if test="${book !=null} "> 
	<form action = "update"  method="post">
	</c:if>
	
	<c:if test="${column==null }">
	<form action = "insert" method="post">
	</c:if>>
	
	<table border = "1" cellpadding = "5">
	<caption>
	<h2>
	<c:if test = "${column !=null }">
	Edit Column
	</c:if>
	<c:if test = "${column==null }">
	Add New Column
	</c:if>	
	</h2>
	</caption>
	<c:if test = "${column !=null }">
	<input type = "hidden" name="no"  value="<c:out value= '${column.no }'/>"/>
	</c:if>
	
	<tr>
	<th>date</th>
	<td>
	<input type="text" name="date" size="45" value="<c:out value='${column.date }'/>"/>
	</td>
     </tr>
     
     <tr>
	<th>id</th>
	<td>
	<input type="text" name="id" size="45" value="<c:out value='${column.id }'/>"/>
	</td>
     </tr>

     <tr>
	<th>author</th>
	<td>
	<input type="text" name="author" size="45" value="<c:out value='${column.author }'/>"/>
	</td>
     </tr>
     
     <tr>
	<th>role</th>
	<td>
	<input type="text" name="role" size="45" value="<c:out value='${column.role }'/>"/>
	</td>
     </tr>
     
     <tr>
	<th>contents</th>
	<td>
	<input type="text" name="contents" size="45" value="<c:out value='${column.contents }'/>"/>
	</td>
     </tr>
     
     <tr>
     <td colspan = "2" align = "center">
     <input type = "submit" value="save"/>
     </td>
     </tr>
     </table>
    
   


	
</body>
</html>