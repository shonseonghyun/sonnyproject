package webprj.dao.goods;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import webprj.dto.goods.GoodsDTO;

@Repository
public class GoodsDAOImpl implements GoodsDAO {

	@Autowired
	SqlSession sqlsession;
	
	@Override
	public void registerGoods(GoodsDTO dto) {
		sqlsession.insert("goods.registerGoods", dto);
	}

}
