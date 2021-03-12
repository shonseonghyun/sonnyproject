package webprj.dao.board.reply;

import java.util.List;

import webprj.dto.board.BoardReplyDTO;


public interface BoardReplyDAO {
	//댓글 조회
	public List<BoardReplyDTO> readReply(int id);
	
	//댓글 작성
	public void writerReply(BoardReplyDTO reply);
	
	//댓글 삭제
	public void delReply(int no);
	}
