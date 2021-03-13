package webprj.dao.goods;

import webprj.dto.goods.GoodsDTO;

public interface GoodsDAO {
	//상품 등록
	void registerGoods(GoodsDTO dto);
}
