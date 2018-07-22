package com.yaohui.caij.dao;

import com.yaohui.caij.dao.entity.AssociatePage;
import java.util.List;
import tk.mybatis.mapper.common.Mapper;

public interface AssociatePageMapper extends Mapper<AssociatePage> {
    int insertBatchSelective(List<AssociatePage> records);

    int updateBatchByPrimaryKeySelective(List<AssociatePage> records);
}