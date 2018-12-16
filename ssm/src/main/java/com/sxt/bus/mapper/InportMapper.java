package com.sxt.bus.mapper;

import java.util.List;

import com.sxt.bus.domain.Inport;
import com.sxt.bus.vo.InportVo;

public interface InportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Inport record);

    int insertSelective(Inport record);

    InportVo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Inport record);

    int updateByPrimaryKey(Inport record);
    /**
     * 全查询
     * @param vo
     * @return
     */
	List<InportVo> queryAllInport(Inport vo);
}