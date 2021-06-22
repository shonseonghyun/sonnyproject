package webprj.service.goods.review;

import java.util.List;

import webprj.dto.goods.GoodsReviewDTO;

public interface GoodsReviewService {
	
	//리뷰 조회
	List<GoodsReviewDTO> readReview(int gds_id);
	
	//리뷰 작성
	public void writeReview(GoodsReviewDTO review);
		
	//리뷰 삭제
	public void delReview(int id);
}
