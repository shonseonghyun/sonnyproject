package webprj.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webprj.dao.goods.GoodsDAO;
import webprj.dto.cart.CartDTO;
import webprj.dto.goods.GoodsDTO;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	GoodsDAO gdsdao;
	
	@Override
	public void registerGoods(GoodsDTO dto) {
		gdsdao.registerGoods(dto);
	}

	@Override
	public List<GoodsDTO> getAllList() {
		return gdsdao.getAllList();
	}

	@Override
	public GoodsDTO getList(int id) {
		// TODO Auto-generated method stub
		return gdsdao.getList(id);
	}

	@Override
	public void orderGoods(CartDTO cart) {
		gdsdao.orderGoods(cart);
	}

	@Override
	public List<CartDTO> getOrderList(String id) {
		return gdsdao.getOrderList(id);
	}

	@Override
	public void deleteOrderList(int[] cart_id) {
		gdsdao.deleteOrderList(cart_id);
	}

}
