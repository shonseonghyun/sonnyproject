<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
<link rel="stylesheet" href="/project/css/member/mypage/mypage_board.css">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	 <header>
		<%@ include file="../../include/header.jsp" %>
    </header> 
    <div class="mypage-div">
        <nav class="mypage-nav">
            <ul>
                <li><a href="/football/mypage">회원정보</a></li>
                <li><a href="mypage/board">게시글 </a></li>
                <li><a href="mypage/reply">댓글</a></li>
                <li><a href="mypage/goods">상품</a></li>
            </ul>
        </nav>

       <section>
            <header class="section-title">
                <p>상품</p>
            </header>

            <table style="table-layout: fixed">
				<input type="hidden" class="current_page" value="${param.page }"/>
                <tr>
                    <td colspan="2" style="text-align: center;">
                        상품정보
                    </td>
                    <td>
                        가격
                    </td>
                    <td>
                        담긴 수
                    </td>
                    
                    <td>
                        등록일
                    </td>
                    
                    <td>
                        삭제
                    </td>
                </tr>
				<c:forEach items="${goodsList }" var="list">
					<tr>
						<td colspan="2">
							<a href="/football/goods/detail?id=${list.gds_id }">
								<img style="width: 50px;height: 50px" src="/project/images/${list.picture_url }" alt="">
							</a>
							<span>${list.gds_name }</span>
						</td>
						 <td>
	                    	${list.gds_price}
	                    </td>
	                    <td>
                        	${list.quantity }
                   		</td>
	                    <td style="padding:0;">
	                    	${list.regDate}
	                    </td>
	                    <td>
	                        <button id="${list.gds_id }" class="delBtn" type="button">삭제</button>
	                    </td>
					</tr>
				</c:forEach>
            </table>
			
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
        </section>
    </div>
    <!-- <footer style="clear:both;width: 100%; height: 100px; background-color: brown;">
           
    </footer> -->
    <%@ include file="../../include/footer.jsp" %>
</body>
<script src="/project/js/member/mypage/mypage_goods.js"></script>
</html>