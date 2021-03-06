package webprj.dao.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import webprj.dto.member.MemberDTO;


@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	SqlSession sqlsession;
	
	
	@Override
	public MemberDTO doLogin(MemberDTO member) {
		return sqlsession.selectOne("member.login", member);
	}

	@Override
	public void signup(MemberDTO member) {
		sqlsession.insert("member.signup", member);
	}

	@Override
	public int idcheck(String id) {
		return sqlsession.selectOne("member.idcheck", id);
	}

}
