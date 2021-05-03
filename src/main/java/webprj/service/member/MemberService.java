package webprj.service.member;

import webprj.dto.member.MemberDTO;

public interface MemberService {
	//로그인 ->이름 반환
	public MemberDTO doLogin(MemberDTO member);
		
	//아이디 회원가입
	public void signup(MemberDTO member);
	
	//중복확인
	public int idcheck(String id);

	//아이디 찾기
	public MemberDTO findId(String name,String email);

}
