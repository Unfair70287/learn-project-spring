<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,fourth.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/x-icon"
	href="assets/images/smalllogo.png" />
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,300i,400,400i,700,700i&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="assets/css/animate.min.css">
<link rel="stylesheet" href="assets/css/jquery-ui.css">
<link rel="stylesheet" href="assets/css/slick.css">
<link rel="stylesheet" href="assets/css/chosen.min.css">
<link rel="stylesheet" href="assets/css/pe-icon-7-stroke.css">
<link rel="stylesheet" href="assets/css/magnific-popup.min.css">
<link rel="stylesheet" href="assets/css/lightbox.min.css">
<link rel="stylesheet"
	href="assets/js/fancybox/source/jquery.fancybox.css">
<link rel="stylesheet" href="assets/css/jquery.scrollbar.min.css">
<link rel="stylesheet" href="assets/css/mobile-menu.css">
<link rel="stylesheet" href="assets/fonts/flaticon/flaticon.css">
<link rel="stylesheet" href="assets/css/style.css">
<style>
.main-header1 {
	height: 50px;
	padding: 50px 0
}
</style>
<script type="text/javascript" src="jquery-3.6.0.js"></script>
<script>
	function myFunction() {
		$.getJSON("cartCount", function(data) {
			$("#msg").html(data);
		});
	}
</script>
<title>Header</title>
</head>
<link rel="shortcut icon" type="image/x-icon"
	href="assets/images/smalllogo.png" />
<body onload="myFunction()" class="home">

	<header class="header style7">
		<div class="top-bar">
			<div class="container">
				<div class="top-bar-left">
					<div class="header-message">Welcome!歡迎來到好學生學習平台</div>
				</div>
				<div class="top-bar-right">
					<div class="header-language"></div>

					<ul class="header-user-links">
						<li><a href=""><b>${sessionScope.user.name}</b></a> | <a
							href="logout">登出</a></li>
						<li></li>
					</ul>

				</div>
			</div>
		</div>

			<div class="container">
				<div class="main-header1">
					<div class="row" style="display: block;">
						<div
							class="col-lg-3 col-sm-4 col-md-3 col-xs-7 col-ts-12 header-element">
							<div class="logo">
								<a href="Index"><img src="assets/images/log.png"
									alt="img" width="175px" height="150px"></a>
							</div>
						</div>
						<div class="col-lg-7 col-sm-8 col-md-6 col-xs-5 col-ts-12">
							<div class="block-search-block"></div>
						</div>
						<div class="col-lg-2 col-sm-12 col-md-3 col-xs-12 col-ts-12">
							<div class="header-control">
								<div class="block-minicart teamo-mini-cart block-header ">

									<a href="cartList" class="shopcart-icon"
										data-teamo="teamo-dropdown">Cart <span class="count"
										id="msg"></span></a>

									<div class="shopcart-description teamo-submenu">
										<div class="content-wrap"></div>
									</div>
								</div>

								<div class="block-account block-header ">
									<a href="AdminServlet?action=list" data-teamo="teamo-dropdown"><span
										class="flaticon-user"></span></a>
									<div class="header-account teamo-submenu">
										<div class="header-user-form-tabs"></div>
									</div>
								</div>
							</div>
							<a class="menu-bar mobile-navigation menu-toggle" href="#"><span></span><span></span><span></span></a>
						</div>
					</div>
				</div>
			</div>

			<div class="header-nav-container rows-space-20">
				<div class="container">
					<div class="header-nav-wapper main-menu-wapper">
						<div class="vertical-wapper block-nav-categori">
							<div class="block-title">
								<span class="icon-bar"><span></span><span></span><span></span></span><span
									class="text">全部分類</span>
							</div>
						
									<div class="block-content verticalmenu-content">
										<ul
											class="teamo-nav-vertical vertical-menu teamo-clone-mobile-menu">
											<li class="menu-item"><a
												href="searchLearn"
												class="teamo-menu-item-title" title="New Arrivals">我的學習</a></li>
											<li class="menu-item"><a title="Hot Sale" href="#"
												class="teamo-menu-item-title">我的試卷</a></li>
											<li class="menu-item "><a title="Accessories"
												href="Activity" class="teamo-menu-item-title">我的活動</a><span
												class="toggle-submenu"></span></li>
											<li class="menu-item"><a title="Variegated"
												href="cartList" class="teamo-menu-item-title">我的購物車</a></li>
											<li class="menu-item"><a title="Variegated"
												href="orderList" class="teamo-menu-item-title">我的訂單</a></li>
										</ul>

									</div>

						</div>
						<div class="header-nav">
							<div class="container-wapper">
								<ul class="teamo-clone-mobile-menu teamo-nav main-menu "
									id="menu-main-menu">
									<li><a href="courseList" class="teamo-menu-item-title"
										title="Home">課程</a><span class="toggle-submenu"></span>
									<li class="menu-item "><a href="Exam.jsp"
										class="teamo-menu-item-title" title="Shop">試卷</a><span
										class="toggle-submenu"></span>
									<li><a href="Activity" class="teamo-menu-item-title"
										title="Pages">活動</a><span class="toggle-submenu"></span></li>
									<li><a href="ColumnQueryAll.jsp"
										class="teamo-menu-item-title" title="Blogs">專欄</a><span
										class="toggle-submenu"></span>
										<ul class="submenu">

										</ul></li>

									<li class="menu-item"><a href="cartList"
										class="teamo-menu-item-title" title="About">購物車</a></li>

								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>

	</header>
	<script src="assets/js/jquery-1.12.4.min.js"></script>
	<script src="assets/js/jquery.plugin-countdown.min.js"></script>
	<script src="assets/js/jquery-countdown.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/owl.carousel.min.js"></script>
	<script src="assets/js/magnific-popup.min.js"></script>
	<script src="assets/js/isotope.min.js"></script>
	<script src="assets/js/jquery.scrollbar.min.js"></script>
	<script src="assets/js/jquery-ui.min.js"></script>
	<script src="assets/js/mobile-menu.js"></script>
	<script src="assets/js/chosen.min.js"></script>
	<script src="assets/js/slick.js"></script>
	<script src="assets/js/jquery.elevateZoom.min.js"></script>
	<script src="assets/js/jquery.actual.min.js"></script>
	<script src="assets/js/fancybox/source/jquery.fancybox.js"></script>
	<script src="assets/js/lightbox.min.js"></script>
	<script src="assets/js/owl.thumbs.min.js"></script>
	<script src="assets/js/jquery.scrollbar.min.js"></script>
	<script
		src='http://www.google.cn/maps/api/js?key=AIzaSyC3nDHy1dARR-Pa_2jjPCjvsOR4bcILYsM'></script>
	<script src="assets/js/frontend-plugin.js"></script>

</body>
</html>