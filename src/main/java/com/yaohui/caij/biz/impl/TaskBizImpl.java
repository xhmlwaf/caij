package com.yaohui.caij.biz.impl;

import com.yaohui.caij.biz.TaskBiz;
import com.yaohui.caij.bo.DetailPageConfigBO;
import com.yaohui.caij.bo.PageConfigBO;
import com.yaohui.caij.bo.ParamsElementBO;
import com.yaohui.caij.bo.WebPageConfigBO;
import com.yaohui.caij.cache.WebPageTaskQueue;
import com.yaohui.caij.constant.Constants;
import com.yaohui.caij.constant.ErrorCode;
import com.yaohui.caij.constant.Page;
import com.yaohui.caij.constant.PagedResult;
import com.yaohui.caij.constant.Result;
import com.yaohui.caij.controller.request.TaskInsertReqDTO;
import com.yaohui.caij.controller.request.TaskUpdateReqDTO;
import com.yaohui.caij.controller.response.TaskQueryRspDTO;
import com.yaohui.caij.dao.entity.AssociatePage;
import com.yaohui.caij.dao.entity.Element;
import com.yaohui.caij.dao.entity.Task;
import com.yaohui.caij.enums.WebContentTypeEnum;
import com.yaohui.caij.service.AssociatePageService;
import com.yaohui.caij.service.ElementService;
import com.yaohui.caij.service.TaskService;
import com.yaohui.caij.utils.CaijUtils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    WebPageConfigBO webPageConfigBO = new WebPageConfigBO();
    webPageConfigBO.setTargetUrl(task.getPageUrl());
    webPageConfigBO.setEntityListXpath(task.getListXpath());
    webPageConfigBO.setDynamic(task.getDynamic().intValue() == WebContentTypeEnum.DYNAMIC.getType());

    PageConfigBO pageConfigBO = null;
    if (task.getMultiPage().equals(Constants.MULTI_PAGE)) {
      pageConfigBO = new PageConfigBO();
      pageConfigBO.setNextPageUrl(task.getPageUrlTemplate());
      pageConfigBO.setStartPageNum(task.getStartPage());
      pageConfigBO.setEndPageNum(task.getEndPage());
    }

    Map<String, ParamsElementBO> paramsElementMap = new HashMap<>();
    webPageConfigBO.setParamsRuleMap(paramsElementMap);

    Map<Integer, DetailPageConfigBO> detailPageConfigMap = new HashMap<>();
    List<DetailPageConfigBO> detailPageConfigBOList = new ArrayList<>();
    webPageConfigBO.setDetailPageConfigBOList(detailPageConfigBOList);
    List<AssociatePage> associatePageList = associatePageService.selectByParamsForList(task.getId());
    if (!CollectionUtils.isEmpty(associatePageList)) {
      for (AssociatePage associatePage : associatePageList) {
        DetailPageConfigBO detailPageConfigBO = new DetailPageConfigBO();
        detailPageConfigBO.setAttrName(associatePage.getAttrName());
        detailPageConfigBO.setLocation(associatePage.getLocation());
        detailPageConfigBO.setRegex(associatePage.getRegex());
        detailPageConfigBO.setXpath(associatePage.getXpath());
        detailPageConfigBOList.add(detailPageConfigBO);
        detailPageConfigMap.put(associatePage.getId(), detailPageConfigBO);
      }
    }

    List<Element> elementList = elementService.selectByParamsForList(task.getId());
    if (!CollectionUtils.isEmpty(elementList)) {
      for (Element e : elementList) {
        if (e.getAssociatePageId() == null) {
          paramsElementMap.put(e.getName(), convert(e));
        } else {
          DetailPageConfigBO detailPageConfigBO = detailPageConfigMap.get(e.getAssociatePageId());
          if (detailPageConfigBO != null) {
            Map<String, ParamsElementBO> otherParamsRuleMap = detailPageConfigBO.getOtherParamsRuleMap();
            if (otherParamsRuleMap == null) {
              otherParamsRuleMap = new HashMap<>();
            }
            otherParamsRuleMap.put(e.getName(), convert(e));
            detailPageConfigBO.setOtherParamsRuleMap(otherParamsRuleMap);
          }
        }
      }
    }

    List<WebPageConfigBO> webPageConfigBOS = CaijUtils.listWebPageConfig(webPageConfigBO, pageConfigBO);
    if (!CollectionUtils.isEmpty(webPageConfigBOS)) {
      for (WebPageConfigBO config : webPageConfigBOS) {
        WebPageTaskQueue.put(config);
      }
    }

    return Result.success(null);
  }

  private ParamsElementBO convert(Element e) {
    ParamsElementBO paramsElementBO = new ParamsElementBO();
    paramsElementBO.setAttrName(e.getAttrName());
    paramsElementBO.setLocation(e.getLocation());
    paramsElementBO.setRegex(e.getRegex());
    paramsElementBO.setXpath(e.getXpath());
    return paramsElementBO;
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
