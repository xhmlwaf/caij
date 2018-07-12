package com.yaohui.caij.service;

import com.yaohui.caij.constant.Page;
import com.yaohui.caij.dao.entity.Task;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TaskService {

    /**
     * 插入记录
     *
     * @param record
     * @return
     */
    int insert(Task record);

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
    int updateByPrimaryKeySelective(Task record);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    Task selectByPrimaryKey(Integer id);

    /**
     * 根据ID列表查询
     *
     * @param ids
     * @return
     */
    List<Task> selectByPrimaryKeyList(List<Integer> ids);

    /**
     * 分页查询
     *
     * @param record
     * @param pageNo
     * @param pageSize
     * @param orderByClause
     * @return
     */
    Page<Task> selectByRecordForPage(Task record, int pageNo, int pageSize, String orderByClause);

    /**
     * 列表查询
     *
     * @param record
     * @return
     */
    List<Task> selectByRecordForList(Task record);

    /**
     * 根据参数分页查询
     *
     * @param id
     * @param name
     * @param isDynamic
     * @param startCreatedAt
     * @param endCreatedAt
     * @param status
     * @param pageNo
     * @param pageSize
     * @param orderByClause
     * @return
     */
    Page<Task> selectByParamsForPage(Integer id, String name, Byte isDynamic, Date startCreatedAt, Date endCreatedAt, Byte status, int pageNo, int pageSize, String orderByClause);

    /**
     * 根据参数列表查询
     *
     * @param id
     * @param name
     * @param isDynamic
     * @param startCreatedAt
     * @param endCreatedAt
     * @param status
     * @return
     */
    List<Task> selectByParamsForList(Integer id, String name, Byte isDynamic, Date startCreatedAt, Date endCreatedAt, Byte status);

}