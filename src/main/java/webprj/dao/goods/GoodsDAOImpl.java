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
	SqlSession sqlSession;
	
	@Override
	public void registerGoods(GoodsDTO dto) {
		sqlSession.insert("goods.registerGoods", dto);
	}

	@Override
	public List<GoodsDTO> getAllList(int page,int quantity) {
		Map<String,Integer> map = new HashMap<>();
		map.put("page", page);
		map.put("quantity", quantity);
		return sqlSession.selectList("goods.getAlllist",map);
	}

	@Override
	public GoodsDTO getList(int id) {
		return sqlSession.selectOne("goods.getlist", id);
	}

	@Override
	public void orderGoods(CartDTO cart) {
		sqlSession.insert("goods.order", cart);
	}

	@Override
	public List<CartDTO> getOrderList(String id) {
		return sqlSession.selectList("goods.getOrderList",id);
	}

	@Override
	public void deleteOrderList(int[] cart_id) {
		HashMap<String, Object> map= new HashMap<>();
		map.put("OrderList", cart_id);
		sqlSession.delete("goods.deleteOrderList", map);
	}

	@Override
	public void modifyQty(Map<String, Object> map) {
		sqlSession.update("goods.modifyQty", map);
	}


}
