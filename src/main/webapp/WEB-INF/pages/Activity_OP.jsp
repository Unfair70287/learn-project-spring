<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="fourth.bean.ActivityBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>活動(管理員)</title>
<!--css導入-->
<link rel="stylesheet" href="css/activityCSS.css">

<Style>
#box {
	position: relative;
	width: 1170px;
	margin: auto;
	min-height: 1280px;
	padding: 19px;
	background: #f3f3f3;

}

.data {
	display: none
}
.select{	
	float: right;
	display: flex;
}

.selectInput{
	font-size: xx-large;
}
#uploadPhotos{
display: none
}
.uploadImgButton{
	background-color rgb(101, 161, 90);
}
label{
    background-color: #65a15a;
	display: inline-block;
    padding: 9px 20px;
    color: #fff;
    border: 0;
    text-align: center;
    font-size: 12px;
    font-weight: 700;
    -webkit-transition: all .4s ease 0s;
    -moz-transition: all .4s ease 0s;
    -o-transition: all .4s ease 0s;
    transition: all .4s ease 0s;
    border-radius: 0;
    text-transform: uppercase;
    font-family: 'Montserrat', sans-serif
}

	


</Style>
</head>
<body>
<!-- 
<jsp:include page="header.jsp"/>
 -->

	<div id="box">
     	<h2>活動編輯</h2>
     	<div >
     	<form class="select" action="Activity_OP" >
            <input class="selectInput" type="month" name="select" />
            <button type="submit" name="request" value="查詢">查詢</button>
     	</form>
     	<form  action="Activity_OP" >
     	<button  name="request" value="新增">新增活動</button>
     	</form>
		
        
     	</div>
     	
		<hr>
		<div id="hrml_content">
		<%
						List<ActivityBean> activities = null;
		//強制轉型					r
								HttpSession s =request.getSession();
								activities = (List<ActivityBean>) s.getAttribute("selectAllActivity");
								if (activities != null) {
							for (ActivityBean activity : activities) {
						%>
		<form class="activity_form" name="activity_form" action="Activity_OP"method="post">
			<div class="preview">
				<div class="img_parent">
					<input class="data" name="activity_imgPath" type="text" value="<%=activity.getImgPath()%>" />
					<input class="data" name="activity_id" type="text" value="<%=activity.getId()%>" />
					<img class="activity_img" id="activity_img"  src="<%=activity.getImgPath()%>" alt="">
				</div>
				<div class="activity_text">
					<input class="title" name="activity_title" type="text" value="<%=activity.getTitle()%>" readonly>
					<textarea class="introduction" name="activity_content" cols="30" required><%=activity.getContent()%></textarea>
					
				</div>
				<input class="activity_button" type="submit" name="request" value="修改" /> 
				<input class="activity_button" type="submit"name="request" onclick="if( !(confirm('確認刪除?') ) ) return false" value="刪除" />
			</div>
			<br>
			<input class="activity_start_time" name="activity_start_time" type="datetime-local" value="<%=activity.getStart_time()%>" readonly/>~
			<input class="activity_end_time" name="activity_end_time" type="datetime-local" value="<%=activity.getEnd_time()%>"  readonly/>
		</form>
		<%
		}
		}
		%>
		
		</div>
		
		
	
		
	</div>
	
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<Script>
	</Script>
</body>
</html>