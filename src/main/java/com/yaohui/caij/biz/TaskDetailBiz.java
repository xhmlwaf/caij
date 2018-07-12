package com.yaohui.caij.biz;

import com.yaohui.caij.constant.PagedResult;
import com.yaohui.caij.constant.Result;
import com.yaohui.caij.controller.request.TaskDetailInsertReqDTO;
import com.yaohui.caij.controller.request.TaskDetailUpdateReqDTO;
import com.yaohui.caij.controller.response.TaskDetailQueryRspDTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TaskDetailBiz {

    /**
     * 插入记录
     * @param dto
     * @return
     */
    Result insert(TaskDetailInsertReqDTO dto);

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
    Result updateByPrimaryKeySelective(TaskDetailUpdateReqDTO dto);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    Result<TaskDetailQueryRspDTO> selectByPrimaryKey(Integer id);

    /**
     * 根据ID列表查询
     * @param ids
     * @return
     */
    Result<List<TaskDetailQueryRspDTO>> selectByPrimaryKeyList(List<Integer> ids);

    /**
    * 根据参数分页查询
    * @param id
    * @param taskId
    * @param pageNo
    * @param pageSize
    * @param orderByClause
    * @return
    */
    PagedResult<TaskDetailQueryRspDTO> selectByParamsForPage(Integer id, Integer taskId , int pageNo, int pageSize, String orderByClause);

    /**
    * 根据参数列表查询
    * @param id
    * @param taskId
    * @return
    */
    Result<List<TaskDetailQueryRspDTO>> selectByParamsForList(Integer id, Integer taskId );
}