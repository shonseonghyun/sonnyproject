<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<link rel="stylesheet" href="/project/css/include/header.css">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		//session에 key값으로 id가 들어가 있을 경우
		if(${not empty sessionScope.id}){
			$("#LogoutBtn").click(function(){
				if(confirm("로그아웃하시겠습니까?")==true){
					location.href="/football/logout";
				}
				else
					return;
			})
		}
	})
</script>
</head>
<body>
<div class="header-div">
		<c:if test="${sessionScope.id != null }">
			${sessionScope.name }님
		</c:if>
		<ul>
			<c:if test="${sessionScope.id != null }">
				<li><a href="/football/main">main</a></li>
				<li><a href="">mypage</a></li>
				<li><a href="/football/cart">cart</a></li>
				<li><span id="LogoutBtn">logout</span></li>
			</c:if>
			<c:if test="${sessionScope.id == null }">
				<li><a href="/football/main">main</a></li>
				<li><a href="/football/login" >login</a></li>
			</c:if>
		</ul>
	</div>
</body>
</html>