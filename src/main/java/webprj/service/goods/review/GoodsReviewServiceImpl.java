package webprj.service.goods.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webprj.dao.goods.review.GoodsReviewDAO;
import webprj.dto.goods.GoodsReviewDTO;

@Service
public class GoodsReviewServiceImpl implements GoodsReviewService {

	@Autowired
	GoodsReviewDAO goodsReviewDAO;
	
	@Override
	public List<GoodsReviewDTO> readReview(int gds_id) {
		return goodsReviewDAO.readReview(gds_id);
	}

	@Override
	public void writeReview(GoodsReviewDTO review) {
		goodsReviewDAO.writeReview(review);
	}

	@Override
	public void delReview(int id) {
		goodsReviewDAO.delReview(id);
	}

}
