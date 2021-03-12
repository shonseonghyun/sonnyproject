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
		
	$(document).on('click','.writebtn',function(e){
		e.preventDefault();
		$("#frm").submit();
		})
</script>
</head>
<body>
	<!--  header -->
	<header>
		<div class="header-div">
			<c:if test="${sessionScope.name==null}">
				<a class="no-decoration" href="/football/login">로그인</a>
			</c:if>	
			<c:if test="${sessionScope.name!=null}">
				${sessionScope.name}님
				<a id="LogoutBtn" class="no-decoration">로그아웃</a>	
			</c:if>
			
		 </div>
    </header>
    <!--  header -->

    <form id="frm" method="post" action="write">
        <table border="1"> 
            <tr>
                <td class="title-td">제목</td>
                <td><input class="title-write" type="text" name="title" ></td>
            </tr>
            <tr> 
                <td colspan="2">
                    <textarea name="content"  cols="30" rows="10"></textarea>
                </td>
            </tr>
            <tr>
                <td><button type="button" class="listbtn">목록</button></td>
                <td>
                	<input  type="button" class="writebtn" value="작성">
                </td>
            </tr>
        </table>
    </form>
	

</body>
<script src="https://kit.fontawesome.com/505ea0ee8f.js" crossorigin="anonymous"></script>
<script src="/project/js/logout.js" ></script>
</html>