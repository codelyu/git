package com.sxt.bus.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.bus.domain.Provider;
import com.sxt.bus.service.InportService;
import com.sxt.bus.service.ProviderService;
import com.sxt.bus.utils.DataGridView;
import com.sxt.bus.vo.InportVo;
import com.sxt.bus.vo.ProviderVo;

@Controller
@RequestMapping("inport")
public class InportController {

	@Autowired
	private InportService inportService;
	@Autowired
	private ProviderService providerService;

	@RequestMapping("toInportManager")
	public String toInportManager() {
		return "bus/inport/inportManager";
	}

	/**
	 * 跳转到左边的供应商菜单
	 * 
	 * @return
	 */
	@RequestMapping("toInportLeft")
	public String toInportLeft() {
		return "bus/inport/inportLeft";
	}

	/**
	 * 跳转到进货右边的进货列表
	 * 
	 */
	@RequestMapping("toInportRight")
	public String toInportRight() {
		return "bus/inport/inportRight";
	}


	/**
	 * 查询右侧的进货具体信息
	 */
	@RequestMapping("queryAllInports")
	@ResponseBody
	public DataGridView queryAllInports(InportVo vo) {
		DataGridView dataGridView = this.inportService.queryAllInport(vo);
		return dataGridView;
	}
	
	/**
	 * 跳转到添加进货页面
	 */
	@RequestMapping("toInportAdd")
	public String toInportAdd(Model model) {
		//先查询出所有的供应商
		ProviderVo vo =new ProviderVo();
		vo.setAvailable(1);
		List<Provider> providers=this.providerService.queryAllProviders(vo);
		model.addAttribute("providers", providers);
		return "bus/inport/inportAdd";
	}
	
	
	/**
	 * 添加
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("addInport")
	@ResponseBody
	public Map<String,Object> addInport(InportVo inportVo){
		Map<String, Object> map=new HashMap<>();
		String msg="添加成功";
		try {
			inportVo.setInporttime(new Date().toLocaleString());
			this.inportService.addInport(inportVo);
		} catch (Exception e) {
			msg="添加失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	
	/**
	 * 跳转到修改进货页面
	 */
	/**
	 * 跳转到修改页面
	 */
	@RequestMapping("toUpdateInport")
	public String toUpdateInport(InportVo inportVo,Model model) {
		//先查询出所有的供应商
		ProviderVo vo =new ProviderVo();
		vo.setAvailable(1);
		List<Provider> providers=this.providerService.queryAllProviders(vo);
		//再查询要修改的进货的具体信息
		model.addAttribute("providers", providers);
		InportVo inport=this.inportService.queryInportById(inportVo);
		model.addAttribute("inport", inport);
		//再根据进货的id查询到领导的id
		return "bus/inport/inportUpdate";
	}
	
	/**
	 * 修改进货
	 */
	@RequestMapping("updateInport")
	@ResponseBody
	public Map<String,Object> updateInport(InportVo inportVo){
		Map<String, Object> map=new HashMap<>();
		String msg="修改成功";
		try {
			//做修改
			this.inportService.updateInport(inportVo);
		} catch (Exception e) {
			msg="修改失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	
	/**
	 * 删除
	 */
	@RequestMapping("deleteInport")
	@ResponseBody
	public Map<String,Object> deleteInport(InportVo inportVo,HttpSession session){
		Map<String,Object> map=new HashMap<>();
		String msg="删除成功";
		try {
			
			//删除
			this.inportService.deleteInport(inportVo.getId());;
		} catch (Exception e) {
			e.printStackTrace();
			msg="删除失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	/**
	 * 批量删除
	 */
	@RequestMapping("batchDeleteInport")
	@ResponseBody
	public Map<String,Object> batchDeleteInport(InportVo inportVo,HttpSession session){
		Map<String, Object> map=new HashMap<>();
		String msg="删除成功";
		try {
			//删除
			Integer[] ids=inportVo.getIds();
			if(null!=ids&&ids.length>0) {
				for (Integer integer : ids) {
					
					this.inportService.deleteInport(integer);
				}
			}
		} catch (Exception e) {
			msg="删除失败"+e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}
	
	
	
	
}
