<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/project/css/member/find_id_result.css">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		//취소버튼
		$(".login-btn").click(function(){
			location.href= "login";
		})
	})
</script>
<title>임시 비밀번호 전송</title>
</head>
	<body>
    <section class="login-section">
            <h1>FIND PASSWORD</h1>
            <div class="main-div">
				<h3>비밀번호가 고객님 메일로 발송되었습니다.</h3>
            </div>
            <div class="find-div">
				<p style="font-size: 12px">
					${param.id }회원님의 패스워드를
					<br>
					${param.email }으로 보내드렸습니다.
				</p>
            </div>
            <div class="btn-div">
            	<button class="login-btn" type="button">로그인</button>
            </div>
    </section>
 </body>
</html>