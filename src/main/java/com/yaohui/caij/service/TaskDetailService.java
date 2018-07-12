package com.yaohui.caij.service;

import com.yaohui.caij.constant.Page;
import com.yaohui.caij.dao.entity.TaskDetail;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TaskDetailService {

    /**
     * 插入记录
     *
     * @param record
     * @return
     */
    int insert(TaskDetail record);

    /**
     * 根据主键删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 根据主键更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(TaskDetail record);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    TaskDetail selectByPrimaryKey(Integer id);

    /**
     * 根据ID列表查询
     *
     * @param ids
     * @return
     */
    List<TaskDetail> selectByPrimaryKeyList(List<Integer> ids);

    /**
     * 分页查询
     *
     * @param record
     * @param pageNo
     * @param pageSize
     * @param orderByClause
     * @return
     */
    Page<TaskDetail> selectByRecordForPage(TaskDetail record, int pageNo, int pageSize, String orderByClause);

    /**
     * 列表查询
     *
     * @param record
     * @return
     */
    List<TaskDetail> selectByRecordForList(TaskDetail record);

    /**
     * 根据参数分页查询
     *
     * @param id
     * @param taskId
     * @param pageNo
     * @param pageSize
     * @param orderByClause
     * @return
     */
    Page<TaskDetail> selectByParamsForPage(Integer id, Integer taskId, int pageNo, int pageSize, String orderByClause);

    /**
     * 根据参数列表查询
     *
     * @param id
     * @param taskId
     * @return
     */
    List<TaskDetail> selectByParamsForList(Integer id, Integer taskId);

}