$(function(){
	function comma(str) {
        str = String(str);
        return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
    }
	function uncomma(str) {
        str = String(str);
        return str.replace(/[^\d]+/g, '');
    }
	

//등록버튼 클릭
	$(".reg-btn").on("click",function(){
		$("#frm").submit();
	})
	
	//가격 작성 시 콤마 표시
	$("#price").on("keyup keydow",function(){
		$(this).val(comma(uncomma($(this).val())));
		$("#gds_price").val(Number(uncomma($(this).val())));
	})
})	