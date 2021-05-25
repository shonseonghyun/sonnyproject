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

		$("#LoginBtn").click(function(){
			location.href="/football/login";
		})
	})
</script>
</head>
<body>
	<header class="header-area">
    	<a href="/football/main"><h1>LOGO DESIGN</h1></a>
        <c:if test="${sessionScope.id != null }">
	        <div class="main-div">
	            <div class="logout-div">
	                <span>
	                	<strong>${sessionScope.name } </strong>님
	                </span>
	                <button id="LogoutBtn" type="button">로그아웃</button>
	            </div>
	            <div class="my-div">
	                <a href="/football/mypage">내 정보</a>
	                <a href="/football/cart">장바구니</a>
	            </div>
	        </div>
		</c:if>
		<c:if test="${sessionScope.id == null }">
			<div class="main-div">
            	<div class="login-div">
                	<button id="LoginBtn" type="button">로그인</button>
            	</div>
        </div>
		</c:if>
    </header>
</body>
</html>