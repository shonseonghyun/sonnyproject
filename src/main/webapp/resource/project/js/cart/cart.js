$(function(){
	//체크 부분
	$("#allChecked").on("click",function(){
		var checked=$(this).is(":checked");
		if(checked){
			$(".item").prop("checked",true);
		}
		else{
			$(".item").prop("checked",false);
		}
		
	})
	$(".item").click(function(){
		var checkbox_length=$(".item:checkbox").length;
		var selected_length=$(".item:checkbox:checked").length;
		if(selected_length != checkbox_length ){
			$("#allChecked").prop("checked",false);
		}
		else{
			$("#allChecked").prop("checked",true);
		}
	})
	
	//선택 상품 삭제
	$(".delete").on("click",function(){
		if($(".item:checkbox:checked").length ==0){
			alert("선택된 상품이 존재하지 않습니다.");
		}
		else{
			if(confirm("삭제하시겠습니까?")){
			$("form").attr("action","cart/delete");
			$("form").submit();
			}
		}
	})
	
	$(".goods").on("click",function(){
		location.href="goods";
	})
})