$(function(){
	$(".plus-btn").on("click",function(){
		$("#quantity").val(Number ($("#quantity").val())+1);
	})
	
	$(".minus-btn").on("click",function(){
		var value=$("#quantity").val();
		if(value <=0){
			alert(" 수량 조절 불가");
		}
		else{
			$("#quantity").val(Number ($("#quantity").val())-1);
		}
	})
	
	$(".gds_list-btn").on("click",function(){
		location.href="/football/goods";
	})
	
})