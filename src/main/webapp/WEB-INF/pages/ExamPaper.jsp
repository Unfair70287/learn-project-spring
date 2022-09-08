<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,fourth.bean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
</style>
</head>
<body>
	<jsp:include page="Header.jsp" />
	<%
	List<ExamQuesBean> theQuestable =(List<ExamQuesBean>) session.getAttribute("examQuTable");
	%>

	<div>
		<form action="ExamController" method="post">
	        <table class="tb">
	            <tr>
	                <td>
	                    <label>考卷名稱:</label>
	                </td>
	            </tr>

				<% int i=0;%>
	            <c:forEach items="${examQuTable}" var="que">
	            <tr>
	                <td>
	                	<% i++;%>
	                    <label>${que.quesContent}:</label><br>
						<input type="radio" name="answer<%=i%>" id="" value="A" required>A.${que.optA}
						<input type="radio" name="answer<%=i%>" id="" value="B">B.${que.optB}
						<input type="radio" name="answer<%=i%>" id="" value="C">C.${que.optC}
						<input type="radio" name="answer<%=i%>" id="" value="D">D.${que.optD}
	                </td>
	            </tr>
	            </c:forEach>

	            <tr>
	                <td>
	                    <center>
	                        <input type="submit" name="todo" value="testSubmit">
	                    </center>
	                </td>
	            </tr>
	        </table>
		</form>
	</div>

</body>


</html>