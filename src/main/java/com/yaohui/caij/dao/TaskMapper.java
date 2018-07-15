package com.yaohui.caij.dao;

import com.yaohui.caij.dao.entity.Task;
import java.util.List;
import tk.mybatis.mapper.common.Mapper;

public interface TaskMapper extends Mapper<Task> {
    int insertBatchSelective(List<Task> records);

    int updateBatchByPrimaryKeySelective(List<Task> records);
}