package webprj.dao.member;

import webprj.dto.member.MemberDTO;

public interface MemberDAO {
	//로그인 ->이름 반환
	public MemberDTO doLogin(MemberDTO member);
	
	//아이디 회원가입
	public void signup(MemberDTO member);
	
	//중복확인
	public int idcheck(String id);
	
	//아이디 찾기
	public MemberDTO findId(String name,String email ,String id);
	
	//임시비밀번호 전송 후 수정
	//마이페이지 비밀번호 변경
	public void changePw(String id, String temp_pw);
	
	//마이페이지 부분 시작
	//마이페이지
	public MemberDTO getMyInformation(String id);
	
	//
	public String changePwdWithId(String id);
	
	//마이피에지 아이디 변경
	
}
