<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="fourth.dao.CourseDao"%>
<%@ page import="java.util.List"%>
<%@ page import="fourth.bean.CourseBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", -1); // Prevents caching at the proxy server
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="backend/img/smalllogo.png" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"><!-- Vendor styles -->
    <link rel="stylesheet" href="backend/vendors/material-design-iconic-font/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="backend/vendors/animate.css/animate.min.css">
    <link rel="stylesheet" href="backend/vendors/jquery-scrollbar/jquery.scrollbar.css">
    <link rel="stylesheet" href="backend/vendors/fullcalendar/fullcalendar.min.css"><!-- App styles -->
    <link rel="stylesheet" href="backend/css/app.min.css">
<!--     原 -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,300i,400,400i,700,700i&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/font-awesome.min.css">
    <link rel="stylesheet" href="./css/owl.carousel.min.css">
    <link rel="stylesheet" href="./css/animate.min.css">
    <link rel="stylesheet" href="./css/jquery-ui.css">
    <link rel="stylesheet" href="./css/slick.css">
    <link rel="stylesheet" href="./css/chosen.min.css">
    <link rel="stylesheet" href="./css/pe-icon-7-stroke.css">
    <link rel="stylesheet" href="./css/magnific-popup.min.css">
    <link rel="stylesheet" href="./css/lightbox.min.css">
    <link rel="stylesheet" href="./js/fancybox/source/jquery.fancybox.css">
    <link rel="stylesheet" href="./css/jquery.scrollbar.min.css">
    <link rel="stylesheet" href="./css/mobile-menu.css">
    <link rel="stylesheet" href="./fonts/flaticon/flaticon.css">
    <link rel="stylesheet" href="./css/style.css">
<title>課程詳情</title>
</head>

<%
CourseBean courseBean = (CourseBean) request.getAttribute("cbean");
%>

	
<body class="details-page" data-ma-theme="green">
<main class="main">
        <div class="page-loader">
            <div class="page-loader__spinner"><svg viewBox="25 25 50 50">
                    <circle cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" />
                </svg></div>
        </div>
        <header class="header">
            <div class="navigation-trigger hidden-xl-up" data-ma-action="aside-open" data-ma-target=".sidebar">
                <div class="navigation-trigger__inner"><i class="navigation-trigger__line"></i><i
                        class="navigation-trigger__line"></i><i class="navigation-trigger__line"></i></div>
            </div>
            <div class="header__logo hidden-sm-down">
                <h1><a href="BackendIndex.jsp"><img src="backend/img/logo.png" width="125px"></a></h1>
            </div>
