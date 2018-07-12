package com.yaohui.caij.biz.impl;

import com.yaohui.caij.biz.TaskBiz;
import com.yaohui.caij.constant.Page;
import com.yaohui.caij.constant.PagedResult;
import com.yaohui.caij.constant.Result;
import com.yaohui.caij.controller.request.TaskInsertReqDTO;
import com.yaohui.caij.controller.request.TaskUpdateReqDTO;
import com.yaohui.caij.controller.response.TaskQueryRspDTO;
import com.yaohui.caij.dao.entity.Task;
import com.yaohui.caij.service.TaskService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaskBizImpl implements TaskBiz {

    @Autowired
    private TaskService taskService;

    @Override
    public Result insert(TaskInsertReqDTO dto) {
        Task task = taskInsertReqDTO2DO(dto);
        taskService.insert(task);
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
    public PagedResult<TaskQueryRspDTO> selectByParamsForPage(Integer id, String name, Byte isDynamic, Date startCreatedAt, Date endCreatedAt, Byte status, int pageNo, int pageSize, String orderByClause) {
        Page<Task> taskPage = taskService.selectByParamsForPage(id, name, isDynamic, startCreatedAt, endCreatedAt, status, pageNo, pageSize, orderByClause);
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
    public Result<List<TaskQueryRspDTO>> selectByParamsForList(Integer id, String name, Byte isDynamic, Date startCreatedAt, Date endCreatedAt, Byte status) {
        List<Task> taskList = taskService.selectByParamsForList(id, name, isDynamic, startCreatedAt, endCreatedAt, status);
        List<TaskQueryRspDTO> dtoList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(taskList)) {
            for (Task e : taskList) {
                TaskQueryRspDTO dto = do2TaskQueryRspDTO(e);
                dtoList.add(dto);
            }
        }
        return Result.success(dtoList);
    }

    private Task taskInsertReqDTO2DO(TaskInsertReqDTO dto) {
        Task entity = new Task();
        BeanUtils.copyProperties(dto, entity);
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
