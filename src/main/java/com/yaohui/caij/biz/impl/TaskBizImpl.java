package com.yaohui.caij.biz.impl;

import com.yaohui.caij.biz.TaskBiz;
import com.yaohui.caij.cache.WebPageTaskQueue;
import com.yaohui.caij.constant.*;
import com.yaohui.caij.constant.model.DetailPageConfig;
import com.yaohui.caij.constant.model.PageConfig;
import com.yaohui.caij.constant.model.ParamsElement;
import com.yaohui.caij.constant.model.WebPageConfig;
import com.yaohui.caij.controller.request.TaskInsertReqDTO;
import com.yaohui.caij.controller.request.TaskUpdateReqDTO;
import com.yaohui.caij.controller.response.TaskQueryRspDTO;
import com.yaohui.caij.dao.entity.AssociatePage;
import com.yaohui.caij.dao.entity.Element;
import com.yaohui.caij.dao.entity.Task;
import com.yaohui.caij.enums.WebContentType;
import com.yaohui.caij.service.AssociatePageService;
import com.yaohui.caij.service.ElementService;
import com.yaohui.caij.service.TaskService;

import com.yaohui.caij.utils.CaijUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TaskBizImpl implements TaskBiz {

    @Autowired
    private TaskService taskService;

    @Autowired
    private ElementService elementService;

    @Autowired
    private AssociatePageService associatePageService;

    @Override
    public Result insert(TaskInsertReqDTO dto) {
        Task task = taskInsertReqDTO2DO(dto);
        taskService.insert(task);
        return Result.success(null);
    }

    @Override
    public Result insertBatch(List<TaskInsertReqDTO> dtoList) {
        List<Task> taskList;
        if (CollectionUtils.isEmpty(dtoList)) {
            return Result.success(null);
        }
        taskList = dtoList.stream().map(this::taskInsertReqDTO2DO).collect(Collectors.toList());

        taskService.insertBatch(taskList);
        return Result.success(null);
    }

    @Override
    public Result deleteByPrimaryKey(Integer id) {
        taskService.deleteByPrimaryKey(id);
        return Result.success(null);
    }

    @Override
    public Result updateByPrimaryKeySelective(TaskUpdateReqDTO dto) {
        Task task = taskUpdateReqDTO2DO(dto);
        taskService.updateByPrimaryKeySelective(task);
        return Result.success(null);
    }

    @Override
    public Result<TaskQueryRspDTO> selectByPrimaryKey(Integer id) {
        Task task = taskService.selectByPrimaryKey(id);
        TaskQueryRspDTO dto = do2TaskQueryRspDTO(task);
        return Result.success(dto);
    }

    @Override
    public Result<List<TaskQueryRspDTO>> selectByPrimaryKeyList(List<Integer> ids) {
        List<Task> taskList = taskService.selectByPrimaryKeyList(ids);
        List<TaskQueryRspDTO> dtoList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(taskList)) {
            for (Task e : taskList) {
                TaskQueryRspDTO dto = do2TaskQueryRspDTO(e);
                dtoList.add(dto);
            }
        }
        return Result.success(dtoList);
    }

    @Override
    public PagedResult<TaskQueryRspDTO> selectByParamsForPage(String name, Byte dynamic, Byte multiPage, Date startCreatedAt, Date endCreatedAt, int pageNo, int pageSize, String orderByClause) {
        Page<Task> taskPage = taskService.selectByParamsForPage(name, dynamic, multiPage, startCreatedAt, endCreatedAt, pageNo, pageSize, orderByClause);
        List<Task> taskList = taskPage.getResult();
        List<TaskQueryRspDTO> dtoList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(taskList)) {
            for (Task e : taskList) {
                TaskQueryRspDTO dto = do2TaskQueryRspDTO(e);
                dtoList.add(dto);
            }
        }
        Page<TaskQueryRspDTO> page = new Page<>();
        page.setTotalCount(taskPage.getTotalCount());
        page.setResult(dtoList);
        page.setPageSize(pageSize);
        page.setPageNo(pageNo);
        page.setTotalPages(taskPage.getTotalPages());
        return PagedResult.success(page);
    }

    @Override
    public Result<List<TaskQueryRspDTO>> selectByParamsForList(String name, Byte dynamic, Byte multiPage, Date startCreatedAt, Date endCreatedAt) {
        List<Task> taskList = taskService.selectByParamsForList(name, dynamic, multiPage, startCreatedAt, endCreatedAt);
        List<TaskQueryRspDTO> dtoList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(taskList)) {
            for (Task e : taskList) {
                TaskQueryRspDTO dto = do2TaskQueryRspDTO(e);
                dtoList.add(dto);
            }
        }
        return Result.success(dtoList);
    }

    @Override
    public Result startTask(Integer id) {

        Task task = taskService.selectByPrimaryKey(id);
        if (task == null) {
            return Result.success(ErrorCode.TASK_NOT_EXSIT);
        }
        WebPageConfig webPageConfig = new WebPageConfig();
        webPageConfig.setTargetUrl(task.getPageUrl());
        webPageConfig.setEntityListXpath(task.getListXpath());
        webPageConfig.setDynamic(task.getDynamic().intValue() == WebContentType.DYNAMIC.getType());

        PageConfig pageConfig = null;
        if (task.getMultiPage().equals(Constants.MULTI_PAGE)) {
            pageConfig = new PageConfig();
            pageConfig.setNextPageUrl(task.getPageUrlTemplate());
            pageConfig.setStartPageNum(task.getStartPage());
            pageConfig.setEndPageNum(task.getEndPage());
        }

        Map<String, ParamsElement> paramsElementMap = new HashMap<>();
        webPageConfig.setParamsRuleMap(paramsElementMap);

        Map<Integer, DetailPageConfig> detailPageConfigMap = new HashMap<>();
        List<DetailPageConfig> detailPageConfigList = new ArrayList<>();
        webPageConfig.setDetailPageConfigList(detailPageConfigList);
        List<AssociatePage> associatePageList = associatePageService.selectByParamsForList(task.getId());
        if (!CollectionUtils.isEmpty(associatePageList)) {
            for (AssociatePage associatePage : associatePageList) {
                DetailPageConfig detailPageConfig = new DetailPageConfig();
                detailPageConfig.setAttrName(associatePage.getAttrName());
                detailPageConfig.setLocation(associatePage.getLocation());
                detailPageConfig.setRegex(associatePage.getRegex());
                detailPageConfig.setXpath(associatePage.getXpath());
                detailPageConfigList.add(detailPageConfig);
                detailPageConfigMap.put(associatePage.getId(), detailPageConfig);
            }
        }

        List<Element> elementList = elementService.selectByParamsForList(task.getId());
        if (!CollectionUtils.isEmpty(elementList)) {
            for (Element e : elementList) {
                if (e.getAssociatePageId() == null) {
                    paramsElementMap.put(e.getName(), convert(e));
                } else {
                    DetailPageConfig detailPageConfig = detailPageConfigMap.get(e.getAssociatePageId());
                    if (detailPageConfig != null) {
                        Map<String, ParamsElement> paramsElementMap1 = detailPageConfig.getOtherParamsRuleMap();
                        if (paramsElementMap1 == null) {
                            paramsElementMap1 = new HashMap<>();
                        }
                        paramsElementMap1.put(e.getName(), convert(e));
                    }


                }
            }
        }

        List<WebPageConfig> webPageConfigs = CaijUtils.listWebPageConfig(webPageConfig, pageConfig);
        if (!CollectionUtils.isEmpty(webPageConfigs)) {
            for (WebPageConfig config : webPageConfigs) {
                WebPageTaskQueue.put(config);
            }
        }

        return Result.success(null);
    }

    private ParamsElement convert(Element e) {
        ParamsElement paramsElement = new ParamsElement();
        paramsElement.setAttrName(e.getAttrName());
        paramsElement.setLocation(e.getLocation());
        paramsElement.setRegex(e.getRegex());
        paramsElement.setXpath(e.getXpath());
        return paramsElement;
    }

    private Task taskInsertReqDTO2DO(TaskInsertReqDTO dto) {
        Task entity = new Task();
        BeanUtils.copyProperties(dto, entity);
        entity.setCreatedAt(new Date());
        return entity;
    }

    private Task taskUpdateReqDTO2DO(TaskUpdateReqDTO dto) {
        Task entity = new Task();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    private TaskQueryRspDTO do2TaskQueryRspDTO(Task task) {
        TaskQueryRspDTO dto = new TaskQueryRspDTO();
        BeanUtils.copyProperties(task, dto);
        return dto;
    }
}
