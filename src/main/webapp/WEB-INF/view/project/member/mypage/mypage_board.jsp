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
                <li><a href="board">게시글 </a></li>
                <li><a href="reply">댓글</a></li>
                <li><a href="product">상품</a></li>
            </ul>
        </nav>

       <section>
            <header class="section-title">
                <p>게시판</p>
            </header>

            <table style="table-layout: fixed">
				<input type="hidden" class="current_page" value="${param.page }"/>
                <tr>
                    <td>
                        번호
                    </td>
                    <td>
                        내용
                    </td>
                    <td>
                        조회 수
                    </td>
                    <td>
                        작성일
                    </td>
                    <td>
                        삭제
                    </td>
                </tr>
				
				<c:forEach var="board" items="${boards }">
					<tr>
	                    <td>
	                        ${board.id }
	                    </td>
	                    <td>
	                     	<a href="/football/board/detail?id=${board.id }">
		                        ${board.content }
	                     	</a>
	                    </td>
	                    <td>
	                        ${board.hit }
	                    </td>
	                    <td>
	                        ${board.regdate }
	                    </td>
	                    <td>
	                        <button id="${board.id }" class="delBtn" type="button">삭제</button>
	                    </td>
	                </tr>
				</c:forEach>
            </table>
			
            <div class="page-div">
            	<!-- 이전페이지 버튼 -->
            	<c:if test="${PageMaker.prev }">
            		<c:if test="${PageMaker.first_page == 1 }">
		            	<a href="board?page=${ PageMaker.first_page-PageMaker.group <0 ? 1: PageMaker.first_page-PageMaker.group }">◀</a>
            		</c:if>
            		<c:if test="${PageMaker.first_page != 1 }">
		            	<a href="board?page=${ PageMaker.first_page-1 }">◀</a>
            		</c:if>
            	</c:if>
            	<c:if test="${!PageMaker.prev }">
            		<a style="cursor: pointer;" onclick="alert('더 이상 페이지가 존재하지 않습니다.')">◀</a>
            	</c:if>
				
				<!-- 페이지 번호 -->
				<c:forEach var="num" begin="${PageMaker.first_page }" end="${PageMaker.last_page  }">
	                <a href="board?page=${num }">${num }</a>
				</c:forEach>
				
				
				<!-- 다음페이지 버튼 -->
				<c:if test="${PageMaker.next }">
	                <a href="board?page=${PageMaker.last_page+1 }">▶</a>
				</c:if>
                <c:if test="${!PageMaker.next}">
                	<c:if test="${param.page == PageMaker.last_page }">
	    	       		<a style="cursor: pointer;" onclick="alert('더 이상 페이지가 존재하지 않습니다.')">▶</a>
                	</c:if>
                	<c:if test="${param.page != PageMaker.last_page }">
		                <a href="board?page=${PageMaker.last_page}">▶</a>
                	</c:if>
				</c:if>
            </div>
        </section>
    </div>
    <footer style="clear:both;width: 100%; height: 100px; background-color: brown;">
           
    </footer>
</body>
<script src="/project/js/member/mypage/mypage_main.js"></script>
<script src="/project/js/member/mypage/mypage_board.js"></script>
<script src="/project/js/member/mypage/changeNamePwd.js"></script>
</html>