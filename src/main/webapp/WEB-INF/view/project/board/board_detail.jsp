<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
<link rel="stylesheet" href="/project/css/board/board-detail.css">
<link rel="preconnect" href="https://fonts.gstatic.com">    
<link href="https://fonts.googleapis.com/css2?family=Gaegu&display=swap" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(document).on('click','#delBtn',function(e){
		if(confirm("삭제하시겠습니까?")){
			location.href="/football/board/delete?id=${detail.id}";
		}
		})
	$(document).on('click','#modiftBtn',function(e){
		if(confirm("수정하시겠습니까?")){
			location.href="/football/board/modify?id=${detail.id}";
		}
		})
</script>
</head>
<body>
<%-- <img width="100" height="100" alt="" src="/images/project/${detail.files }">
 --%>
	 <header>
		<%@ include file="../include/header.jsp" %>
    </header>
 
 	 <div class= "detail-container">
        <table>
          <tbody>
            <tr>
              <td class="color-area">제목</td>
              <td class="color-blue" colspan="3"><strong>${detail.title }</strong></td>
            </tr>
            <tr>
              <td class="color-area">작성일</td>
              <td colspan="3">${detail.regdate }</td>
            </tr>
            <tr>
              <td class="color-area">작성자</td>
              <td>${detail.writer_id }</td>
              <td class="color-area">조회수</td>
              <td>${detail.hit }</td>
            </tr>
         
            <tr>
              <td height=200 class="not-align" colspan="4">
              	${detail.content }
              </td>
              
            </tr>
            <tr>
              <td colspan="4">
              	<button type="button" class="btn"><a href="/football/board">목록</a></button>
              	 <c:if test="${(sessionScope.id ==  detail.writer_id) || (sessionScope.id =='admin') }">
	              	<button class="btn" id="modiftBtn" type="button">수정</button>
	              	<button class="btn" id="delBtn" type="button">삭제</button>
    			 </c:if>
              	</td>
            </tr>
            
            <tr>
              <td class="color-area">이전글</td>
              <td colspan="3">
              	<span class="prev" id="${detail.prev}">
              		<c:if test="${prev_title ==null }">
              			더 이상 이전 글이 존재하지 않습니다.
              		</c:if>
              		<c:if test="${prev_title !=null }">
              			${ prev_title}
              		</c:if>
              	</span>
              	<%-- <a href="detail?id=${detail.prev}">이전 글</a> --%>
              </td>
            </tr>

            <tr>
              <td class="color-area">다음글</td>
              <td colspan="3">
              	<span class="next" id="${detail.next}">
					<c:if test="${next_title ==null }">
              			더 이상 다음 글이 존재하지 않습니다.
              		</c:if>
              		<c:if test="${next_title !=null }">
              			${ next_title}
              		</c:if>
				</span>
			<%-- <a href="detail?id=${detail.prev} ">다음 글</a>--%>
			  </td>
            </tr>

          </tbody>
        </table>
        
        <div class="reply-div">
		<h2>Reply</h2>
		<div>
			<table>
				<tr>
					<td class="sub-td">subject</td>
					<td class="writer-td">Writer</td>
					<td class="date-td">Date</td>
					<td></td>
				</tr>
				<c:forEach items="${reply}" var="reply">
					<tr>
						<td>${reply.content}</td>
						<td>${reply.writer_id}</td>
						<td>${reply.regdate}</td>
						<td>
							<button class="delReplyBtn" data-id=${detail.id } data-no="${reply.no}">X</button>
						</td>
					</tr>
		        </c:forEach>
			</table>
		</div>
		
		<div class="reply-btn-div">
			<button id="replyBtn" type="button">작성</button>
		</div>
		<div id="replyRegister-div" style="display: none;">
	        <form action="replywrite" method="post">
	        	<input type="hidden" name="id" value="${detail.id}">
	        	<input type="text" name="content">
	        	<input type="hidden" name="writer_id" value="${sessionScope.id}">
	        	<input type="submit" value="댓글 작성">
	        </form>
        </div>
		
	</div>
        
    </div>
 </body>
<script src="https://kit.fontawesome.com/505ea0ee8f.js" crossorigin="anonymous"></script>
<script src="/project/js/board/reply.js" ></script>
<script src="/project/js/board/replyDelBtn.js" ></script>
<script src="/project/js/board/board-detail.js" ></script>
</html>