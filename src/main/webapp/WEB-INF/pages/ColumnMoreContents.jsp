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
<title>文章內容</title>
<style>

</style>
</head>
<body>
<jsp:include page="Header.jsp"/>

<<form action="QueryAll" method="get" > 
		
			<table>
			<jsp:useBean id="col"  scope="session" class="fourth.bean.ColumnBean"/>
			<td   class="st1">
				<label for="" class="t1">文章編號:</label>
				<jsp:getProperty name="col" property="article_no"/>
			</td>
			
			<br>
			<td   class="st1"> 
				<label for="" class="t1">發佈時間:</label> 
				<jsp:getProperty name="col" property="publish_time"/>
			</td>
			<br>
			<td  class="st1">

				<label for="account1" class="t1">使用者編號:</label> 
				<jsp:getProperty name="col" property="user_id"/>
			</td>
			<br>
	
			<td   class="st1">
				<label for="pwd1" class="t1">作者:</label>
				<jsp:getProperty name="col" property="author"/>
			</td>
			<br>

			<td   class="st1">
				<label for="" class="t1">權限:</label> 
				<jsp:getProperty name="col" property="role"/>

			</td>
			</table>
			<table>
			<td   class="st1">
				<label class="t1"></label> 
				<jsp:getProperty name="col" property="contents"/>
				</td>
	</table>
<form action="QueryAll" method="post" >
	<center>
<input type="submit" name= "backToQuery" value="返回">
</center>
		
	</form>
</body>
</html>