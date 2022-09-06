<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,fourth.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="width: 1500px;" class="container">
		<div class="row justify-content-center">
			<div class="col-auto">

				<table class="table table-striped table-hover">

					<th>訂單編號</th>
					<th>訂單生成日期</th>
					<th>購買數量</th>
					<th>訂單狀態</th>
					<th>折扣</th>
					<th>總價</th>
					<th>詳細</th>
					<th>刪除</th>
					<c:forEach items="${order}" var="order">
						<c:url var="up" value="OrderServlet">
							<c:param name="command" value="ITEMLIST" />
							<c:param name="cartID" value="${order.order_id}" />
						</c:url>
						<c:url var="upStatus" value="OrderServlet">
							<c:param name="command" value="ITEMLIST" />
							<c:param name="orderID" value="${order.order_id}" />
							<c:param name="cartID" value="${order.order_id}" />
							<c:param name="userID" value="${order.memberBean.user_id}" />
						</c:url>
						<c:url var="de" value="OrderServlet">
							<c:param name="command" value="DELETE" />
							<c:param name="cartID" value="${order.order_id}" />
						</c:url>
						<tr>

							<td>${order.order_id }</td>
							<td>${order.date }</td>
							<td>${order.totoalcount }</td>
							<td>${order.status.status }</td>
							<td>${order.discount }</td>
							<td>$${order.totoalprice }</td>

							<c:if test="${order.status.id == 1}">
								<td>
									<form action="orderDetail" method="post">
										<input type="hidden" name="cartID" value="${order.order_id}" />
										<button>結帳</button>
									</form>
								</td>
							</c:if>
							<c:if test="${order.status.id == 2}">
								<td><a href="${upStatus}"><button id="btn" disabled>已付款</button></a></td>
							</c:if>
							<c:if test="${order.status.id == 4}">
								<td>
									<form action="orderDetail" method="post">
										<input type="hidden" name="cartID" value="${order.order_id}" />
										<button style="background-color: blue;">詳細</button>
									</form>
								</td>
							</c:if>

							<td>
								<c:if test="${order.status.id == 1}">
									<form action="deleteOrder" method="post"
										onclick="if( !(confirm('確認刪除?') ) ) return false">
										<input type="hidden" name="cartID" value="${order.order_id}" />
										<button>刪除</button>
									</form>

								</c:if>
							</td>

						</tr>
					</c:forEach>

				</table>
				<c:if test="${order.size() == 0 }">
					<div style="border: 1px solid #ddd">
						<div style="width: 100px; margin: auto;">尚無訂單!!!</div>
					</div>

				</c:if>
			</div>
		</div>
	</div>
</body>
</html>