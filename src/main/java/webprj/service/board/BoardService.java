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
	
	//내정보
	//고객이 쓴 게시글 수
	int countMyBoard(String id);
	
	//고객이 쓴 모든 게시글
	List<BoardDTO> getMyBoard(String id, int page,int quantity);
}
