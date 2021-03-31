$(function(){
	//아이디 중복확인
	$("#checkidbtn").on("click",function(){
		$("#idcheck").text("");
		id =$("#id").val();
		var obj = {"id" : id};
		
		$.ajax({
			type : "post",
			url: "idcheck",
			data : obj,
			success : function(result){
				if(result != 0){
					alert("사용 불가능한 아이디입니다.");
					$("#id").val("");
					$("#id").focus();
					
				}
				else{
					alert("사용 가능한 아이디입니다.");
				}
			}
		})
	});
})