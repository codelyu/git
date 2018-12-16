package com.sxt.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.bus.domain.Customer;
import com.sxt.bus.mapper.CustomerMapper;
import com.sxt.bus.service.CustomerService;
import com.sxt.bus.vo.CustomerVo;
import com.sxt.bus.utils.DataGridView;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerMapper customerMapper;


	@Override
	public DataGridView queryAllCustomer(CustomerVo vo) {
		Page<Customer> page = PageHelper.startPage(vo.getPage(), vo.getLimit());
		List<Customer> customers = this.customerMapper.queryAllCustomer(vo);
		DataGridView view = new DataGridView(page.getTotal(), customers);
		return view;
	}

	@Override
	public void addCustomer(CustomerVo customerVo) {
		this.customerMapper.insertSelective(customerVo);

	}


	@Override
	public void updateCustomer(CustomerVo customerVo) {
		this.customerMapper.updateByPrimaryKeySelective(customerVo);

	}

	@Override
	public void deleteCustomer(Integer id) {
		this.customerMapper.deleteByPrimaryKey(id);

	}

	@Override
	public Customer queryCustomerById(Integer id) {
		return this.customerMapper.selectByPrimaryKey(id);
	}




}
