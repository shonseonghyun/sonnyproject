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
	public MemberDTO findId(String name, String email, String id) {
		Map<String,String> map = new HashMap<>();
		map.put("name", name);
		map.put("id", id);
		map.put("email", email);
		return sqlSession.selectOne("member.find", map);
	}

	@Override
	public void changePw(String id, String temp_pw) {
		Map<String,String> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", temp_pw);
		sqlSession.update("member.changepwd", map);
	}

	@Override
	public MemberDTO getMyInformation(String id) {
		return sqlSession.selectOne("member.getMyInformation", id);
	}

	@Override
	public String changePwdWithId(String id) {
		return sqlSession.selectOne("member.changePwdWithId", id);
	}

}
