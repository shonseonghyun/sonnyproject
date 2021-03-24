$(function(){
	$(".delReplyBtn").on("click",function(){
		location.href="replydel?id="+$(this).attr('data-id')+"&no="+$(this).attr('data-no');
	})
})