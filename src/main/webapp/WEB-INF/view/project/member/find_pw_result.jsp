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
		$(".gotoMain-btn").click(function(){
			location.href= "main";
		})

		//임시비밀번호 전송
		$(".sendPwd-btn").click(function(){
			var email ={ 
					"email" : $("#hidden_email").val(),
					"id" : $("#hidden_id").val()
				};

			$.ajax({
				type : "POST",
				data : email,
				url : "send_pw",
				success : function(member){
						var form = $('<form></form>');
					    form.attr('action', "find_pw_result");
					    form.attr('method', 'post');
					    form.append($('<input/>', {type: 'hidden', name: 'email', value: member.email}));
					    form.append($('<input/>', {type: 'hidden', name: 'id', value: member.id}));

					    form.appendTo('body');
						form.submit();

				},
				error: function(a,b,c){
					console.log(a);
					console.log(b);
				}
			})
		})
	})
</script>
<title>비밀번호 찾기</title>
</head>
	<body>
    <section class="login-section">
            <h1>FIND PASSWORD</h1>
            <div class="main-div">
				<h3>임시 비밀번호 전송</h3>
            </div>
            <div class="find-div">
				<p>
				<input id="hidden_id" type="hidden" value="${member.id }">
				<input id="hidden_email" type="hidden" value="${member.email }">
					이메일: ${member.email }
				</p>
            </div>
            <div class="btn-div">
            	<button class="sendPwd-btn" type="button">임시 비밀번호 전송</button>
            	<button class="gotoMain-btn" type="button">취소</button>
            </div>
    </section>
 </body>
</html>