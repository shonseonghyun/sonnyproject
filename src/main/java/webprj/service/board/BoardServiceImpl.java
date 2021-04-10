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
	BoardDAO boardDAO;
	
	@Override
	public List<BoardDTO> getAllboard(int page,String f,String q) {
		return boardDAO.getAllboard(page,f,q);
	}

	@Override
	public void WriteBoard(BoardDTO board) {
		boardDAO.WriteBoard(board);
	}

	@Override
	@Transactional
	public BoardDTO getboard(int id) {
		boardDAO.addHit(id);
		return boardDAO.getboard(id);
	}

	@Override
	public int countboard(String f,String q) {
		return boardDAO.countboard(f,q);
	}

	@Override
	public void deleteboard(int id) {
		boardDAO.deleteboard(id);
	}

	@Override
	public void modifyboard(BoardDTO board) {
		boardDAO.modifyboard(board);
	}

	@Override
	public List<BoardDTO> gethittop3() {
		return boardDAO.gethittop3();
	}

	@Override
	public String getTitle(int id) {
		return boardDAO.getTitle(id);
	}

}
