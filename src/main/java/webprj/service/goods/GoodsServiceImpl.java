package webprj.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webprj.dao.goods.GoodsDAO;
import webprj.dto.goods.GoodsDTO;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	GoodsDAO gdsdao;
	
	@Override
	public void registerGoods(GoodsDTO dto) {
		gdsdao.registerGoods(dto);
	}

}
