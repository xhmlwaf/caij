package com.yaohui.caij.dao;

import com.yaohui.caij.dao.entity.TaskDetail;
import java.util.List;
import tk.mybatis.mapper.common.Mapper;

public interface TaskDetailMapper extends Mapper<TaskDetail> {
    int insertBatchSelective(List<TaskDetail> records);

    int updateBatchByPrimaryKeySelective(List<TaskDetail> records);
}