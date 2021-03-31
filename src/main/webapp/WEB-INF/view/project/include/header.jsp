<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<link rel="stylesheet" href="/project/css/include/header.css">
</head>
<body>
<div class="header-div">
		<ul>
			<c:if test="${sessionScope.id != null }">
				<li><a href="/football/main">main</a></li>
				<li><a href="">mypage</a></li>
				<li><a href="/football/cart">cart</a></li>
				<li><span id="LogoutBtn">logout</span></li>
			</c:if>
			<c:if test="${sessionScope.id == null }">
				<li><a href="/football/login" >login</a></li>
			</c:if>
		</ul>
	</div>
</body>
 <script src="/project/js/include/logout.js"></script>
</html>