package webprj.dao.goods.review;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import webprj.dto.goods.GoodsReviewDTO;

@Repository
public class GoodsReviewDAOImpl implements GoodsReviewDAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public List<GoodsReviewDTO> readReview(int gds_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gdsReview.readReview", gds_id);
	}

	@Override
	public void writeReview(GoodsReviewDTO review) {
		sqlSession.insert("gdsReview.writeReview", review);
	}

	@Override
	public void delReview(int id) {
		sqlSession.delete("gdsReview.delReview", id);
		
	}
}
