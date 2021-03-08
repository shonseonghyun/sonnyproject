<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/project/css/main.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Gaegu&display=swap" rel="stylesheet">
<title>메인 페이지</title>
</head>
<body>			
				<!-- header 시작 -->
	<header>
		<div class="header-div">
			<c:if test="${sessionScope.name==null}">
				<a class="no-decoration" href="login">로그인</a>
			</c:if>	
			<c:if test="${sessionScope.name!=null}">
				${sessionScope.name}님
				<a class="no-decoration" href= "logout">로그아웃</a>	
			</c:if>
			
		 </div>
	</header>
					<!-- header 끝 -->
   <div class="item-wrapper">
        <figure>
        	<a href="board">
	            <img id="img" src="/project/images/1.jpg" alt="없다">
	            <figcaption>
	                <h2>Board</h2>	
	            </figcaption>
        	</a>
        </figure>
        <figure>
            <a href="shop/list">
	            <img src="/project/images/2.jpg" alt="없다">
	            <figcaption>
	                <h2>Product</h2>
	            </figcaption>
            </a>
        </figure>
        <figure>
      	  <a href="cart/list">
            <img src="/project/images/3.jpg" alt="없다">
            <figcaption>
                <h2>Cart</h2>
            </figcaption>
           </a>
        </figure>
        <figure>
            <img src="/project/images/4.jpg" alt="없다">
            <figcaption>
                <h2>ProjectTitle</h2>
            </figcaption>
        </figure>
    </div>
</body>
</html>