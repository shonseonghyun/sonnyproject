package webprj.dao.member;

import webprj.dto.member.MemberDTO;

public interface MemberDAO {
	//로그인 ->이름 반환
	public String doLogin(MemberDTO member);
	
	//아이디 회원가입
	public void signup(MemberDTO member);
}
