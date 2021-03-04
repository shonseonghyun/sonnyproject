package webprj.service.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webprj.dao.member.MemberDAO;
import webprj.dto.member.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDAO;
	
	@Override
	public String doLogin(MemberDTO member) {
		return memberDAO.doLogin(member);
	}

	@Override
	public void signup(MemberDTO member) {
		memberDAO.signup(member);
	}

}
