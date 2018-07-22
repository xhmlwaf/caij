package com.yaohui.caij.service;

import com.yaohui.caij.constant.Page;
import com.yaohui.caij.dao.entity.Element;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface ElementService {

    /**
     * 插入记录
     * @param record
     * @return
     */
    int insert(Element record);

    /**
     * 批量插入记录
     * @param record
     * @return
     */
    int insertBatch(List<Element> record);

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
    int updateByPrimaryKeySelective(Element record);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    Element selectByPrimaryKey(Integer id);

    /**
     * 根据ID列表查询
     * @param ids
     * @return
     */
    List<Element> selectByPrimaryKeyList(List<Integer> ids);

    /**
    * 分页查询
    * @param record
    * @param pageNo
    * @param pageSize
    * @param orderByClause
    * @return
    */
    Page<Element> selectByRecordForPage(Element record, int pageNo, int pageSize, String orderByClause);

    /**
    * 列表查询
    * @param record
    * @return
    */
	List<Element> selectByRecordForList(Element record);

    /**
    * 根据参数分页查询
    * @param taskId
    * @param pageNo
    * @param pageSize
    * @param orderByClause
    * @return
    */
    Page<Element> selectByParamsForPage(Integer taskId, int pageNo, int pageSize, String orderByClause);

    /**
    * 根据参数列表查询
    * @param taskId
    * @return
    */
    List<Element> selectByParamsForList(Integer taskId);

}