package com.sxt.sys.mapper;

import java.util.List;

import com.sxt.sys.domain.Dept;

public interface DeptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
    /**
     * 全查询+条件查询
     */
    List<Dept>queryAllDept(Dept record);
}