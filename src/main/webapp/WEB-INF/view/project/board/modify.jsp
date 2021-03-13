<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="preconnect" href="https://fonts.gstatic.com">    
 <link href="https://fonts.googleapis.com/css2?family=Gaegu&display=swap" rel="stylesheet">
 <link rel="stylesheet" href="/project/css/board-write.css">
<title>게시판 작성</title>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(document).on('click','.listbtn',function(e){
		e.preventDefault();
		location.href="/football/board";
		})
		
	/
	$(function(){
		$(".modifybtn").click(function(){
			board = {
				id : $(".id").val(),
				title : $(".title-write").val(),
				content : $(".content").val()
				}
			console.log(board);
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "modify",
				data : JSON.stringify(board),
				success : function(data){
					console.log(data);
					
					if(data=="t"){
						alert('새 글 작성이 완료되었습니다');
						location.href="/football/board";
					}else{
						alert("글을 다시 작성해 주세요");
						location.reload(); //브라우저 새로고침
					}
				}
				
			})
		})
	})
</script>
</head>
<body>
	<!--  header -->
	<header>
		<%@ include file="../header.jsp" %>
    </header>
    <!--  header -->

    <form id="frm" enctype="multipart/form-data">
    	<input type="hidden" class="id" name="id" value="${detail.id}">
        <table border="1"> 
            <tr>
                <td class="title-td">제목</td>
                <td><input class="title-write" type="text" name="title" value=${detail.title } ></td>
            </tr>
            <tr> 
                <td colspan="2">
                    <textarea class="content" name="content" cols="30" rows="10">${detail.content }</textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="file" name="file">
                </td>
            </tr>

            <tr>
                <td><button type="button" class="listbtn">목록</button></td>
                <td>
                	<input  type="button" class="modifybtn" value="수정">
                </td>
            </tr>
        </table>
    </form>
	

</body>
<script src="https://kit.fontawesome.com/505ea0ee8f.js" crossorigin="anonymous"></script>
<script src="/project/js/logout.js" ></script>
</html>