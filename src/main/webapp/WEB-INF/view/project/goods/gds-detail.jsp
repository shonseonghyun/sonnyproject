<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품</title>
<link rel="stylesheet" href="/project/css/goods/gds-detail.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Gaegu&display=swap" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".add-btn").on("click",function(){
			if(${empty sessionScope.id}){
				alert("로그인이 필요합니다");
			}else{
				var pro={
					id :  $(".id").val(),
					gds_id : $(".gds_id").val(),
					amount : $("#quantity").val()
				}
				$.ajax({
					type:"post",
					contentType: "application/json",
					url : "order",
					data: JSON.stringify(pro),
					error : function(){
						alert("상품 담기 완료");
					}
				})
			}
		})
	})
</script>
</head>
<body>
	<%@ include file="../include/header.jsp" %>

	<div class="content-div">
		<div class="img-div">
			<img src="/project/images/${item.picture_url }" alt=""></div>
		<div class="gds-div">
			<input class="gds_id" type="hidden" value="${param.id }">
			<input class="id" type="hidden" value="${sessionScope.id}">
			<h2>${item.gds_name }</h2>
			<span>
				<fmt:formatNumber value="${item.gds_price }" pattern="₩###,###,###"/>
			</span>
			<div class="descr-div">
				${item.gds_descr }
			</div>
			<div class="quantity-div">
				<label for="quantity">수량</label>
				<input type="number"  id="quantity">
				<button type="button" class="plus-btn">+</button>
				<button type="button" class="minus-btn" >-</button>
			</div>
			<div class="btn-div">
				<button class="add-btn" type="button">담기</button>
				<br/>
				<button class="gds_list-btn" type="button">상품 목록</button>
			</div>
		</div>
	</div>
	
	<div class="review-div">
		<h2>REVIEW</h2>
		<div>
			<table>
				<tr>
					<td>No</td>
					<td class="sub-td">subject</td>
					<td class="writer-td">Writer</td>
					<td class="date-td">Date</td>
				</tr>
				<tr>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
				</tr>
			</table>
		</div>
		<div class="review-btn-div">
			<button type="button">작성</button>
		</div>
	</div>

	<footer>
	</footer>
</body>
<script src="https://kit.fontawesome.com/505ea0ee8f.js" crossorigin="anonymous"></script>
<script src="/project/js/goods/gds-detail.js"></script>
<script src="/project/js/cart/order.js"></script>
</html>