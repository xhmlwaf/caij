package com.yaohui.caij.biz.impl;

import com.yaohui.caij.biz.ElementBiz;
import com.yaohui.caij.constant.Page;
import com.yaohui.caij.constant.PagedResult;
import com.yaohui.caij.constant.Result;
import com.yaohui.caij.controller.request.ElementInsertReqDTO;
import com.yaohui.caij.controller.request.ElementUpdateReqDTO;
import com.yaohui.caij.controller.response.ElementQueryRspDTO;
import com.yaohui.caij.dao.entity.AssociatePage;
import com.yaohui.caij.dao.entity.Element;
import com.yaohui.caij.service.AssociatePageService;
import com.yaohui.caij.service.ElementService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ElementBizImpl implements ElementBiz {

    @Autowired
    private ElementService elementService;

    @Autowired
    private AssociatePageService associatePageService;

    @Override
    public Result insert(ElementInsertReqDTO dto) {
        Element element = elementInsertReqDTO2DO(dto);
        elementService.insert(element);
        return Result.success(null);
    }

    @Override
    public Result insertBatch(List<ElementInsertReqDTO> dtoList) {
        List<Element> elementList;
        if (CollectionUtils.isEmpty(dtoList)) {
            return Result.success(null);
        }
        elementList = dtoList.stream().map(this::elementInsertReqDTO2DO).collect(Collectors.toList());

        elementService.insertBatch(elementList);
        return Result.success(null);
    }

    @Override
    public Result deleteByPrimaryKey(Integer id) {
        elementService.deleteByPrimaryKey(id);
        return Result.success(null);
    }

    @Override
    public Result updateByPrimaryKeySelective(ElementUpdateReqDTO dto) {
        Element element = elementUpdateReqDTO2DO(dto);
        elementService.updateByPrimaryKeySelective(element);
        return Result.success(null);
    }

    @Override
    public Result<ElementQueryRspDTO> selectByPrimaryKey(Integer id) {
    Element element = elementService.selectByPrimaryKey(id);
    ElementQueryRspDTO dto = do2ElementQueryRspDTO(element);
    return Result.success(dto);
    }

    @Override
    public Result<List<ElementQueryRspDTO>> selectByPrimaryKeyList(List<Integer> ids) {
        List<Element> elementList = elementService.selectByPrimaryKeyList(ids);
        List<ElementQueryRspDTO> dtoList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(elementList)) {
            for (Element e : elementList) {
                ElementQueryRspDTO dto = do2ElementQueryRspDTO(e);
                dtoList.add(dto);
            }
        }
        return Result.success(dtoList);
    }

    @Override
    public PagedResult<ElementQueryRspDTO> selectByParamsForPage(Integer taskId, int pageNo, int pageSize, String orderByClause) {
        Page<Element> elementPage = elementService.selectByParamsForPage(taskId,pageNo, pageSize, orderByClause);
        List<Element> elementList = elementPage.getResult();
        List<ElementQueryRspDTO> dtoList = new ArrayList<>();

        List<Integer> associatePageIds = new ArrayList<>();
        if (!CollectionUtils.isEmpty(elementList)) {
            for (Element e : elementList) {
                ElementQueryRspDTO dto = do2ElementQueryRspDTO(e);
                dtoList.add(dto);
                associatePageIds.add(e.getAssociatePageId());
            }
        }

        if (!CollectionUtils.isEmpty(associatePageIds)) {
            Map<Integer, String> associatePageMap = new HashMap<>();
            List<AssociatePage> associatePages = associatePageService.selectByPrimaryKeyList(associatePageIds);
            if (!CollectionUtils.isEmpty(associatePages)) {
                for (AssociatePage associatePage : associatePages) {
                    associatePageMap.put(associatePage.getId(), associatePage.getName());
                }
            }
            if (!CollectionUtils.isEmpty(dtoList)) {
                for (ElementQueryRspDTO dto : dtoList) {
                    dto.setAssociatePageName(associatePageMap.get(dto.getAssociatePageId()));
                }
            }
        }

        Page<ElementQueryRspDTO> page = new Page<>();
        page.setTotalCount(elementPage.getTotalCount());
        page.setResult(dtoList);
        page.setPageSize(pageSize);
        page.setPageNo(pageNo);
        page.setTotalPages(elementPage.getTotalPages());
        return PagedResult.success(page);
    }

    @Override
    public Result<List<ElementQueryRspDTO>> selectByParamsForList(Integer taskId) {
        List<Element> elementList = elementService.selectByParamsForList(taskId);
        List<ElementQueryRspDTO> dtoList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(elementList)) {
            for (Element e : elementList) {
                ElementQueryRspDTO dto = do2ElementQueryRspDTO(e);
                dtoList.add(dto);
             }
        }
        return Result.success(dtoList);
    }

    private Element elementInsertReqDTO2DO(ElementInsertReqDTO dto) {
        Element entity = new Element();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    private Element elementUpdateReqDTO2DO(ElementUpdateReqDTO dto) {
        Element entity = new Element();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    private ElementQueryRspDTO do2ElementQueryRspDTO(Element element) {
        ElementQueryRspDTO dto = new ElementQueryRspDTO();
        BeanUtils.copyProperties(element, dto);
        return dto;
    }
}
