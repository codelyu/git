package com.sxt.bus.service;

import com.sxt.bus.vo.CustomerVo;
import com.sxt.bus.domain.Customer;
import com.sxt.bus.utils.DataGridView;

public interface CustomerService {
	
	/**
	 * 全查询+模糊查询
	 * @param customervo
	 * @return
	 */

	DataGridView queryAllCustomer(CustomerVo customervo);

	/**
	 * 添加
	 * 
	 * @param customerVo
	 */
	void addCustomer(CustomerVo customerVo);


	/**
	 * 修改
	 * 
	 * @param customerVo
	 */
	void updateCustomer(CustomerVo customerVo);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	void deleteCustomer(Integer id);

	Customer queryCustomerById(Integer id);




}
