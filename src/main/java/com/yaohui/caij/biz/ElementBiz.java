package com.yaohui.caij.biz;

import com.yaohui.caij.constant.PagedResult;
import com.yaohui.caij.constant.Result;
import com.yaohui.caij.controller.request.ElementInsertReqDTO;
import com.yaohui.caij.controller.request.ElementUpdateReqDTO;
import com.yaohui.caij.controller.response.ElementQueryRspDTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface ElementBiz {

    /**
     * 插入记录
     * @param dto
     * @return
     */
    Result insert(ElementInsertReqDTO dto);

    /**
     * 批量插入记录
     * @param dtoList
     * @return
     */
    Result insertBatch(List<ElementInsertReqDTO> dtoList);

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
    Result updateByPrimaryKeySelective(ElementUpdateReqDTO dto);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    Result<ElementQueryRspDTO> selectByPrimaryKey(Integer id);

    /**
     * 根据ID列表查询
     * @param ids
     * @return
     */
    Result<List<ElementQueryRspDTO>> selectByPrimaryKeyList(List<Integer> ids);

    /**
    * 根据参数分页查询
    * @param taskId
    * @param pageNo
    * @param pageSize
    * @param orderByClause
    * @return
    */
    PagedResult<ElementQueryRspDTO> selectByParamsForPage(Integer taskId, int pageNo, int pageSize, String orderByClause);

    /**
    * 根据参数列表查询
    * @param taskId
    * @return
    */
    Result<List<ElementQueryRspDTO>> selectByParamsForList(Integer taskId);
}