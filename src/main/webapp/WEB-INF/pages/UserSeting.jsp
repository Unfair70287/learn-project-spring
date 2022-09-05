<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="java.util.List"%>
<%@ page import="fourth.bean.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>會員資料</title>
</head>

<%
MemberBean memberBean = (MemberBean) request.getAttribute("user");
%>

<body class="details-page">
	<jsp:include page="Header.jsp" />
	<div class="main-content main-content-details single no-sidebar">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="breadcrumb-trail breadcrumbs">
						<ul class="trail-items breadcrumb">
							<li class="trail-item trail-begin"><a href="Index.jsp">首頁</a></li>
							<li class="trail-item trail-end active">會員資料</li>
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
								<!-- 								<div -->
								<!-- 									class="image-preview-container image-thick-box image_preview_container"> -->
								<%-- 									<img id="img_zoom" data-zoom-image="<%=memberBean.getImg()%>" --%>
								<%-- 										src="<%=memberBean.getImg()%>" alt="img"><a href="#" --%>
								<!-- 										class="btn-zoom open_qv"><i class="fa fa-search" -->
								<!-- 										aria-hidden="true"></i></a> -->
								<!-- 								</div> -->

							</div>
							<div class="details-infor">
								<h1><%=memberBean.getNick()%></h1>

								<div class="product-details-description">
									<ul>
										<li>帳號:<%=memberBean.getAccount()%></li>
										<li>密碼:<%=memberBean.getPassword()%></li>
										<li>身分:<c:choose>
												<c:when test="<%=memberBean.getStatus() == 1%>">
             		 						學生
       							</c:when>
												<c:when test="<%=memberBean.getStatus() == 2%>">
              								老師
       							</c:when>
												<c:otherwise>
              						管理員
       							</c:otherwise>
											</c:choose></li>
										<li>姓名:<%=memberBean.getName()%></li>
										<li>生日:<%=memberBean.getBirthday()%></li>
										<li>手機號碼:<%=memberBean.getCellphone()%></li>
										<li>信箱:<%=memberBean.getEmail()%></li>
										<li>註冊日期:<%=memberBean.getJoinDate()%></li>
									</ul>
								</div>
							</div>
						</div>

					</div>
				</div>

			</div>
		</div>
	</div>

</body>
</html>