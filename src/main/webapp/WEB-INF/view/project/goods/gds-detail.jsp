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
		$("#quantity").val(1);
		
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
					dataType : "text",
					contentType: "application/json",
					url : "order",
					data: JSON.stringify(pro),
					success : function(result){
						alert(result);
					},
					error : function(result){
						alert(result);
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
					<td class="del-td"></td>
					
				</tr>
				<c:forEach var="reviews" items="${reviews }">
					<tr>
						<td>${reviews.id }</td>
						<td>${reviews.content }</td>
						<td>${reviews.writer_id }</td>
						<td>${reviews.regdate }</td>
						<c:if test="${reviews.writer_id eq sessionScope.id }">
							<td> <button id=${reviews.id }>x</button> </td>
						
						</c:if>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="review-btn-div">
			<button id="review-btn" type="button">리뷰 작성 열기</button>
		</div>
		<div id="reviewRegister-div" style="display: none;">
	        <form action="reviewwrite" method="post">
	        	<input type="hidden" name="gds_id" value="${param.id}">
	        	<input type="text" name="content">
	        	<input type="hidden" name="writer_id" value="${sessionScope.id}">
	        	<input type="submit" value="리뷰 작성">
	        </form>
        </div>
	</div>

	<footer>
	</footer>
</body>
<script src="https://kit.fontawesome.com/505ea0ee8f.js" crossorigin="anonymous"></script>
<script src="/project/js/goods/gds-detail.js"></script>
<script src="/project/js/cart/order.js"></script>
</html>