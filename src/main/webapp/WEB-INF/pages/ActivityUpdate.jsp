<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fourth.bean.ActivityBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>更新活動</title>
<link rel="shortcut icon" type="image/x-icon" href="assets/images/smalllogo.png" />
	<link rel="stylesheet" href="css/activityCSS.css">

<Style>
#box {
	position: relative;
	z-index: 2;
	width: 1170px;
	margin: auto;
	min-height: 1280px;
	padding: 19px;
	background: #f3f3f3;
}

.data {
	display: none
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
.content {
    width: 1125px;
    padding:50px;
    border-radius: 10px;
    background-color: white;
    display: flex;
    margin:auto;
}
#editTitle{
	border: 1px solid black;
	width:1025px;
	font-size: 32px;
}
#introduction{
	border: 1px solid black;
	width:1025px;
	
	 height: 240px;
	 padding: 5px;
    font-size: 18px;
    resize: none;
}
.centerDiv{
width: 200px;
margin:0px auto;
}


</Style>
</head>
<body>
<jsp:include page="Header.jsp"/>


	<div id="box">
     	<h2>活動編輯</h2>
		<div id="hrml_content">
		<div class="content">
			<form action="Activity_OP" method="post">
			
					<h2>標題:</h2>
					<input id="editTitle"	 name="title" type="text" value="${activityBean.title} " required>
					<p>
					<h3>內文:</h3>
					<textarea id="introduction" name="content" oninput="auto_grow(this)" cols="30" required>${activityBean.content}</textarea>
			<p>
				<div >
					<h3>圖片:</h3>
					<input class="data" name="imgPath" type="text" value="${activityBean.imgPath}" />
					<input class="data" name="id" type="text" value="${activityBean.id}" />
					<img class="activity_img" id="activity_img"  src="${activityBean.imgPath}" alt="">
					<br>
					<label class="uploadImgButton" for="uploadPhotos">上傳照片</label>
					<input id="uploadPhotos" class="data" type="file" onchange="previewImg(this)" accept="image/gif, image/jpeg, image/png">
				</div>
			<br>
			<div>
			<h3>時間:</h3>
			<p>
			活動開始時間:<input class="activity_start_time" name="start_time" type="datetime-local" value="${activityBean.start_time}" required/>
			<p>
			活動結束時間:<input class="activity_end_time" name="end_time" type="datetime-local" value="${activityBean.end_time}"  required/>
			<p>
			</div>
			<hr>
			<div class="centerDiv">
			
			
			<button name="request" value="${activityBean.id!=null?'Update':'Insert'}">確認</button>
			<a id="back" href ="Activity_OP" ><label for="back" style="cursor: pointer;">取消</label></a>
			
			</div>
				
		</form>
		
		
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script >
	
	function auto_grow(element) {
		element.style.height = "240px";
        element.style.height = (element.scrollHeight) + "px";
    }
	function previewImg(element) {
		
		
		let img = element.parentElement.querySelector("img");
		if (element.files[0]) {
			img.src = URL.createObjectURL(element.files[0]);
		}
		//=================test============================
		let formData = new FormData;
		formData.append('image', element.files[0]);
        
        $.ajax({
            url: 'ActivityAddImg',//接受請求的Servlet地址
            type: 'POST',
            data: formData,
            async: false,//同步請求
            cache: false,//不快取頁面
            contentType: false,//當form以multipart/form-data方式上傳檔案時，需要設定為false
            processData: false,//如果要傳送Dom樹資訊或其他不需要轉換的資訊，請設定為false
			success: function (response) {
				let	imgPath = element.parentElement.querySelector("input");
				imgPath.setAttribute('value',response);
				console.log(imgPath)
            },
            error: function (e) {
                alert(e);
            }

        });
	}
	</script>
	
</body>
</html>