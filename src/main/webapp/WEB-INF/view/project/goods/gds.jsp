<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<link rel="stylesheet" href="/project/css/goods/gds.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Gaegu&display=swap" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<%@ include file="../include/header.jsp" %>

	<div class="header"><h1>Goods</h1></div>
	<div class="content">
		<div class="classic-div">
			<ul class="item">
				<c:forEach var="l" items="${list }">
					<li price="${l.gds_price }">
					<a href="goods/detail?id=${l.gds_id }"><img src="/project/images/${l.picture_url }" alt=""></a>
					<p></p>
				</c:forEach>
			
			</ul>
			<div class="btn-div">
				<button onclick="location.href='goods/register'" class="reg-btn">상품 등록</button>
			</div>	
			
			<div class="page-div">
				1 2 3 4 5
			</div>
		</div>
	</div>

	<footer>
	</footer>
	
</body>
<script src="https://kit.fontawesome.com/505ea0ee8f.js" crossorigin="anonymous"></script>
<script src="/project/js/goods/gds.js"></script>

</html>