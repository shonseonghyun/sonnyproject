package webprj.dao.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import webprj.dto.member.MemberDTO;


@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	SqlSession sqlSession;
	
	
	@Override
	public MemberDTO doLogin(MemberDTO member) {
		return sqlSession.selectOne("member.login", member);
	}

	@Override
	public void signup(MemberDTO member) {
		sqlSession.insert("member.signup", member);
	}

	@Override
	public int idcheck(String id) {
		return sqlSession.selectOne("member.idcheck", id);
	}

}
