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

</script>
<title>비밀번호 찾기</title>
</head>
	<body>
	
    <section class="login-section">
            <h1>FIND PASSWORD</h1>
            <form name="login-form" action="find_pw" method="post">
	            <div class="login-area">
	                <input type="text" name="id" id="id" autocomplete="off" required>
	                <label for="name">아이디</label>
	            </div>
	            <div class="login-area">
	                <input type="text" name="name" id="name" autocomplete="off" required> 
	                <label for="email">이름</label>
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