package com.sxt.bus.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sxt.bus.domain.Provider;
import com.sxt.bus.service.ProviderService;
import com.sxt.bus.utils.DataGridView;
import com.sxt.bus.utils.ZtreeNode;
import com.sxt.bus.vo.ProviderVo;

@Controller
@RequestMapping("provider")
public class ProviderController {

	@Autowired
	private ProviderService providerService;
	

	@RequestMapping("toProviderManager")
	public String toProviderManager() {
		return "bus/provider/providerManager";
	}



	/**
	 * 查询供应商具体信息
	 */
	@RequestMapping("queryAllProviders")
	@ResponseBody
	public DataGridView queryAllProviders(ProviderVo vo) {
		DataGridView dataGridView = this.providerService.queryAllProvider(vo);
		return dataGridView;
	}
	
	/**
	 * 跳转到添加供应商页面
	 */
	@RequestMapping("toProviderAdd")
	public String toProviderAdd() {
		return "bus/provider/providerAdd";
	}
	
	
	/**
	 * 添加
	 */
	@RequestMapping("addProvider")
	@ResponseBody
	public Map<String,Object> addProvider(ProviderVo providerVo){
		Map<String, Object> map=new HashMap<>();
		String msg="添加成功";
		try {
			this.providerService.addProvider(providerVo);
		} catch (Exception e) {
			msg="添加失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	
	/**
	 * 跳转到修改供应商页面
	 */
	@RequestMapping("toUpdateProvider")
	public String toUpdateProvider(ProviderVo providerVo,Model model) {
		Provider provider=this.providerService.queryProviderById(providerVo.getId());
		model.addAttribute("provider", provider);
		return "bus/provider/providerUpdate";
	}
	
	/**
	 * 修改供应商
	 */
	@RequestMapping("updateProvider")
	@ResponseBody
	public Map<String,Object> updateProvider(ProviderVo providerVo){
		Map<String, Object> map=new HashMap<>();
		String msg="修改失败";
		try {
			//做修改
			this.providerService.updateProvider(providerVo);
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
	@RequestMapping("deleteProvider")
	@ResponseBody
	public Map<String,Object> deleteProvider(ProviderVo providerVo){
		Map<String, Object> map=new HashMap<>();
		String msg="删除成功";
		try {
			//做删除
			this.providerService.deleteProvider(providerVo.getId());
		} catch (Exception e) {
			msg="删除失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	/**
	 * 批量删除
	 */
	@RequestMapping("batchDeleteProvider")
	@ResponseBody
	public Map<String,Object> batchDeleteProvider(ProviderVo providerVo){
		Map<String, Object> map=new HashMap<>();
		String msg="删除成功";
		try {
			//删除
			Integer[] ids=providerVo.getIds();
			if(null!=ids&&ids.length>0) {
				for (Integer integer : ids) {
					this.providerService.deleteProvider(integer);
				}
			}
		} catch (Exception e) {
			msg="删除失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	/**
	 * 加载左侧供应商的树
	 */
	@RequestMapping("loadLeftZtree")
	@ResponseBody
	public List<ZtreeNode> loadLeftZtree(){
		
		return this.providerService.loadLeftZtree();
	}
	
}
