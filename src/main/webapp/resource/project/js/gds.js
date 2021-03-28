$(function(){
	//마우스가 올려져 있을 때 
	$(".item li").on("mouseover",function(){
		$(this).children("p").text("₩"+$(this).attr("price"));
	})
	
	//마우스가 나갔을 때
	$(".item li").on("mouseout",function(){
		$(this).children("p").text("");
	})
})