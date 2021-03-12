package webprj.dao.board.reply;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import webprj.dto.board.BoardReplyDTO;

@Repository
public class BoardReplyDAOImpl implements BoardReplyDAO {

	@Autowired
	SqlSession sqlsession;
	
	@Override
	public List<BoardReplyDTO> readReply(int id) {
		return sqlsession.selectList("boardreply.readreply", id);

	}

	@Override
	public void writerReply(BoardReplyDTO reply) {
		sqlsession.insert("boardreply.writereply", reply);
	}

	@Override
	public void delReply(int no) {
		sqlsession.delete("boardreply.delreply", no);
	}

}
