package webprj.service.board;

import java.util.List;

import webprj.dto.board.BoardDTO;


public interface BoardService {
	List<BoardDTO> getAllboard(int page,String f,String p);
	void WriteBoard(BoardDTO board);
	BoardDTO getboard(int id);
	int countboard(String f,String q);
	//삭제
	void deleteboard(int id);
	
	//수정
	void modifyboard(BoardDTO board);
	
	//조회 top3
	List<BoardDTO> gethittop3();

	//id로 title 구하기
	String getTitle(int id);
}
