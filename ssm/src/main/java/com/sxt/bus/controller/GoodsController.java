package com.sxt.bus.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.bus.domain.Goods;
import com.sxt.bus.domain.Provider;
import com.sxt.bus.service.GoodsService;
import com.sxt.bus.service.ProviderService;
import com.sxt.bus.utils.DataGridView;
import com.sxt.bus.vo.GoodsVo;
import com.sxt.bus.vo.ProviderVo;

@Controller
@RequestMapping("goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	@Autowired
	private ProviderService providerService;

	@RequestMapping("toGoodsManager")
	public String toGoodsManager() {
		return "bus/goods/goodsManager";
	}

	/**
	 * 跳转到左边的供应商菜单
	 * 
	 * @return
	 */
	@RequestMapping("toGoodsLeft")
	public String toGoodsLeft() {
		return "bus/goods/goodsLeft";
	}

	/**
	 * 跳转到商品右边的商品列表
	 * 
	 */
	@RequestMapping("toGoodsRight")
	public String toGoodsRight() {
		return "bus/goods/goodsRight";
	}

	/**
	 * 查询右侧的商品具体信息
	 */
	@RequestMapping("queryAllGoodss")
	@ResponseBody
	public DataGridView queryAllGoodss(GoodsVo vo) {
		DataGridView dataGridView = this.goodsService.queryAllGoods(vo);
		return dataGridView;
	}

	
	/**
	 * 根据供应商id查询对应的商品的信息
	 */
	@RequestMapping("loadGoodsByProviderId")
	@ResponseBody
	public List<GoodsVo> loadGoodsByProviderId(GoodsVo vo) {
		
		return this.goodsService.loadGoodsByProviderId(vo);
	}
	
	/**
	 * 跳转到添加商品页面
	 */
	@RequestMapping("toGoodsAdd")
	public String toGoodsAdd(Model model) {
		// 先查询出所有的供应商
		ProviderVo vo = new ProviderVo();
		vo.setAvailable(1);
		List<Provider> providers = this.providerService.queryAllProviders(vo);
		model.addAttribute("providers", providers);
		return "bus/goods/goodsAdd";
	}

	/**
	 * 添加
	 */
	@RequestMapping("addGoods")
	@ResponseBody
	public Map<String, Object> addGoods(GoodsVo goodsVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "添加成功";
		try {
			this.goodsService.addGoods(goodsVo);
		} catch (Exception e) {
			msg = "添加失败" + e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}

	/**
	 * 跳转到修改商品页面
	 */
	@RequestMapping("toUpdateGoods")
	public String toUpdateGoods(GoodsVo goodsVo, Model model) {
		// 先查询出所有的供应商
		ProviderVo vo = new ProviderVo();
		vo.setAvailable(1);
		List<Provider> providers = this.providerService.queryAllProviders(vo);
		// 再查询要修改的商品的具体信息
		model.addAttribute("providers", providers);
		Goods goods = this.goodsService.queryGoodsById(goodsVo.getId());
		model.addAttribute("goods", goods);

		return "bus/goods/goodsUpdate";
	}

	/**
	 * 修改商品
	 */
	@RequestMapping("updateGoods")
	@ResponseBody
	public Map<String, Object> updateGoods(GoodsVo goodsVo, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		String msg = "修改成功";
		try {
			// 根据id查询商品的具体信息
			Goods goods = this.goodsService.queryGoodsById(goodsVo.getId());
			//先删除服务器上面之前的图片,然后再添加
			if (null != goods && goods.getGoodsimg() != null && !goods.getGoodsimg().equals("")) {
				String path = session.getServletContext().getRealPath("/");
				File file = new File(path + goods.getGoodsimg());
				if (file.exists()) {
					file.delete();
				}
			}
			// 做修改
			this.goodsService.updateGoods(goodsVo);
		} catch (Exception e) {
			msg = "修改失败" + e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}

	/**
	 * 删除
	 */
	@RequestMapping("deleteGoods")
	@ResponseBody
	public Map<String, Object> deleteGoods(GoodsVo goodsVo, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		String msg = "删除成功";
		try {
			// 根据id查询商品的具体信息
			Goods goods = this.goodsService.queryGoodsById(goodsVo.getId());
			// 先删除服务器上的图片
			if (null != goods && goods.getGoodsimg() != null && !goods.getGoodsimg().equals("")) {
				String path = session.getServletContext().getRealPath("/");
				File file = new File(path + goods.getGoodsimg());
				if (file.exists()) {
					file.delete();
				}
			}
			// 删除
			this.goodsService.deleteGoods(goodsVo.getId());
			;
		} catch (Exception e) {
			e.printStackTrace();
			msg = "删除失败" + e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}

	/**
	 * 批量删除
	 */
	@RequestMapping("batchDeleteGoods")
	@ResponseBody
	public Map<String, Object> batchDeleteGoods(GoodsVo goodsVo, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		String msg = "删除成功";
		try {
			// 删除
			Integer[] ids = goodsVo.getIds();
			if (null != ids && ids.length > 0) {
				for (Integer integer : ids) {
					// 根据id查询车辆信息
					Goods goods = this.goodsService.queryGoodsById(integer);
					if (null != goods && goods.getGoodsimg() != null && !goods.getGoodsimg().equals("")) {
						String path = session.getServletContext().getRealPath("/");
						File file = new File(path + goods.getGoodsimg());
						if (file.exists()) {
							file.delete();
						}
					}
					this.goodsService.deleteGoods(integer);
				}
			}
		} catch (Exception e) {
			msg = "删除失败" + e.getMessage();
		}
		map.put("msg", msg);
		return map;
	}

}
