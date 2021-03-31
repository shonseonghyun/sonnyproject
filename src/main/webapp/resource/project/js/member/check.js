$(function(){
	//아이디 정규식
		//a~z,0~9 시작하는 4~12자리아이디 가능
		var idJ=/^[a-z0-9]{4,12}$/;
		var nameJ=/^[가-힣]{2,6}$/;
		var pwJ=/^[A-Za-z0-9!@]{4,12}$/;
		var emailJ=/^[0-9A-Za-z]([-_.]?[0-9A-Za-z])*@([-_.]?[0-9A-Za-z])*.[a-zA-Z]{2,3}$/i;

		var email=$("#email");
		
 		var name=$("#name");
 		var pwd=$("#pwd");
 		var repwd=$("#repwd");
		
 		name.blur(function(){
 			if(nameJ.test(name.val())){
 	 			$("#namecheck").text("");
 	 		}
 			else{
 	 			$("#namecheck").text("이름를 확인해주세요");
 	 			$("#namecheck").css("color","red");
 	 			
 	 		}
 		});

 		//pwd형식에 맞게
 		pwd.blur(function(){
			if(pwJ.test(pwd.val())){ //형식 만족
 	 	 		$("#pwdcheck").text("");
			}
			else{
 	 	 		$("#pwdcheck").text("비밀번호 확인해주세요");
 	 			$("#pwdcheck").css("color","red");
			}
 	 	 })
 		
 		
 		//pwd,repwd값이 같은지
 		repwd.blur(function(){
 	 		if(repwd.val() != pwd.val()){
 	 	 		$("#pwdcheck").text("비밀번호 확인해주세요");
 	 			$("#pwdcheck").css("color","red");
 	 	 		
 	 	 	}
 	 		if(repwd.val() == pwd.val())
 	 		{
 	 	 		$("#pwdcheck").text("");
 	 	 	}
 	 		/*if(pwJ.test(pwd.val())){ //형식 만족
 	 	 		$("#pwdcheck").text("");
			}
			if(!pwJ.test(pwd.val()))
			{
 	 	 		$("#pwdcheck").text("비밀번호 확인해주세요");
 	 			$("#pwdcheck").css("color","red");
			}*/
 	 	 })
 	 	 
 	 	email.blur(function(){
			if(emailJ.test(email.val())){
				$("#emailcheck").text("");
			}
			else{
				$("#emailcheck").text("이메일을 확인해주세요");
				$("#emailcheck").css("color","red");
			}
		})
})

