package webprj.dao.goods;

import java.util.List;

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

	@Override
	public List<GoodsDTO> getAllList() {
		return sqlsession.selectList("goods.getAlllist");
	}

	@Override
	public GoodsDTO getList(int id) {
		return sqlsession.selectOne("goods.getlist", id);
	}

}
