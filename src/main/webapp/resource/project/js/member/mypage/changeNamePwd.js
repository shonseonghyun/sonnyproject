$(function(){
	var pwJ=/^[A-Za-z0-9!@]{4,12}$/;

	//정규표현식과 같음 조건을 통과 못할 시 버튼 disabled
	$("#new-pwd,#confirm-pwd").on("keyup",function(){
		var inputPwd = $("#new-pwd").val();
		var reinputPwd = $("#confirm-pwd").val();
		if(pwJ.test(inputPwd) && pwJ.test(reinputPwd)){
			if(inputPwd == reinputPwd){ //두 개가 같을 경우
				$("#finishPwd-btn").prop("disabled",false);
			}else{ // 두개가 다를 경우
				$("#finishPwd-btn").prop("disabled",true);
			}
		}else{
			$("#finishPwd-btn").prop("disabled",true);
		}
	})
	
	$("#finishPwd-btn").click(function(){
		var inputPwd = $("#new-pwd").val();
		var data ={
			id : $(".hidden_id").val(),
			original_pwd :  $("#current-pwd").val(),
			new_pwd : inputPwd
		};
		
		if(confirm("비밀번호를 변경하시겠습니까?")){
			$.ajax({
				url:"mypage/change",
				type:"post",
				data: data,
				//contentType : "application/json",
				success:function(result){
					if(!result){
						alert("현재 비밀번호가 일치하지 않습니다.");
						$("#current-pwd").val("");
						$("#current-pwd").focus();
					}else{
						alert("비밀번호 변경 완료되었습니다.");
						$("#pwd-area").css('display','table-row');
       					$("#change-pwd-area").css('display','none');
						$("input").val("");
					}
				},
				error:function(a,b,c){
					console.log(a);
					console.log(b);
					console.log(c);
				}
				
			})
			
		}
	})
	
})