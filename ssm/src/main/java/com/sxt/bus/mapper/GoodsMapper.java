package com.sxt.bus.mapper;

import java.util.List;

import com.sxt.bus.domain.Goods;
import com.sxt.bus.vo.GoodsVo;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    /**
     * 查询所有的商品
     * @param vo
     * @return
     */

	List<GoodsVo> queryAllGoods(Goods record);
	
}