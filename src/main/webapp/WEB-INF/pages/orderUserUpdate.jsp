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
	<div class="container">
				<div class="row justify-content-center">
					<div class="col-8">

						<c:set value="${order}" var="order" />

						<table class="table table-striped">
							<tr>
								<td colspan="8">
									<table class="table mb-0">

										<th>訂單編號</th>
										<th>訂單生成日期</th>
										<th>訂單狀態</th>

										<tr>
											<td>${order.order_id }</td>
											<td>${order.date }</td>
											<td>${order.status.status }</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td colspan="8">
									<table class="table mb-0">

										<th>會員帳號</th>
										<th>會員姓名</th>
										<th>會員信箱</th>
										<th>會員手機</th>
										<tr>
											<td>${order.memberBean.account}</td>
											<td>${order.memberBean.name}</td>
											<td>${order.memberBean.email}</td>
											<td>${order.memberBean.cellphone}</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td colspan="8">
									<table class="table mb-0">

										<th>商品編號</th>
										<th>商品名稱</th>
										<th>商品數量</th>
										<th>商品價錢</th>

										<tr>
											<c:forEach items="${itemList}" var="item">
												<tr>
													<td>${item.item_id}</td>
													<td>${item.name}</td>
													<td>${item.count}</td>
													<td>$${item.price}</td>
												</tr>
											</c:forEach>
										</tr>
									</table>
								</td>
							</tr>
						</table>

						<table class="shop_table">
							<tr>
								<td class="actions"><c:if test="${order.status.id != 4 }">
										<form action="shoppingcart.html" class="cart-form"
											style="width: 59%;" method="post">
											<div class="coupon">
												<label class="coupon_code">優惠碼:</label> <input type="text"
													class="input-text" placeholder="輸入優惠碼"
													style="border: 1px solid green;"><a href="#"
													class="button"></a>
											</div>
										</form>
									</c:if></td>
							</tr>
							<tr>
								<td colspan="7"></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td colspan="7"></td>
								<td></td>
								<td></td>
								<th>總價</th>
								<td>$${order.totoalprice }</td>
							</tr>
							<tr>
								<td colspan="7"></td>
								<td></td>
								<td></td>
								<th>折扣</th>
								<td>${order.discount }</td>
							</tr>
							<tr>
								<td colspan="7"></td>
								<td></td>
								<td></td>
								<th>合計</th>
								<td>$${order.totoalprice }</td>
							</tr>
						</table>
						<c:if test="${order.status.id != 4}">

							<div style="margin: auto; width: 88px;">
								<form action="goEcpay" method="post">
									<input type="hidden" name="orderID" value="${order.order_id}" />
									<button onclick="if( !(confirm('確認付款?') ) ) return false ; ">確認付款</button>
								</form>
							</div>

						</c:if>

					</div>
				</div>
			</div>
</body>
</html>