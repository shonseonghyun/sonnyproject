package webprj.dao.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import webprj.dto.board.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<BoardDTO> getAllboard(int page,String f,String q) {
		Map<String,Object> map=new HashMap<>();
		map.put("page", page);
		map.put("search_option",f);
		map.put("q",q);
		return sqlSession.selectList("board.getAllboard",map);
	}

	@Override
	public void WriteBoard(BoardDTO board) {
		sqlSession.insert("board.writeboard", board);
	}

	@Override
	public BoardDTO getboard(int id) {
		return sqlSession.selectOne("board.getboard", id);
	}

	@Override
	public int countboard(String f,String q) {
		Map<String,Object> map=new HashMap<>();
		map.put("f",f);
		map.put("q",q);
		return sqlSession.selectOne("board.countboard",map);
	}

	@Override
	public void addHit(int id) {
		sqlSession.selectOne("board.addHit", id);
	}

	@Override
	public void deleteboard(int id) {
		sqlSession.selectOne("board.deleteboard",id);
		
	}

	@Override
	public void modifyboard(BoardDTO board) {
		sqlSession.update("board.modifyboard",board);
		
	}

	@Override
	public List<BoardDTO> gethittop3() {
		return sqlSession.selectList("board.hittop3");
	}


}
