/*$(function(){
	$(".add-btn").on("click",function(){
		var pro={
			id :  $(".id").val(),
			gds_id : $(".gds_id").val(),
			amount : $("#quantity").val()
		}
		$.ajax({
			type:"post",
			contentType: "application/json",
			url : "order",
			data: JSON.stringify(pro),
			error : function(){
				alert("상품 담기 완료");
			}
		})
	})
});*/