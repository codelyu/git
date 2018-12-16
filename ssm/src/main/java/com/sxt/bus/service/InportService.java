package com.sxt.bus.service;

import com.sxt.bus.utils.DataGridView;
import com.sxt.bus.vo.InportVo;

public interface InportService {
	/**
	 * 全查询
	 * @param inportvo
	 * @return
	 */

	DataGridView queryAllInport(InportVo inportvo);

	/**
	 * 添加
	 * 
	 * @param inportVo
	 */
	void addInport(InportVo inportVo);

	/**
	 * 
	 * @param id
	 *            要查询的商品的id
	 * @return
	 */
	InportVo queryInportById(InportVo Vo);

	/**
	 * 修改
	 * 
	 * @param inportVo
	 */
	void updateInport(InportVo inportVo);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	void deleteInport(Integer id);




}
