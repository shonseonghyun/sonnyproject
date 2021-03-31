package webprj.dao.goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import webprj.dto.cart.CartDTO;
import webprj.dto.goods.GoodsDTO;

@Repository
public class GoodsDAOImpl implements GoodsDAO {

	@Autowired
	SqlSession sqlsession;
	
	@Override
	public void registerGoods(GoodsDTO dto) {
		sqlsession.insert("goods.registerGoods", dto);
	}

	@Override
	public List<GoodsDTO> getAllList() {
		return sqlsession.selectList("goods.getAlllist");
	}

	@Override
	public GoodsDTO getList(int id) {
		return sqlsession.selectOne("goods.getlist", id);
	}

	@Override
	public void orderGoods(CartDTO cart) {
		sqlsession.insert("goods.order", cart);
	}

	@Override
	public List<CartDTO> getOrderList(String id) {
		return sqlsession.selectList("goods.getOrderList",id);
	}

	@Override
	public void deleteOrderList(int[] cart_id) {
		HashMap<String, Object> map= new HashMap<>();
		map.put("OrderList", cart_id);
		sqlsession.delete("goods.deleteOrderList", map);
	}

	@Override
	public void modifyQty(Map<String, Object> map) {
		sqlsession.update("goods.modifyQty", map);
	}


}
