<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>order</title>
<link rel="stylesheet" href="/project/css/goods/cart.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Gaegu&display=swap" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<%@ include file="../header.jsp" %>
	<div class="order-div">
		<h1>Order</h1>
		<div>
			<form action="www" method="get">
				<table>
					<tr>
						<td><input id="allChecked" type="checkbox"></td>
						<td>Product</td>
						<td class="name-td">Name</td>
						<td class="price-td">Price</td>
						<td class="qty-td">Qty</td>
						<td class="total-td">total</td>
					</tr>
					
					<c:forEach var="ol" items="${OrderList}">
						<tr>
							<td>
								<input class="item" name="cart_id" type="checkbox" value="${ol.cart_id }">
							</td>
							<td><img src="/project/images/${ol.picture_url }" alt=""></td>
							<td>${ol.gds_name }</td>
							<td>${ol.gds_price }</td>
							<td>
								<input type="number" id="qty" value="${ol.amount }">
							</td>
							<td>${ol.money }</td>
						</tr>
					</c:forEach>
					
					<tr>
						<td colspan="6">
							선택 상품 <button type="button" class="delete Btn">삭제</button>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<span style="display: block; margin-bottom: 20px;">
								총 상품 금액
							</span>
							<span>
								100
							</span>
						</td>
						<td colspan="2">
							<span style="display: block; margin-bottom: 20px;">
								총 배송비
							</span>
							<span>
								100
							</span>
						</td>
						<td colspan="2">
							<span style="display: block; margin-bottom: 20px;">
								결제예정금액
							</span>
							<span>
								100
							</span>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	
	<div class="btn-div">
		<div>
			<button type="button" class="allOrder Btn">전체상품주문</button>
			<button type="button" class="selectedOrder Btn">선택상품주문</button>
		</div>		
		<button type="button" class="goods Btn">쇼핑계속하기</button>
	</div>

	<footer>
	</footer>
</body>
<script src="https://kit.fontawesome.com/505ea0ee8f.js" crossorigin="anonymous"></script>
<script src="/project/js/cart/cart.js"></script>
</html>