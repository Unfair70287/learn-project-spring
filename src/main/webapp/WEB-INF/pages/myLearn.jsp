<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,fourth.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
</style>
<script type="text/javascript" src="jquery-3.6.0.js"></script>
<script>
	$(function() {
		$("#in").mouseover(function() {
			$(this).css('background-color', 'red')
		}).mouseout(function() {
			$(this).css("background-color", oldColor);
		});
	})
</script>
<link rel="shortcut icon" type="image/x-icon"
	href="assets/images/smalllogo.png" />
</head>
<body>
	<jsp:include page="Header.jsp" />
	<c:if test="${sessionScope.user == null}">
		<%
		request.getRequestDispatcher("/Login.jsp").forward(request, response);
		%>
	</c:if>
	<div class="container">
		<div class="row">
			<div
				class="content-area shop-grid-content full-width col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="site-main">
					<ul
						class="row list-products auto-clear equal-container product-grid">
						<c:forEach var="course" items="${myItem }">
							<c:if test="${course != null }">
								<li
									class="product-item product-type-variable col-lg-3 col-md-4 col-sm-6 col-xs-6 col-ts-12 style-1">
									<div class="product-inner equal-element">
										<div class="product-top"></div>
										<div class="product-thumb">
											<div class="thumb-inner">
												<a href="#"><img src="${course.course_picture }"
													alt="img"></a>

											</div>
										</div>
										<div class="product-info">
											<label> <a href="#">${course.course_name}</a>
											</label><br>

											<p style="margin-bottom: 0px;">課程時長:${course.course_duration}</p>
											<p style="margin-bottom: 0px;">購買人數:${course.enrollment}</p>
											<p style="margin-bottom: 0px;">講師姓名:${course.lecturer_name}</p>
											<div class="group-info">
												<div class="stars-rating">
													<div class="star-rating">
														<span class="star-${ran }" id="star"></span>
													</div>
													<div class="count-star" id="count">${ran }</div>
												</div>

											</div>
										</div>
									</div>
								</li>
							</c:if>
						</c:forEach>

					</ul>
					<!-- 	<div class="pagination clearfix style2">
						<div class="nav-link">
							<a href="#" class="page-numbers"><i
								class="icon fa fa-angle-left" aria-hidden="true"></i></a><a href="#"
								class="page-numbers">1</a><a href="#" class="page-numbers">2</a><a
								href="#" class="page-numbers current">3</a><a href="#"
								class="page-numbers"><i class="icon fa fa-angle-right"
								aria-hidden="true"></i></a>  -->
				</div>
			</div>
		</div>
	</div>

	</div>
	</div>

</body>
</html>