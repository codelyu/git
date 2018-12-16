package com.sxt.bus.service;

import java.util.List;

import com.sxt.bus.domain.Goods;
import com.sxt.bus.vo.GoodsVo;
import com.sxt.bus.utils.DataGridView;

public interface GoodsService {
	/**
	 * 全查询
	 * @param goodsvo
	 * @return
	 */

	DataGridView queryAllGoods(GoodsVo goodsvo);

	/**
	 * 添加
	 * 
	 * @param goodsVo
	 */
	void addGoods(GoodsVo goodsVo);

	/**
	 * 
	 * @param id
	 *            要查询的商品的id
	 * @return
	 */
	Goods queryGoodsById(Integer id);

	/**
	 * 修改
	 * 
	 * @param goodsVo
	 */
	void updateGoods(GoodsVo goodsVo);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	void deleteGoods(Integer id);

	List<GoodsVo> loadGoodsByProviderId(GoodsVo vo);




}
