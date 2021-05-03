<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/project/css/member/find_id.css">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		if(${check}){
			alert("이름 또는 이메일을 확인해 주세요");
		}
	})
</script>
<title>아이디 찾기</title>
</head>
	<body>
	
    <section class="login-section">
            <h1>FIND ID</h1>
            <form name="login-form" action="find_id" method="post">
	            <div class="login-area">
	                <input type="text" name="name" id="name" autocomplete="off" required>
	                <label for="name">이름</label>
	            </div>
	            <div class="login-area">
	                <input type="text" name="email" id="email" autocomplete="off" required> 
	                <label for="email">이메일</label>
	            </div>
	            <div class="bt-area">
	                <input type="submit" value="찾기">
	            </div>
        </form>
    </section>
 </body>
</html>