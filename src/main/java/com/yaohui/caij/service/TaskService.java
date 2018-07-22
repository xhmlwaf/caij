package com.yaohui.caij.service;

import com.yaohui.caij.constant.Page;
import com.yaohui.caij.dao.entity.Task;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TaskService {

    /**
     * 插入记录
     * @param record
     * @return
     */
    int insert(Task record);

    /**
     * 批量插入记录
     * @param record
     * @return
     */
    int insertBatch(List<Task> record);

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 根据主键更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Task record);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    Task selectByPrimaryKey(Integer id);

    /**
     * 根据ID列表查询
     * @param ids
     * @return
     */
    List<Task> selectByPrimaryKeyList(List<Integer> ids);

    /**
    * 分页查询
    * @param record
    * @param pageNo
    * @param pageSize
    * @param orderByClause
    * @return
    */
    Page<Task> selectByRecordForPage(Task record, int pageNo, int pageSize, String orderByClause);

    /**
    * 列表查询
    * @param record
    * @return
    */
	List<Task> selectByRecordForList(Task record);

    /**
    * 根据参数分页查询
    * @param name
    * @param dynamic
    * @param multiPage
    * @param startCreatedAt
    * @param endCreatedAt
    * @param pageNo
    * @param pageSize
    * @param orderByClause
    * @return
    */
    Page<Task> selectByParamsForPage(String name, Byte dynamic, Byte multiPage, Date startCreatedAt, Date endCreatedAt, int pageNo, int pageSize, String orderByClause);

    /**
    * 根据参数列表查询
    * @param name
    * @param dynamic
    * @param multiPage
    * @param startCreatedAt
    * @param endCreatedAt
    * @return
    */
    List<Task> selectByParamsForList(String name, Byte dynamic, Byte multiPage, Date startCreatedAt, Date endCreatedAt);

}