<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,fourth.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.tb {
	border-collapse: collapse;
	width: 700px;
	/*自動斷行*/
/* 	word-wrap: break-word; */
	table-layout: fixed;
	margin-left: 20px
}
</style>
</head>
<body>
<br><br><br><br>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-8">
				<c:set value="${order}" var="order" />
				<input type="hidden" name="orderID" value="${order.order_id}">
				<table class="table table-striped tb">
					<tr>
						<td colspan="8">
							<table class="table mb-0" >

								<th>訂單編號</th>
								<th>訂單生成日期</th>
								<th>訂單狀態</th>
								<c:url var="de" value="OrderServlet">
									<c:param name="command" value="DELETE" />
									<c:param name="cartID" value="${order.order_id}" />
								</c:url>

								<tr>
									<td>${order.order_id }</td>
									<td>${order.date }</td>

									<c:choose>
										<c:when test="${order.status.id == 4}">
											<td>${order.status.status}</td>
										</c:when>
										<c:otherwise>
											<td><select name="updateStatus">
													<option>${order.status.status}</option>
													<option value="1">未付款</option>
													<option value="2">已付款</option>
													<option value="4">完成訂單</option>
											</select></td>

										</c:otherwise>
									</c:choose>

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
				<table class="table tb" >
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
				<div style="margin: auto; width: 88px;">



					<c:choose>
						<c:when
							test="${order.status.id == 1 && order.memberBean.status == 3}">
							<div style="margin: auto; width: 88px;">
								<form action="goEcpay" method="post">
									<input type="hidden" name="orderID" value="${order.order_id}" />
									<button onclick="if( !(confirm('確認付款?') ) ) return false ; ">確認付款</button>
								</form>
							</div>
						</c:when>
						<c:otherwise>
							<form action="updateOrder/${4}/${order.order_id}" method="get">
								<button
									onclick="if( !(confirm('確認修改?') ) ) return false ; alert('修改成功!!!');">
									<center>確認修改</center>
								</button>
							</form>
						</c:otherwise>
					</c:choose>

				</div>

			</div>
		</div>
	</div>
</body>
</html>