package webprj.service.goods;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webprj.dao.goods.GoodsDAO;
import webprj.dto.cart.CartDTO;
import webprj.dto.goods.GoodsDTO;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	GoodsDAO goodsDAO;
	
	@Override
	public void registerGoods(GoodsDTO dto) {
		goodsDAO.registerGoods(dto);
	}

	@Override
	public List<GoodsDTO> getAllList() {
		return goodsDAO.getAllList();
	}

	@Override
	public GoodsDTO getList(int id) {
		// TODO Auto-generated method stub
		return goodsDAO.getList(id);
	}

	@Override
	public void orderGoods(CartDTO cart) {
		goodsDAO.orderGoods(cart);
	}

	@Override
	public List<CartDTO> getOrderList(String id) {
		return goodsDAO.getOrderList(id);
	}

	@Override
	public void deleteOrderList(int[] cart_id) {
		goodsDAO.deleteOrderList(cart_id);
	}

	@Override
	public void modifyQty(Map<String, Object> map) {
		goodsDAO.modifyQty(map);
	}

}
