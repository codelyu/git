package com.sxt.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.bus.domain.Goods;
import com.sxt.bus.domain.Inport;
import com.sxt.bus.mapper.GoodsMapper;
import com.sxt.bus.mapper.InportMapper;
import com.sxt.bus.service.InportService;
import com.sxt.bus.utils.DataGridView;
import com.sxt.bus.vo.InportVo;

@Service
public class InportServiceImpl implements InportService {
	@Autowired
	private InportMapper inportMapper;
	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public DataGridView queryAllInport(InportVo vo) {
		Page<Inport> page = PageHelper.startPage(vo.getPage(), vo.getLimit());
		List<InportVo> inports = this.inportMapper.queryAllInport(vo);
		DataGridView view = new DataGridView(page.getTotal(), inports);
		return view;
	}

	@Override
	public void addInport(InportVo inportVo) {
		this.inportMapper.insertSelective(inportVo);
		// 原来商品的库存需要增加
		Goods goods = this.goodsMapper.selectByPrimaryKey(inportVo.getGoodsid());
		goods.setNumber(goods.getNumber() + inportVo.getNumber());
		this.goodsMapper.updateByPrimaryKeySelective(goods);

	}

	@Override
	public InportVo queryInportById(InportVo vo) {

		return this.inportMapper.selectByPrimaryKey(vo.getId());
	}

	@Override
	public void updateInport(InportVo inportVo) {
		this.inportMapper.updateByPrimaryKeySelective(inportVo);

	}

	@Override
	public void deleteInport(Integer id) {

		this.inportMapper.deleteByPrimaryKey(id);

	}

}
