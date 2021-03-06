<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="/project/css/signup.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Gaegu&display=swap" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
    <section class="login-section">
        <h1>LOGO DESIGN</h1>
        <form method="post" action="signup" name="loginform" class="login-form" autocomplete="off">
       		<div class="name-div">
                <label for="name">이름</label>
                <input type="text" name="name" id="name"  value="${param.name }">
                <div>
                	<p id="namecheck"> 
		                <spring:hasBindErrors name="memberDTO">
							<c:if test="${errors.hasFieldErrors('name') }">
								<spring:message code="${errors.getFieldError('name').codes[0] }"
									text="${errors.getFieldError('name').defaultMessage }"></spring:message>
							</c:if>
						</spring:hasBindErrors>
	                </p>
                </div>
                
            </div>
            <div class="id-div">
                <label for="id">아이디</label>
                <input type="text" name="id" id="id" value="${param.id }" >
                <input type="button" id="checkidbtn" value="중복확인">
                  <div>
                	<p id="idcheck"> 
		                <spring:hasBindErrors name="memberDTO">
							<c:if test="${errors.hasFieldErrors('id') }">
								<spring:message code="${errors.getFieldError('id').codes[0] }"
									text="${errors.getFieldError('id').defaultMessage }"></spring:message>
							</c:if>
						</spring:hasBindErrors>
	                </p>
                </div>
            </div>
            <div class="pw-div">
                <label for="pwd">패스워드</label>
                <input type="password" name="pwd" id="pwd"  > 
                <div>
                	<p id="pwdcheck"> 
		                <spring:hasBindErrors name="memberDTO">
							<c:if test="${errors.hasFieldErrors('pwd') }">
								<spring:message code="${errors.getFieldError('pwd').codes[0] }"
									text="${errors.getFieldError('pwd').defaultMessage }"></spring:message>
							</c:if>
						</spring:hasBindErrors>
	                </p>
                </div>
            </div>
            <div class="repw-div">
                <label for="repwd">패스워드 재입력</label>
                <input type="password" id="repwd" >  
            </div>
            <div class="email-div">
                <label for="email">이메일</label>
                <input type="text" name="email" id="email" value="${param.email }">
                 <input type="button" id="sendEmailBtn" value="인증번호 발송">
                  <div>
                	<p id="emailcheck"> 
		                <spring:hasBindErrors name="memberDTO">
							<c:if test="${errors.hasFieldErrors('email') }">
								<spring:message code="${errors.getFieldError('email').codes[0] }"
									text="${errors.getFieldError('email').defaultMessage }"></spring:message>
							</c:if>
						</spring:hasBindErrors>
	                </p>
                </div>
            </div>
            
             <div class="emailnumber-div">
                <label for="emailnumber">인증 번호</label>
                <input type="text" name="emailnumber" id="emailnumber" >
                <input type="button" id="checkemailnumber" value="확인">
                
            </div>
            
            <div class="btn">
                <input id="sbbtn" type="submit" value="회원가입">
            </div>
        </form>
    </section>
    <script src="/project/js/check.js"></script>
    <script src="/project/js/email.js"></script>
    <script src="/project/js/idCheck.js"></script>
</body>
</html>