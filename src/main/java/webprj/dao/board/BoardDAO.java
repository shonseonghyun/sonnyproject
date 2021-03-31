package webprj.dao.board;

import java.util.List;

import webprj.dto.board.BoardDTO;

public interface BoardDAO {
		//전체 게시물 보기
		List<BoardDTO> getAllboard(int page,String f,String p);

		//게시물 작성
		void WriteBoard(BoardDTO board);

		//게시물 보기
		BoardDTO getboard(int id);
		
		//게시물 총 개수 세기
		int countboard(String f,String q);
		
		//조회수 올리기
		void addHit(int id);
		
		//삭제
		void deleteboard(int id);
		
		//수정
		void modifyboard(BoardDTO board);
		
		//조회 top3
		List<BoardDTO> gethittop3();
		
		//id로 title 구하기
		String getTitle(int id);
}
