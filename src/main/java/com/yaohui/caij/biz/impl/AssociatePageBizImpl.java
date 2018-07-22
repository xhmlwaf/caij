package com.yaohui.caij.biz.impl;

import com.yaohui.caij.biz.AssociatePageBiz;
import com.yaohui.caij.constant.Page;
import com.yaohui.caij.constant.PagedResult;
import com.yaohui.caij.constant.Result;
import com.yaohui.caij.controller.request.AssociatePageInsertReqDTO;
import com.yaohui.caij.controller.request.AssociatePageUpdateReqDTO;
import com.yaohui.caij.controller.response.AssociatePageQueryRspDTO;
import com.yaohui.caij.dao.entity.AssociatePage;
import com.yaohui.caij.service.AssociatePageService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AssociatePageBizImpl implements AssociatePageBiz {

    @Autowired
    private AssociatePageService associatePageService;

    @Override
    public Result insert(AssociatePageInsertReqDTO dto) {
        AssociatePage associatePage = associatePageInsertReqDTO2DO(dto);
        associatePageService.insert(associatePage);
        return Result.success(null);
    }

    @Override
    public Result insertBatch(List<AssociatePageInsertReqDTO> dtoList) {
        List<AssociatePage> associatePageList = new ArrayList<>();
        if (CollectionUtils.isEmpty(dtoList)) {
            return Result.success(null);
        }
        for (int i = 0; i < dtoList.size(); i++){
            AssociatePage associatePage = associatePageInsertReqDTO2DO(dtoList.get(i));
            associatePageList.add(associatePage);
        }

        associatePageService.insertBatch(associatePageList);
        return Result.success(null);
    }

    @Override
    public Result deleteByPrimaryKey(Integer id) {
        associatePageService.deleteByPrimaryKey(id);
        return Result.success(null);
    }

    @Override
    public Result updateByPrimaryKeySelective(AssociatePageUpdateReqDTO dto) {
        AssociatePage associatePage = associatePageUpdateReqDTO2DO(dto);
        associatePageService.updateByPrimaryKeySelective(associatePage);
        return Result.success(null);
    }

    @Override
    public Result<AssociatePageQueryRspDTO> selectByPrimaryKey(Integer id) {
    AssociatePage associatePage = associatePageService.selectByPrimaryKey(id);
    AssociatePageQueryRspDTO dto = do2AssociatePageQueryRspDTO(associatePage);
    return Result.success(dto);
    }

    @Override
    public Result<List<AssociatePageQueryRspDTO>> selectByPrimaryKeyList(List<Integer> ids) {
        List<AssociatePage> associatePageList = associatePageService.selectByPrimaryKeyList(ids);
        List<AssociatePageQueryRspDTO> dtoList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(associatePageList)) {
            for (AssociatePage e : associatePageList) {
                AssociatePageQueryRspDTO dto = do2AssociatePageQueryRspDTO(e);
                dtoList.add(dto);
            }
        }
        return Result.success(dtoList);
    }

    @Override
    public PagedResult<AssociatePageQueryRspDTO> selectByParamsForPage(Integer taskId, int pageNo, int pageSize, String orderByClause) {
        Page<AssociatePage> associatePagePage = associatePageService.selectByParamsForPage(taskId, pageNo, pageSize, orderByClause);
        List<AssociatePage> associatePageList = associatePagePage.getResult();
        List<AssociatePageQueryRspDTO> dtoList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(associatePageList)) {
            for (AssociatePage e : associatePageList) {
                AssociatePageQueryRspDTO dto = do2AssociatePageQueryRspDTO(e);
                dtoList.add(dto);
            }
        }
        Page<AssociatePageQueryRspDTO> page = new Page<>();
        page.setTotalCount(associatePagePage.getTotalCount());
        page.setResult(dtoList);
        page.setPageSize(pageSize);
        page.setPageNo(pageNo);
        page.setTotalPages(associatePagePage.getTotalPages());
        return PagedResult.success(page);
    }

    @Override
    public Result<List<AssociatePageQueryRspDTO>> selectByParamsForList(Integer taskId) {
        List<AssociatePage> associatePageList = associatePageService.selectByParamsForList(taskId);
        List<AssociatePageQueryRspDTO> dtoList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(associatePageList)) {
            for (AssociatePage e : associatePageList) {
                AssociatePageQueryRspDTO dto = do2AssociatePageQueryRspDTO(e);
                dtoList.add(dto);
             }
        }
        return Result.success(dtoList);
    }

    private AssociatePage associatePageInsertReqDTO2DO(AssociatePageInsertReqDTO dto) {
        AssociatePage entity = new AssociatePage();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    private AssociatePage associatePageUpdateReqDTO2DO(AssociatePageUpdateReqDTO dto) {
        AssociatePage entity = new AssociatePage();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    private AssociatePageQueryRspDTO do2AssociatePageQueryRspDTO(AssociatePage associatePage) {
        AssociatePageQueryRspDTO dto = new AssociatePageQueryRspDTO();
        BeanUtils.copyProperties(associatePage, dto);
        return dto;
    }
}
