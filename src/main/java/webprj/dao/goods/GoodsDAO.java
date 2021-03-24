package webprj.dao.goods;

import java.util.List;

import webprj.dto.goods.GoodsDTO;

public interface GoodsDAO {
	//상품 등록
	void registerGoods(GoodsDTO dto);
	
	//상품 목록
	List<GoodsDTO> getAllList();
	//특정 상품
	GoodsDTO getList(int id);

}
