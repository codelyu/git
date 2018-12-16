package com.sxt.bus.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.bus.domain.Provider;
import com.sxt.bus.mapper.ProviderMapper;
import com.sxt.bus.service.ProviderService;
import com.sxt.bus.vo.ProviderVo;
import com.sxt.bus.utils.DataGridView;
import com.sxt.bus.utils.ZtreeNode;

@Service
public class ProviderServiceImpl implements ProviderService {
	@Autowired
	private ProviderMapper providerMapper;


	@Override
	public DataGridView queryAllProvider(ProviderVo vo) {
		Page<Provider> page = PageHelper.startPage(vo.getPage(), vo.getLimit());
		List<Provider> providers = this.providerMapper.queryAllProvider(vo);
		DataGridView view = new DataGridView(page.getTotal(), providers);
		return view;
	}

	@Override
	public void addProvider(ProviderVo providerVo) {
		this.providerMapper.insertSelective(providerVo);

	}


	@Override
	public void updateProvider(ProviderVo providerVo) {
		this.providerMapper.updateByPrimaryKeySelective(providerVo);

	}

	@Override
	public void deleteProvider(Integer id) {
		this.providerMapper.deleteByPrimaryKey(id);

	}

	@Override
	public Provider queryProviderById(Integer id) {
		return this.providerMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ZtreeNode> loadLeftZtree() {
		List<ZtreeNode> nodes  =  new  ArrayList<>();
		//这是供应商树头
		ZtreeNode nodeHead = new ZtreeNode(0, 0, "所有供应商", true, true);
		nodes.add(nodeHead);
		Provider provider  = new Provider();
		provider.setAvailable(1);
		//查询所有的供应商
		List<Provider> providers = this.providerMapper.queryAllProvider(provider);
		for (Provider pro : providers) {
			ZtreeNode node = new ZtreeNode(pro.getId(), 0, pro.getProvidername(), false, false);
			nodes.add(node);
		}
		return nodes;
	}

	@Override
	public List<Provider> queryAllProviders(ProviderVo vo) {
		
		return this.providerMapper.queryAllProvider(vo);
	}




}
