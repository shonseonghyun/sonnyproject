<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="/pf/css/signup.css">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
 	$(function(){ //자동으로 실행되는 함수들
 	 	//아이디 중복검사
		$("#checkidbtn").click(function(){
			id=$("#id").val();
			var data={"id":id};
//			var w = window.open("about:blank","content","width=300,height=100");
 		
 	 		$.ajax({
				type:"post",
 	 			url:"/pf/idcheck",
 	 			data:data,
				success:function(result){
					console.log("0:사용가능한아이디,1:사용불가능한아이디 ["+result+"]");
					if(result==0){
						$("#idcheck").text("사용가능한 아이디입니다.");
						$("#pwd").focus();
					}
					else{
						$("#idcheck").text("사용불가능한 아이디입니다.");
						$("#idcheck").css("color","red");
						
						$("#id").val("");
						$("#id").focus();
					}
				}
			})
			
		})
	}) 
</script>
</head>
<body onload="document.loginform.name.focus()">
    <section class="login-section">
        <h1>LOGO DESIGN</h1>
        <form method="post" name="loginform" class="login-form" autocomplete="off">
       		<div class="name-div">
                <label for="name">이름</label>
                <input type="text" name="name" id="name" >
                <div id="namecheck" class="checkfont"></div>
            </div>
            
            <div class="id-div">
                <label for="id">아이디</label>
                <input type="text" name="id" id="id" >
                <input type="button" id="checkidbtn" value="중복확인">
                <div id="idcheck" class="checkfont"></div>
                
            </div>
            <div class="pw-div">
                <label for="pwd">패스워드</label>
                <input type="password" name="pwd" id="pwd" >  
                <div id="pwdcheck" class="checkfont"></div>
            </div>
            <div class="repw-div">
                <label for="repwd">패스워드 재입력</label>
                <input type="password" id="repwd" >  
            </div>
            <div class="email-div">
                <label for="email">이메일</label>
                <input type="text" name="email" id="email" >  
                <div id="emailcheck" class="checkfont"></div>
            </div>
            
            <div class="btn">
                <input id="sbbtn" type="button" onclick="checkpw()" value="회원가입">
            </div>
        </form>
    </section>
    <script src="/pf/js/signup.js"></script>
    <script src="/pf/js/check.js"></script>
</body>
</html>