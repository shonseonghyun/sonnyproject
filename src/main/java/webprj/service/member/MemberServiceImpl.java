package webprj.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webprj.dao.member.MemberDAO;
import webprj.dto.member.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDAO;
	
	@Override
	public MemberDTO doLogin(MemberDTO member) {
		return memberDAO.doLogin(member);
	}

	@Override
	public void signup(MemberDTO member) {
		memberDAO.signup(member);
	}

	@Override
	public int idcheck(String id) {
		return memberDAO.idcheck(id);
	}

	@Override
	public MemberDTO findId(String name, String email,String id) {
		return memberDAO.findId(name, email,id);
	}

	@Override
	public void changePw(String id, String temp_pw) {
		memberDAO.changePw(id, temp_pw);
	}

	@Override
	public MemberDTO getMyInformation(String id) {
		return memberDAO.getMyInformation(id);
	}

	@Override
	public String changePwdWithId(String id) {
		return memberDAO.changePwdWithId(id);
	}

}
