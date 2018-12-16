package com.sxt.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.bus.domain.Goods;
import com.sxt.bus.mapper.GoodsMapper;
import com.sxt.bus.service.GoodsService;
import com.sxt.bus.utils.DataGridView;
import com.sxt.bus.vo.GoodsVo;

@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;


	@Override
	public DataGridView queryAllGoods(GoodsVo vo) {
		Page<Goods> page = PageHelper.startPage(vo.getPage(), vo.getLimit());
		List<GoodsVo> goodss = this.goodsMapper.queryAllGoods(vo);
		DataGridView view = new DataGridView(page.getTotal(), goodss);
		return view;
	}

	@Override
	public void addGoods(GoodsVo goodsVo) {
		this.goodsMapper.insertSelective(goodsVo);

	}

	@Override
	public Goods queryGoodsById(Integer id) {

		return this.goodsMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateGoods(GoodsVo goodsVo) {
		this.goodsMapper.updateByPrimaryKeySelective(goodsVo);

	}

	@Override
	public void deleteGoods(Integer id) {
		// 先删除sys_role_goods里面商品的信息
		this.goodsMapper.deleteByPrimaryKey(id);

	}

	@Override
	public List<GoodsVo> loadGoodsByProviderId(GoodsVo vo) {
		
		return this.goodsMapper.queryAllGoods(vo);
	}





}
