$(function(){
	//총 삼품금액, 총 배송비 , 결제 예정 금액 만드는 함수 선언!!
	//추후에 수량변경할 때 필요한 함수
	//함수 선언식
	function payment_fun(){
		//총 삼품금액
		var total=0;
		$(".amount").each(function(i,k){
			total +=Number($(k).text());
		})
		$(".Total_Amount").text(total);
		
		//배송비
		if($(".Total_Amount").text() >=  10000){
			$(".Dilevery_Cost").text(0);
		}
		else{
			$(".Dilevery_Cost").text(2500);
		}
		var payment = Number($(".Total_Amount").text()) +
			 Number($(".Dilevery_Cost").text());
		$(".Payment_Amount").text(payment);
	}
	payment_fun();
	
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
	
	
	//쇼핑계속ㅎ기
	$(".goods").on("click",function(){
		location.href="goods";
	})
	
	//수량 변경
	$(".qty").on("change",function(){
		//수량 변경한 상품 가격
		var qty = $(this).val();
		var data ={
			"cart_id": $(this).prev().val() ,
			"qty" : qty
		};
		console.log(data);
		var price= $(this).parent().prev().text();
		//수량 변경 * 상품 가격
		var money = price * $(this).val();
		$(this).parent().next().text(money);
		payment_fun();
		$.ajax({
			type:"get",
			//contentType: "application/json",
			url : "cart/modify",
			data: data,
			success : function(result){
				console.log(result);
				console.log("success");
			},
			error : function(result){
				console.log(result);
			}
		})
	})
})