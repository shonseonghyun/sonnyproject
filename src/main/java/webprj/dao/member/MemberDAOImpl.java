package webprj.dao.member;

import java.util.HashMap;
import java.util.Map;

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

	@Override
	public MemberDTO findId(String name, String email) {
		Map<String,String> map = new HashMap<>();
		map.put("name", name);
		map.put("email", email);
		return sqlSession.selectOne("member.find_id", map);
	}

}
