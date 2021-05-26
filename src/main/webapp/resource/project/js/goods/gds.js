$(function(){
	function comma(str) {
        str = String(str);
        return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
    }

	//마우스가 올려져 있을 때 
	$(".item li").on("mouseover",function(){
		console.log($(this).children("p").text("!"));
		$(this).children("p").text("₩"+comma($(this).attr("price")));
	})
	
	//마우스가 나갔을 때
	$(".item li").on("mouseout",function(){
		$(this).children("p").text("");
	})
})