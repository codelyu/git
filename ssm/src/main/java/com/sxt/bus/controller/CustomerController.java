package com.sxt.bus.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sxt.bus.domain.Customer;
import com.sxt.bus.service.CustomerService;
import com.sxt.bus.utils.DataGridView;
import com.sxt.bus.vo.CustomerVo;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	

	@RequestMapping("toCustomerManager")
	public String toCustomerManager() {
		return "bus/customer/customerManager";
	}



	/**
	 * 查询客户具体信息
	 */
	@RequestMapping("queryAllCustomers")
	@ResponseBody
	public DataGridView queryAllCustomers(CustomerVo vo) {
		DataGridView dataGridView = this.customerService.queryAllCustomer(vo);
		return dataGridView;
	}
	
	/**
	 * 跳转到添加客户页面
	 */
	@RequestMapping("toCustomerAdd")
	public String toCustomerAdd() {
		return "bus/customer/customerAdd";
	}
	
	
	/**
	 * 添加
	 */
	@RequestMapping("addCustomer")
	@ResponseBody
	public Map<String,Object> addCustomer(CustomerVo customerVo){
		Map<String, Object> map=new HashMap<>();
		String msg="添加成功";
		try {
			this.customerService.addCustomer(customerVo);
		} catch (Exception e) {
			msg="添加失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	
	/**
	 * 跳转到修改客户页面
	 */
	@RequestMapping("toUpdateCustomer")
	public String toUpdateCustomer(CustomerVo customerVo,Model model) {
		Customer customer=this.customerService.queryCustomerById(customerVo.getId());
		model.addAttribute("customer", customer);
		return "bus/customer/customerUpdate";
	}
	
	/**
	 * 修改客户
	 */
	@RequestMapping("updateCustomer")
	@ResponseBody
	public Map<String,Object> updateCustomer(CustomerVo customerVo){
		Map<String, Object> map=new HashMap<>();
		String msg="修改失败";
		try {
			//做修改
			this.customerService.updateCustomer(customerVo);
			msg="修改成功";
		} catch (Exception e) {
			msg=e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	
	/**
	 * 删除
	 */
	@RequestMapping("deleteCustomer")
	@ResponseBody
	public Map<String,Object> deleteCustomer(CustomerVo customerVo){
		Map<String, Object> map=new HashMap<>();
		String msg="删除成功";
		try {
			//做删除
			this.customerService.deleteCustomer(customerVo.getId());
		} catch (Exception e) {
			msg="删除失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	/**
	 * 批量删除
	 */
	@RequestMapping("batchDeleteCustomer")
	@ResponseBody
	public Map<String,Object> batchDeleteCustomer(CustomerVo customerVo){
		Map<String, Object> map=new HashMap<>();
		String msg="删除成功";
		try {
			//删除
			Integer[] ids=customerVo.getIds();
			if(null!=ids&&ids.length>0) {
				for (Integer integer : ids) {
					this.customerService.deleteCustomer(integer);
				}
			}
		} catch (Exception e) {
			msg="删除失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	
}
