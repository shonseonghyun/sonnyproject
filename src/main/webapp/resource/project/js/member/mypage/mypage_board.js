$(function(){
	$(".delBtn").click(function(){
		if(confirm("정말 삭제하시겠습니까?")){
			var current_page = $(".current_page").val();
			
			if(current_page == null || current_page ==""){
				current_page=1;				
			}
			var data = {
				"board_id" : $(this).attr("id"),
				"current_page" : current_page
			};
			
			$.ajax({
				url : "board/del",
				type : "post",
				data : data,
				success:function(result){
					location.href=result+"?page="+current_page;
				},
				error:function(a,b,c){
					console.log(a);
					console.log(b);
					console.log(c);
				}
			})
		}else{
			return false;
		}
	})
})