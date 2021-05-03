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
		$(".login-btn").on("click",function(){
			location.href = "login";
		})
		
		$(".find_pw-btn").on("click",function(){
			location.href = "find_pw";
		})
		
	})
</script>
<title>아이디 찾기</title>
</head>
	<body>
    <section class="login-section">
            <h1>FIND ID</h1>
            <div class="main-div">
            	<p>고객님 아이디 찾기가 완료되었습니다.</p>
            </div>
            <div class="find-div">
				<p>
					이름: <strong>${member.name}</strong>  
					이메일: ${member.email }</p>
				<p style="margin-left: 50px;">
					<strong> ${member.id }</strong> ( ${member.regdate } 가입 )
				</p>
            </div>
            <div class="btn-div">
            	<button class="login-btn" type="button">로그인</button>
            	<button class="find_pw-btn" type="button">비밀번호 찾기</button>
            </div>
    </section>
 </body>
</html>