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
<title>Add</title>
<style>
.divform{
width:500px;
margin:auto;
}
</style>

</head>
<body>
	<jsp:include page="Header.jsp" />
	
				<input type="hidden" name="add" value="add">
		<fieldset>
	<form action="ColumnAddAction" method="post" >
		<div class=" divform">
			<div class="st1 ">
<!-- 			<form action="ColumnAddAction" method="post" > -->
			<legend>新增專欄</legend>
				<label for="" class="t1">發佈時間:</label> <input type="date"
					name="publish_time">
			</div>
			<div class="st1">

				<label for="account1" class="t1">使用者編號:</label> <input type="text"
					id="account1" autocomplete="off" name="user_id">
			</div>

			<div class="st1">
				<label for="pwd1" class="t1">作者:</label><input type="text" id="pwd1"
					name="author">
			</div>

			<div class="st1">
				<label for="" class="t1">權限:</label> <select type="text" name="role">
					<option value="管理者">管理者
					<option>
				</select>

			</div>
			<div width="50px"; height="50px"; class="st1">
				<label class="t1">內容:</label>
				<textarea cols="5" rows="5"  type="text" name="contents">
			</textarea>
			</div>
		</fieldset>
		<center>
			
				<input type="submit"  value="送出"> 
				</form>
				
			<a href="QueryAll">  <button   type="submit" name="backToQuery" value="返回">返回</button></a>

		</center>
<!-- 		</div> -->



</body>
</html>