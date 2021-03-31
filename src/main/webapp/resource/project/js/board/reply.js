$(document).ready(function(){
	
	/*$("#replyBtn").on("click",function(){
		if($(this).attr("class")=="show"){
			$("#reply-div").css("display","none");
			$(this).attr("class","hide");
		}
		else{
			$("#reply-div").css("display","block");
			$(this).attr("class","show");
		}
	})
	*/
	
	$("#replyBtn").on("click",function(){
		if($("#reply-div").is(':visible')){
			$("#reply-div").css("display","none");
			$(this).text("댓글 작성 열기");
		}
		else{
			$("#reply-div").css("display","block");
			$(this).text("댓글 작성 닫기");
		}
	})
});