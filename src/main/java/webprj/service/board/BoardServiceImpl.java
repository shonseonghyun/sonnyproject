package webprj.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webprj.dao.board.BoardDAO;
import webprj.dto.board.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO boarddao;
	
	@Override
	public List<BoardDTO> getAllboard(int page,String f,String q) {
		return boarddao.getAllboard(page,f,q);
	}

	@Override
	public void WriteBoard(BoardDTO board) {
		boarddao.WriteBoard(board);
	}

	@Override
	@Transactional
	public BoardDTO getboard(int id) {
		boarddao.addHit(id);
		return boarddao.getboard(id);
	}

	@Override
	public int countboard(String f,String q) {
		return boarddao.countboard(f,q);
	}

	@Override
	public void deleteboard(int id) {
		boarddao.deleteboard(id);
	}

	@Override
	public void modifyboard(BoardDTO board) {
		boarddao.modifyboard(board);
	}

	@Override
	public List<BoardDTO> gethittop3() {
		return boarddao.gethittop3();
	}

	@Override
	public String getTitle(int id) {
		return boarddao.getTitle(id);
	}

}
