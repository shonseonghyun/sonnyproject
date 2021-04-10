package webprj.service.board.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webprj.dao.board.reply.BoardReplyDAO;
import webprj.dto.board.BoardReplyDTO;

@Service
public class BoardReplyServiceImpl implements BoardReplyService {

	
	@Autowired
	BoardReplyDAO boardReplyDAO;
	
	//댓글 조회->게시글 id로 찾는다
	@Override
	public List<BoardReplyDTO> readReply(int id) {
		return boardReplyDAO.readReply(id);
	}

	@Override
	public void writerReply(BoardReplyDTO reply) {
		boardReplyDAO.writerReply(reply);
	}

	@Override
	public void delReply(int no) {
		boardReplyDAO.delReply(no);
	}

}
