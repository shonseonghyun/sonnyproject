$(function(){
	
    $(".changePwd-btn").click(function(){
       $("#pwd-area").css('display','none');
       $("#change-pwd-area").css('display','table-row');
    })

    $("#cancelPwd-btn").click(function(){
        $("#pwd-area").css('display','table-row');
       $("#change-pwd-area").css('display','none');
    })

    $(".changeId-btn").click(function(){
        $("#id-area").css('display','none');
        $("#change-id-area").css('display','table-row');
     })
 
     $("#cancelId-btn").click(function(){
         $("#id-area").css('display','table-row');
        $("#change-id-area").css('display','none');
     })
})