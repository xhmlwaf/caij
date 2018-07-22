package com.yaohui.caij.biz;

import com.yaohui.caij.constant.PagedResult;
import com.yaohui.caij.constant.Result;
import com.yaohui.caij.controller.request.AssociatePageInsertReqDTO;
import com.yaohui.caij.controller.request.AssociatePageUpdateReqDTO;
import com.yaohui.caij.controller.response.AssociatePageQueryRspDTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface AssociatePageBiz {

    /**
     * 插入记录
     * @param dto
     * @return
     */
    Result insert(AssociatePageInsertReqDTO dto);

    /**
     * 批量插入记录
     * @param dtoList
     * @return
     */
    Result insertBatch(List<AssociatePageInsertReqDTO> dtoList);

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
    Result updateByPrimaryKeySelective(AssociatePageUpdateReqDTO dto);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    Result<AssociatePageQueryRspDTO> selectByPrimaryKey(Integer id);

    /**
     * 根据ID列表查询
     * @param ids
     * @return
     */
    Result<List<AssociatePageQueryRspDTO>> selectByPrimaryKeyList(List<Integer> ids);

    /**
    * 根据参数分页查询
    * @param taskId
    * @param pageNo
    * @param pageSize
    * @param orderByClause
    * @return
    */
    PagedResult<AssociatePageQueryRspDTO> selectByParamsForPage(Integer taskId, int pageNo, int pageSize, String orderByClause);

    /**
    * 根据参数列表查询
    * @param taskId
    * @return
    */
    Result<List<AssociatePageQueryRspDTO>> selectByParamsForList(Integer taskId);
}