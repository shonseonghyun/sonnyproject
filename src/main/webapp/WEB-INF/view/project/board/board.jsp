<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/project/css/board/board.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Gaegu&display=swap" rel="stylesheet">
<title>게시판</title>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".icon").on("click",function(){
			if(${empty sessionScope.id}){
				alert("로그인이 필요합니다");
			}
			else{
				
			}	
		})
	})
</script>

</head>
<body>
	<!--  header -->
	<header>
		<%@ include file="../include/header.jsp" %>
	</header>
	<!--  header -->
	<section>
	
		<div class="search-div">
			<form>
				<select name="f">
					<option value="title" ${param.f == "title"?"selected":""}>제목</option>
					<option value="writer_id"  ${param.f == "writer_id"?"selected":""}>작성자</option>
				</select>
				<input name="q" type="text" value="${param.q }">
				<input type="submit" value="검색">
			</form>
		</div>
		
		<table class="notice-table" >
			<tr class="table-head">
				<td class="table-id">id</td>
				<td class="table-title">제목</td>
				
				<td class="table-writer">작성자</td>
				<td class="table-date">날짜</td>
				<td class="table-hit">조회수</td>
			</tr>
			<c:forEach var="b" items="${list}">
			
			<tr>
				<td>${b.id}</td>
				<td class="title">
					<a  href="/football/board/detail?id=${b.id}">${b.title }</a>
				</td>
				<td>${b.writer_id }</td>
				<td>${b.regdate }</td>
				<td>${b.hit }</td>
			</tr>
			</c:forEach>
		</table>
	
		<%-- <div class="top3-div">
			<ol>
				<c:forEach var="top3" items="${top3 }">
				<li> 
					<a href="board/detail?id=${top3.id}">${top3.title }</a>
				</li>
				</c:forEach>
			</ol>
		</div> --%>
		<div class="page-div">
			<c:if test="${p.page == p.start}"> 
					<a style="cursor: pointer;" onclick="alert('첫페이지입니다')">◀</a>
			</c:if>
			<c:if test="${p.start == 1 and p.prev < 0 and p.page != p.start}"> 
					<a style="cursor: pointer;" href="board?f=${param.f}&q=${param.q}&page=${p.start}">◀</a>
			</c:if>
			<c:if test="${p.prev >= 0 }">
				<a href="board?f=${param.f}&q=${param.q}&page=${p.prev}">◀</a>
			</c:if>
			
			<c:forEach  var="page" begin="${5*p.start-4}" end="${5*p.start }">
				<c:if test="${page < p.	end or page == p.end }">
						<a href="board?f=${param.f}&q=${param.q}&page=${page }">${page}</a>
				</c:if>
			</c:forEach>
			
			<c:if test="${p.page != p.end and p.end > p.next}"> 
				<a href="board?f=${param.f }&q=${param.q }&page=${p.next}">▶</a>
			</c:if>
			<c:if test="${p.page != p.end and p.end < p.next}"> 
				<a href="board?f=${param.f }&q=${param.q }&page=${p.end}">▶</a>
			</c:if>
			<c:if test="${p.page == p.end}"> 
				<a style="cursor: pointer;" onclick="alert('마지막 페이지입니다')">▶</a>
			</c:if>
			
		</div>
		<a style="cursor: pointer;" href="board/write" class="icon" >
			<i id="write-icon" class="fas fa-edit"></i>
		</a>
	</section>
	
	
	
	
</body>
<script src="https://kit.fontawesome.com/505ea0ee8f.js" crossorigin="anonymous"></script>
</html>