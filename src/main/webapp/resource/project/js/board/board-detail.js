$(function(){
	$(".prev ,.next").on("click",function(){
		var notice_id=$(this).attr("id");
		
		if(notice_id !=0){
			var href="detail?id="+notice_id;
			location.href=href;
			return ;
		}
		
		alert("더 이상 글이 존재하지 않습니다.");
	
	})
})