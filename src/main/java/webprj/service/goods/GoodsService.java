package webprj.service.goods;

import java.util.List;

import webprj.dto.cart.CartDTO;
import webprj.dto.goods.GoodsDTO;

public interface GoodsService {
	//상품등록
	void registerGoods(GoodsDTO dto);
	
	//상품 목록
	List<GoodsDTO> getAllList();
	
	//특정 상품
	GoodsDTO getList(int id);
	
	//상품 담기
	void orderGoods(CartDTO cart);

	//담아둔 상품
	List<CartDTO> getOrderList();
		
}
