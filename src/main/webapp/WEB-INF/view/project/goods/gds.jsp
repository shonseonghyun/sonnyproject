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
					</li>
				</c:forEach>
			
			</ul>
			<div class="btn-div">
				<button onclick="location.href='goods/register'" class="reg-btn">상품 등록</button>
			</div>	
			
			<div class="page-div">
				<!-- 이전페이지 버튼 -->
            	<c:if test="${PageMaker.prev }">
            		<c:if test="${PageMaker.first_page == 1 }">
		            	<a href="goods?page=${ PageMaker.first_page-PageMaker.group <0 ? 1: PageMaker.first_page-PageMaker.group }">◀</a>
            		</c:if>
            		<c:if test="${PageMaker.first_page != 1 }">
		            	<a href="goods?page=${ PageMaker.first_page-1 }">◀</a>
            		</c:if>
            	</c:if>
            	<c:if test="${!PageMaker.prev }">
            		<a style="cursor: pointer;" onclick="alert('더 이상 페이지가 존재하지 않습니다.')">◀</a>
            	</c:if>
				
				<!-- 페이지 번호 -->
				<c:forEach var="num" begin="${PageMaker.first_page }" end="${PageMaker.last_page  }">
	                <a href="goods?page=${num }">${num }</a>
				</c:forEach>
				
				
				<!-- 다음페이지 버튼 -->
				<c:if test="${PageMaker.next }">
	                <a href="goods?page=${PageMaker.last_page+1 }">▶</a>
				</c:if>
                <c:if test="${!PageMaker.next}">
                	<c:if test="${param.page == PageMaker.last_page }">
	    	       		<a style="cursor: pointer;" onclick="alert('더 이상 페이지가 존재하지 않습니다.')">▶</a>
                	</c:if>
                	<c:if test="${param.page != PageMaker.last_page }">
		                <a href="goods?page=${PageMaker.last_page}">▶</a>
                	</c:if>
				</c:if>
			</div>
		</div>
	</div>

	<footer style="clear:both;width: 100%; height: 100px; background-color: brown;">
            
        </footer>
	
</body>
<script src="https://kit.fontawesome.com/505ea0ee8f.js" crossorigin="anonymous"></script>
<script src="/project/js/goods/gds.js"></script>

</html>