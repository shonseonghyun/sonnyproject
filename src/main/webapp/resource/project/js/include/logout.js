if(sessionStorage.getItem("id") != null){

	var outbtn=document.getElementById('LogoutBtn');
	
	function logoutbtn(){
			if(confirm("로그아웃하시겠습니까?")==true){
				location.href="/football/logout";
			}
			else
				return;
	}
	
	function event(){
		outbtn.addEventListener("click",logoutbtn);
	}
	
	event();
}