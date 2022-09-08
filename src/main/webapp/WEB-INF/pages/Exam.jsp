<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,fourth.bean.*,java.util.Date,java.text.SimpleDateFormat,java.text.DateFormat"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
    <style>
    	
    	
    	.divform{
    	
    		width: 1000px;
    		margin:auto;
    	}
    	

		.tb{
			border: solid 3px gray;
		    border-collapse: collapse;
		    width: 1000px;  
		    /*自動斷行*/
		    word-wrap: break-word;
		    table-layout: fixed;
		}
		   
/* 		.th1,.tdform,th{ */
         
/*             text-align: center; */
/*         } */
               
    </style>

</head>
<body>

	<jsp:include page="Header.jsp" />
	<!-- 選項與CRUD按鈕 -->
<div class="divform">
	<form action="ExamController" method="post">
		<div>
			<label >科目:</label> 
			<select name="quSubject" size="1">
				<option value="數學">數學</option>
				<option value="英文">英文</option>
				<option value="國文">國文</option>
			</select> 
			<label>程度:
			</label> 
			<select name="quEducation" size="1">
				<option value="國中">國中</option>
				<option value="高中">高中</option>
				<option value="成人">成人</option>
			</select> 
		</div>

		<div>
			<input type="submit" name="todo" value="query"> 
			<input type="submit" name="todo" value="queryAll"> 
			<input type="submit" name="todo" value="upload"> 
		</div>
		<!-- 表格 -->
		
		<table class="tb" align="center">
			<caption>
				<h2>試卷名稱</h2>
			</caption>
			<thead>
				<tr>
				</tr>
				<tr>
					<th>項次</th>
					<th>科目</th>
					<th>程度</th>
					<th>名稱</th>
					<th>年度</th>
					<th>刪除</th>
					<th>更新</th>
					<th>考試</th>
				</tr>
			</thead>

		<%
	    List<ExamBean> examTable = (List<ExamBean>) request.getAttribute("examTable");
	    if (examTable != null && examTable.size() > 0) {
	    for (int i = 0; i < examTable.size(); i++) {
	    	
	    	
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();        
			String dateToStr = dateFormat.format(examTable.get(i).getExamdate());
			
	    %>
		<tbody>
			<tr>
				<%--                 <td><input type="checkbox" name="examTableIndex" value="<%= i %>"></td> --%>
				<td><%= i+1 %></td>
<%-- 				<td><%= examTable.get(i).getExamID() %></td> --%>
				<td><%= examTable.get(i).getSubject().getSubjectName() %></td>
				<td><%= examTable.get(i).getEducation().getEducationName() %></td>
				<td><%= examTable.get(i).getExamName() %></td>
<%-- 				<td><%= examTable.get(i).getExamdate() %></td> --%>
				<td><%= dateToStr %></td>
				<form action="ExamController" method="post">
					<input type="hidden" name="examID" value="<%= examTable.get(i).getExamID() %>"> 
					<input type="hidden" name="subject" value="<%= examTable.get(i).getSubject().getSubjectName() %>">
					<input type="hidden" name="education" value="<%= examTable.get(i).getEducation().getEducationName() %>"> 
					<input type="hidden" name="examName" value="<%= examTable.get(i).getExamName()%>"> 
<%-- 					<input type="hidden" name="examDate" value="<%= examTable.get(i).getExamdate()%>"> --%>
					<input type="hidden" name="examDate" value="<%= dateToStr%>">
				<td><input type="submit" name="todo" value="delete" onclick="if( !(confirm('確認刪除?') ) ) return false"></td>
				<td><input type="submit" name="todo" value="update"> </td>
				<td><input type="submit" name="todo" value="test"></td>			
<%-- 				<td><a href="ExamUpdate.jsp?UpIndex=<%= i %>&examID=<%= examTable.get(i).getExamID() %>"><button type="button" value="Update">Update</button></a></td> --%>
				</form>
			</tr>
		</tbody>

		<%
         } // for loop
         %>

		<%
    }  // if
    %>
		</table>
		
	</form>
</div>
</body>
</html>