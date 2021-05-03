var code = "";

$(function(){
	var emailJ=/^[0-9A-Za-z]([-_.]?[0-9A-Za-z])*@([-_.]?[0-9A-Za-z])*.[a-zA-Z]{2,3}$/i;


	/*인증 번호 이메일 전송*/
	$("#sendEmailBtn").click(function(){
		//입력한 이메일
		var email = $("#email").val();
		console.log(email);
		if(emailJ.test(email)){
			$.ajax({
				type : "get",
				url : "mailcheck?email="+email,
				success : function(data){
					alert("인증번호가 전송되었습니다.");
					console.log("data : "+ data );
					code = data;
				}
			});
		}
		else{
			alert("이메일을 확인해 주세요.");
		}		
	});
	
	/* 인증번호 홖인 버튼 클릭 */
	$("#checkemailnumber").click(function(){
		
		if($("#emailnumber").val() == code ){
			alert("인증이 완료되었습니다.")
		}
		else{
			alert("인증번호를 확인해 주세요.");
			$("#emailnumber").val("");
		}
	});
})

