package com.sxt.bus.service;

import com.sxt.bus.vo.ProviderVo;

import java.util.List;

import com.sxt.bus.domain.Provider;
import com.sxt.bus.utils.DataGridView;
import com.sxt.bus.utils.ZtreeNode;

public interface ProviderService {
	
	/**
	 * 全查询+模糊查询
	 * @param providervo
	 * @return
	 */

	DataGridView queryAllProvider(ProviderVo providervo);

	/**
	 * 添加
	 * 
	 * @param providerVo
	 */
	void addProvider(ProviderVo providerVo);


	/**
	 * 修改
	 * 
	 * @param providerVo
	 */
	void updateProvider(ProviderVo providerVo);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	void deleteProvider(Integer id);

	Provider queryProviderById(Integer id);
	/**
	 * 加载供应商树
	 * @return
	 */

	List<ZtreeNode> loadLeftZtree();
	/**
	 * 全查询
	 * @param vo
	 */

	List<Provider> queryAllProviders(ProviderVo vo);





}
