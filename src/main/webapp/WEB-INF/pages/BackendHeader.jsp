<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/x-icon"
	href="backend/img/smalllogo.png" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Vendor styles -->
<link rel="stylesheet"
	href="backend/vendors/material-design-iconic-font/css/material-design-iconic-font.min.css">
<link rel="stylesheet"
	href="backend/vendors/animate.css/animate.min.css">
<link rel="stylesheet"
	href="backend/vendors/jquery-scrollbar/jquery.scrollbar.css">
<link rel="stylesheet"
	href="backend/vendors/fullcalendar/fullcalendar.min.css">
<!-- App styles -->
<link rel="stylesheet" href="backend/css/app.min.css">
<title>好學生後台管理首頁</title>
</head>
<body data-ma-theme="green">
	<main class="main">
		<div class="page-loader">

			<div class="page-loader__spinner">
				<svg viewBox="25 25 50 50">
                    <circle cx="50" cy="50" r="20" fill="none"
						stroke-width="2" stroke-miterlimit="10" />
                </svg>
			</div>
		</div>
		<header class="header">
			<div class="navigation-trigger hidden-xl-up"
				data-ma-action="aside-open" data-ma-target=".sidebar">
				<div class="navigation-trigger__inner">
					<i class="navigation-trigger__line"></i><i
						class="navigation-trigger__line"></i><i
						class="navigation-trigger__line"></i>
				</div>
			</div>
			<div class="header__logo hidden-sm-down">
				<h1>
					<a href="backendIndex"><img src="backend/img/logo.png"
						width="125px"></a>
				</h1>
			</div>
			<!--             <form class="search"> -->
			<!--                 <div class="search__inner"><input type="text" class="search__text" placeholder="搜尋..." size="30px"><i -->
			<!--                         class="zmdi zmdi-search search__helper" data-ma-action="search-close"></i></div> -->
			<!--             </form> -->
			<ul class="top-nav">
				<li class="hidden-xl-up"><a href=""
					data-ma-action="search-open"><i class="zmdi zmdi-search"></i></a></li>

				<li class="dropdown top-nav__notifications"><a href=""
					data-toggle="dropdown" class="top-nav__notify"><i
						class="zmdi zmdi-notifications"></i></a>
					<div class="dropdown-menu dropdown-menu-right dropdown-menu--block">
						<div class="listview listview--hover">
							<div class="listview__header">
								通知
								<div class="actions">
									<a href="" class="actions__item zmdi zmdi-check-all"
										data-ma-action="notifications-clear"></a>
								</div>
							</div>
							<div class="listview__scroll scrollbar-inner">
								<a href="" class="listview__item"><img
									src="demo/img/profile-pics/1.jpg" class="listview__img" alt="">
									<div class="listview__content">
										<div class="listview__heading">David Belle</div>
										<p>Cum sociis natoque penatibus et magnis dis parturient
											montes</p>
									</div> </a>
							</div>
							<div class="p-1"></div>
						</div>
					</div></li>
				<!-- <div class="col-lg-2 col-sm-12 col-md-3 col-xs-12 col-ts-12"> -->
				<!--                         <div class="header-control"> -->
				<!--                             <div class="block-minicart teamo-mini-cart block-header teamo-dropdown"><a -->
				<!--                                     href="javascript:void(0);" class="shopcart-icon" data-teamo="teamo-dropdown">Cart -->
				<!--                                     <span class="count">0 </span></a> -->
				<!--                                 <div class="shopcart-description teamo-submenu"> -->
				<!--                                     <div class="content-wrap"> -->


				<!--                                     </div> -->
				<!--                                 </div> -->
				<!--                             </div> -->

				<!--                                     </div> -->
				<!--                                 </div> -->
				<!--                             </div> -->
				<!--                 <li class="dropdown hidden-xs-down"><a href="" data-toggle="dropdown"><i -->
				<!--                             class="zmdi zmdi-more-vert"></i></a> -->
				<!--                     <div class="dropdown-menu dropdown-menu-right"> -->
				<!--                         <div class="dropdown-item theme-switch"> 頁面色彩選擇<div -->
				<!--                                 class="btn-group btn-group-toggle btn-group--colors" data-toggle="buttons"><label -->
				<!--                                     class="btn bg-green active"><input type="radio" value="green" autocomplete="off" -->
				<!--                                         checked></label><label class="btn bg-blue"><input type="radio" value="blue" -->
				<!--                                         autocomplete="off"></label><label class="btn bg-red"><input type="radio" -->
				<!--                                         value="red" autocomplete="off"></label><label class="btn bg-orange"><input -->
				<!--                                         type="radio" value="orange" autocomplete="off"></label><label -->
				<!--                                     class="btn bg-teal"><input type="radio" value="teal" autocomplete="off"></label> -->
				<!--                                 <div class="clearfix mt-2"></div><label class="btn bg-cyan"><input type="radio" -->
				<!--                                         value="cyan" autocomplete="off"></label><label class="btn bg-blue-grey"><input -->
				<!--                                         type="radio" value="blue-grey" autocomplete="off"></label><label -->
				<!--                                     class="btn bg-purple"><input type="radio" value="purple" -->
				<!--                                         autocomplete="off"></label><label class="btn bg-indigo"><input type="radio" -->
				<!--                                         value="indigo" autocomplete="off"></label><label class="btn bg-brown"><input -->
				<!--                                         type="radio" value="brown" autocomplete="off"></label> -->
				<!--                             </div> -->
				<!--                         </div> -->
				<!--                     </div> -->
				<!--                 </li> -->
				<li>


					<div class="user__info" data-toggle="dropdown">
						<img class="user__img" src="backend/demo/img/profile-pics/8.jpg"
							alt="">

					</div>

					<div class="dropdown-menu">
						<a class="dropdown-item" href="">${sessionScope.user.name }</a><a class="dropdown-item"
							href="">查看個人檔案</a><a class="dropdown-item"
							href="login.controller">登出</a>
					</div>


               </li>
			</ul>
		</header>
		<aside class="sidebar">
			<div class="scrollbar-inner">


				<ul class="navigation">

					<li class="navigation__active"><a href="Index"><i
							class="zmdi zmdi-home"></i>前台首頁</a></li>
					<li><a href="memberList"><i
							class="zmdi zmdi-format-underlined"></i>會員管理</a></li>

					<li class="navigation__sub"><a href=""><i
							class="zmdi zmdi-view-week"></i>試卷管理</a>
						<ul>
							<li><a href="firstExamController">全部試卷</a></li>
							<li><a href="firstExamController">國中</a></li>
							<li><a href="firstExamController">高中</a></li>
							<li><a href="firstExamController">成人</a></li>
						</ul></li>
					<li class="navigation__sub"><a href=""><i
							class="zmdi zmdi-view-list"></i>課程管理</a>
						<ul>
							<li><a href="course.list">全部課程</a></li>
							<li><a href="hidden-sidebar.html">國中</a></li>
							<li><a href="boxed-layout.html">高中</a></li>
							<li><a href="hidden-sidebar-boxed-layout.html">成人</a></li>
						</ul></li>

					
					<li><a href="QueryAll"><i class="zmdi zmdi-collection-text"></i>專欄管理</a></li>
					<li><a href="Activity_OP"><i class="zmdi zmdi-calendar"></i>活動管理</a></li>

					<li><a href="orderList"><i class="zmdi zmdi-widgets"></i>訂單管理</a></li>

					<li><a href="cartList"><i class="zmdi zmdi-widgets"></i>購物車</a></li>
				</ul>
			</div>

		</aside>


	</main>
	<!-- Older IE warning message -->
	<!--[if IE]><div class="ie-warning"><h1>Warning!!</h1><p>You are using an outdated version of Internet Explorer, please upgrade to any of the following web browsers to access this website.</p><div class="ie-warning__downloads"><a href="http://www.google.com/chrome"><img src="img/browsers/chrome.png" alt=""></a><a href="https://www.mozilla.org/en-US/firefox/new"><img src="img/browsers/firefox.png" alt=""></a><a href="http://www.opera.com"><img src="img/browsers/opera.png" alt=""></a><a href="https://support.apple.com/downloads/safari"><img src="img/browsers/safari.png" alt=""></a><a href="https://www.microsoft.com/en-us/windows/microsoft-edge"><img src="img/browsers/edge.png" alt=""></a><a href="http://windows.microsoft.com/en-us/internet-explorer/download-ie"><img src="img/browsers/ie.png" alt=""></a></div><p>Sorry for the inconvenience!</p></div><![endif]-->
	<!-- Javascript -->
	<!-- Vendors -->
	<script src="backend/vendors/jquery/jquery.min.js"></script>
	<script src="backend/vendors/popper.js/popper.min.js"></script>
	<script src="backend/vendors/bootstrap/js/bootstrap.min.js"></script>
	<script src="backend/vendors/jquery-scrollbar/jquery.scrollbar.min.js"></script>
	<script
		src="backend/vendors/jquery-scrollLock/jquery-scrollLock.min.js"></script>
	<script src="backend/vendors/flot/jquery.flot.js"></script>
	<script src="backend/vendors/flot/jquery.flot.resize.js"></script>
	<script src="backend/vendors/flot.curvedlines/curvedLines.js"></script>
	<script src="backend/vendors/jqvmap/jquery.vmap.min.js"></script>
	<script src="backend/vendors/jqvmap/maps/jquery.vmap.world.js"></script>
	<script src="backend/vendors/easy-pie-chart/jquery.easypiechart.min.js"></script>
	<script src="backend/vendors/salvattore/salvattore.min.js"></script>
	<script src="backend/vendors/sparkline/jquery.sparkline.min.js"></script>
	<script src="backend/vendors/moment/moment.min.js"></script>
	<script src="backend/vendors/fullcalendar/fullcalendar.min.js"></script>
	<!-- Charts and maps-->
	<script src="backend/demo/js/flot-charts/curved-line.js"></script>
	<script src="backend/demo/js/flot-charts/dynamic.js"></script>
	<script src="backend/demo/js/flot-charts/line.js"></script>
	<script src="backend/demo/js/flot-charts/chart-tooltips.js"></script>
	<script src="backend/demo/js/other-charts.js"></script>
	<script src="backend/demo/js/jqvmap.js"></script>
	<!-- App functions and actions -->
	<script src="backend/js/app.min.js"></script>
</body>
</html>