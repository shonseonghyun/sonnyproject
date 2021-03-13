var outbtn=document.getElementById('LogoutBtn');

function logoutbtn(){
	console.log("s");
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