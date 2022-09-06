<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="fourth.dao.CourseDao"%>
<%@ page import="java.util.List"%>
<%@ page import="fourth.bean.CourseBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>課程功能列表</title>
<link rel="shortcut icon" type="image/x-icon"
	href="images/smalllogo.png" />
<style>
 .tb { 
 	border-collapse: collapse;  
  	margin-left:285px; 
	width: 1230px;
 	/*自動斷行*/ 
 	word-wrap: break-word;
  	table-layout: fixed;  
 } 

#delete{
	background-color: #FF0000;
}
</style>


</head>
<body>
	<jsp:include page="BackendHeader.jsp" />
	<jsp:include page="Style.jsp" />
<br><br><br><br>
	<div align="center">
	
         <form action="course.qname" method="post">
			<label> 課程名稱 : <input type="text" name="keyword" size="7">
 			</label> <input type="submit" name="query" value="查詢">
 		</form>

		<form action="course.qid" method="post">
		<label> 課程編號 : <input type="text" name="keyword" size="7"></label> <input
				type="submit" name="query" value="查詢">
		</form>
		<div align="center">
			<p>${errorMsgMap.QueryError}</p>
		</div>
		
	</div>

	<table class='tb'  border='1'>
		<tr>
			<td align="center">課程編號</td>
			<td align="center">課程圖片</td>
			<td align="center">課程名稱</td>
			<td align="center">課程時長</td>
			<td align="center">課程價格</td>
			<td align="center">已購買人數</td>
			<td align="center">上架日期</td>
			<td align="center">講師姓名</td>
			<td>課程資訊</td>
			<td>修改功能</td>
			<td>刪除功能</td>
		</tr>
		<%
		List<CourseBean> list = (List<CourseBean>) request.getAttribute("list");
		for (CourseBean courseBean : list) {
		%>

		<tr>
			<td><h4>
					<center><%=courseBean.getCourse_id()%></center>
				</h4></td>
			<td><img src="<%=courseBean.getCourse_picture()%>" alt=""
				title="" width="150" height="150"></td>
			<td><%=courseBean.getCourse_name()%></td>
			<td><%=courseBean.getCourse_duration()%></td>
			<td><center><%=courseBean.getCourse_price()%></center></td>
			<td><center><%=courseBean.getEnrollment()%></td>
			<td><%=courseBean.getCourse_date()%></center></td>
			<td><center><%=courseBean.getLecturer_name()%></center></td>
			<td>
				<%--request.setAttribute("bean", courseBean); --%> <a
				href="course.details?course_id=<%=courseBean.getCourse_id()%>"><input
					type="submit" name="details" value="查看詳情"></a>
			</td>
			<td>
				<%--request.setAttribute("bean", courseBean); --%> <a
				href="course.show?course_id=<%=courseBean.getCourse_id()%>"><input
					type="submit" name="update" value="修改課程"></a>
			</td>
			<td><a href="course.delete?course_id=<%=courseBean.getCourse_id()%>"><button
						onclick="if( !(confirm('確認刪除?') ) ) return false"  id='delete'
						type="submit" name="delete" value="刪除課程">刪除課程</button></a></td>
		</tr>


		<%
		}
		%>


	</table>
	<br><br>
	<div align="center">
		<a href="course.add"><input type="submit" name="addcourse"
			value="新增課程"></a>
	</div>




</body>
</html>