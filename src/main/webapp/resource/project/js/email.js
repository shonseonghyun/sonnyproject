var code = "";

$(function(){
	/*인증 번호 이메일 전송*/
	$("#sendEmailBtn").click(function(){
		//입력한 이메일
		var email = $("#email").val();
		
		$.ajax({
			type : "get",
			url : "mailcheck?email="+email,
			success : function(data){
				console.log("data : "+ data );
				code = data;
			}
		});
	})
})

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