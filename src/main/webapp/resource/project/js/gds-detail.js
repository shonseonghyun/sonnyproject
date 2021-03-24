$(function(){
	$(".plus-btn").on("click",function(){
		$("input").val(Number ($("input").val())+1);
	})
	
	$(".minus-btn").on("click",function(){
		var value=$("input").val();
		if(value <=0){
			alert(" 수량 조절 불가");
		}
		else{
			$("input").val(Number ($("input").val())-1);
		}
	})
})