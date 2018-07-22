package com.yaohui.caij.dao;

import com.yaohui.caij.dao.entity.Element;
import java.util.List;
import tk.mybatis.mapper.common.Mapper;

public interface ElementMapper extends Mapper<Element> {
    int insertBatchSelective(List<Element> records);

    int updateBatchByPrimaryKeySelective(List<Element> records);
}