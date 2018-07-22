package com.yaohui.caij.biz;

import com.yaohui.caij.constant.PagedResult;
import com.yaohui.caij.constant.Result;
import com.yaohui.caij.controller.request.TaskInsertReqDTO;
import com.yaohui.caij.controller.request.TaskUpdateReqDTO;
import com.yaohui.caij.controller.response.TaskQueryRspDTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TaskBiz {

    /**
     * 插入记录
     * @param dto
     * @return
     */
    Result insert(TaskInsertReqDTO dto);

    /**
     * 批量插入记录
     * @param dtoList
     * @return
     */
    Result insertBatch(List<TaskInsertReqDTO> dtoList);

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    Result deleteByPrimaryKey(Integer id);

    /**
     * 根据主键更新
     * @param dto
     * @return
     */
    Result updateByPrimaryKeySelective(TaskUpdateReqDTO dto);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    Result<TaskQueryRspDTO> selectByPrimaryKey(Integer id);

    /**
     * 根据ID列表查询
     * @param ids
     * @return
     */
    Result<List<TaskQueryRspDTO>> selectByPrimaryKeyList(List<Integer> ids);

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
    PagedResult<TaskQueryRspDTO> selectByParamsForPage(String name, Byte dynamic, Byte multiPage, Date startCreatedAt, Date endCreatedAt, int pageNo, int pageSize, String orderByClause);

    /**
    * 根据参数列表查询
    * @param name
    * @param dynamic
    * @param multiPage
    * @param startCreatedAt
    * @param endCreatedAt
    * @return
    */
    Result<List<TaskQueryRspDTO>> selectByParamsForList(String name, Byte dynamic, Byte multiPage, Date startCreatedAt, Date endCreatedAt);

    /**
     * 开启任务
     * @param id
     * @return
     */
    Result startTask(Integer id);
}