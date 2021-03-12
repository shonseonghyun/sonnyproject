$(function(){
	$(".delReplyBtn").on("click",function(){
		location.href="/pf/board/replydel?id="+$(this).attr('data-id')+"&no="+$(this).attr('data-no');
	})
})