<!--             <form class="search"> -->
<!--                 <div class="search__inner"><input type="text" class="search__text" placeholder="搜尋..." size="30px"><i -->
<!--                         class="zmdi zmdi-search search__helper" data-ma-action="search-close"></i></div> -->
<!--             </form> -->
            <ul class="top-nav">
                <li class="hidden-xl-up"><a href="" data-ma-action="search-open"><i class="zmdi zmdi-search"></i></a>
                </li>

                <li class="dropdown top-nav__notifications"><a href="" data-toggle="dropdown" class="top-nav__notify"><i
                            class="zmdi zmdi-notifications"></i></a>
                    <div class="dropdown-menu dropdown-menu-right dropdown-menu--block">
                        <div class="listview listview--hover">
                            <div class="listview__header">通知<div class="actions"><a href=""
                                        class="actions__item zmdi zmdi-check-all"
                                        data-ma-action="notifications-clear"></a></div>
                            </div>
                            <div class="listview__scroll scrollbar-inner"><a href="" class="listview__item"><img
                                        src="demo/img/profile-pics/1.jpg" class="listview__img" alt="">
                                    <div class="listview__content">
                                        <div class="listview__heading">David Belle</div>
                                        <p>Cum sociis natoque penatibus et magnis dis parturient montes</p>
                                    </div>
                                </a></div>
                            <div class="p-1"></div>
                        </div>
                    </div>
                </li>

                <li>


                    <div class="user__info" data-toggle="dropdown"><img class="user__img"
                            src="backend/demo/img/profile-pics/8.jpg" alt="">

                    </div>
                    <div class="dropdown-menu"><a class="dropdown-item" href="">xxxxx</a><a class="dropdown-item"
                            href="">查看個人檔案</a><a class="dropdown-item" href="">登出</a></div>

                </li>
            </ul>
        </header>
        <a href="CourseServlet"><input type="submit" name="return" value="回上頁"></a>
	<div class="main-content main-content-details single no-sidebar">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="breadcrumb-trail breadcrumbs">
						<ul class="trail-items breadcrumb">
							<li class="trail-item trail-begin"><a href="BackendIndex.jsp">首頁</a></li>
							<li class="trail-item"><a href="courseList">課程列表</a></li>
							<li class="trail-item trail-end active">課程詳情</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="row">
				<div
					class="content-area content-details full-width col-lg-9 col-md-8 col-sm-12 col-xs-12">
					<div class="site-main">
						<div class="details-product">
							<div class="details-thumd">
								<div
									class="image-preview-container image-thick-box image_preview_container">
									<img id="img_zoom"
										data-zoom-image="<%=courseBean.getCourse_picture()%>"
										src="<%=courseBean.getCourse_picture()%>" alt="img"><a
										href="#" class="btn-zoom open_qv"><i class="fa fa-search"
										aria-hidden="true"></i></a>
								</div>

							</div>
							<div class="details-infor">
								<h1><%=courseBean.getCourse_name()%></h1>
								<div class="stars-rating">
									<div class="star-rating">
										<span class="star-5"></span>
									</div>
									<div class="count-star">(7)</div>
								</div>

								<div class="product-details-description">
									<ul>
										<li>課程時長:<%=courseBean.getCourse_duration()%></li>
										<li>已購買人數:<%=courseBean.getEnrollment()%></li>
										<li>講師姓名:<%=courseBean.getLecturer_name()%></li>
										<li>講師信箱:<%=courseBean.getLecturer_email()%></li>
										<li>上架日期:<%=courseBean.getCourse_date()%></li>
									</ul>
								</div>

								<div class="group-button">
									<div class="yith-wcwl-add-to-wishlist">
										<div class="yith-wcwl-add-button">
											<a href="#">加入最愛</a>
										</div>
									</div>
									<div class="availability">課程價格:</div>
									<div class="price">
										<span>$ <%=courseBean.getCourse_price()%></span>
									</div>

									<div class="quantity-add-to-cart">
										<div class="quantity"></div>
										<button class="single_add_to_cart_button button">加入購物車</button>
									</div>
								</div>
							</div>
						</div>
						<div class="tab-details-product">
							<ul class="tab-link">
								<li class="active"><a data-toggle="tab"
									aria-expanded="true"><h3>課程簡介</h3></a></li>
							</ul>
							<div class="tab-container">
								<div id="product-descriptions" class="tab-panel active">
									<p>
									<h5>
										<center>
											★
											<%=courseBean.getCourse_introduction()%></center>
									</h5>
									</p>

								</div>



							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
    <script src="backend/vendors/jquery/jquery.min.js"></script>
    <script src="backend/vendors/popper.js/popper.min.js"></script>
    <script src="backend/vendors/bootstrap/js/bootstrap.min.js"></script>
    <script src="backend/vendors/jquery-scrollbar/jquery.scrollbar.min.js"></script>
    <script src="backend/vendors/jquery-scrollLock/jquery-scrollLock.min.js"></script>
    <script src="backend/vendors/flot/jquery.flot.js"></script>
    <script src="backend/vendors/flot/jquery.flot.resize.js"></script>
    <script src="backend/vendors/flot.curvedlines/curvedLines.js"></script>
    <script src="backend/vendors/jqvmap/jquery.vmap.min.js"></script>
    <script src="backend/vendors/jqvmap/maps/jquery.vmap.world.js"></script>
    <script src="backend/vendors/easy-pie-chart/jquery.easypiechart.min.js"></script>
    <script src="backend/vendors/salvattore/salvattore.min.js"></script>
    <script src="backend/vendors/sparkline/jquery.sparkline.min.js"></script>
    <script src="backend/vendors/moment/moment.min.js"></script>
    <script src="backend/vendors/fullcalendar/fullcalendar.min.js"></script><!-- Charts and maps-->
    <script src="backend/demo/js/flot-charts/curved-line.js"></script>
    <script src="backend/demo/js/flot-charts/dynamic.js"></script>
    <script src="backend/demo/js/flot-charts/line.js"></script>
    <script src="backend/demo/js/flot-charts/chart-tooltips.js"></script>
    <script src="backend/demo/js/other-charts.js"></script>
    <script src="backend/demo/js/jqvmap.js"></script><!-- App functions and actions -->
    <script src="backend/js/app.min.js"></script>
    
<!--     原 -->
<script src="./js/jquery-1.12.4.min.js"></script>
    <script src="./js/jquery.plugin-countdown.min.js"></script>
    <script src="./js/jquery-countdown.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/owl.carousel.min.js"></script>
    <script src="./js/magnific-popup.min.js"></script>
    <script src="./js/isotope.min.js"></script>
    <script src="./js/jquery.scrollbar.min.js"></script>
    <script src="./js/jquery-ui.min.js"></script>
    <script src="./js/mobile-menu.js"></script>
    <script src="./js/chosen.min.js"></script>
    <script src="./js/slick.js"></script>
    <script src="./js/jquery.elevateZoom.min.js"></script>
    <script src="./js/jquery.actual.min.js"></script>
    <script src="./js/fancybox/source/jquery.fancybox.js"></script>
    <script src="./js/lightbox.min.js"></script>
    <script src="./js/owl.thumbs.min.js"></script>
    <script src="./js/jquery.scrollbar.min.js"></script>
    <script src='http://www.google.cn/maps/api/js?key=AIzaSyC3nDHy1dARR-Pa_2jjPCjvsOR4bcILYsM'></script>
    <script src="./js/frontend-plugin.js"></script>
	

</body>
</html>