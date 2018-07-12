package com.yaohui.caij.biz.impl;

import com.yaohui.caij.biz.TaskDetailBiz;
import com.yaohui.caij.constant.Page;
import com.yaohui.caij.constant.PagedResult;
import com.yaohui.caij.constant.Result;
import com.yaohui.caij.controller.request.TaskDetailInsertReqDTO;
import com.yaohui.caij.controller.request.TaskDetailUpdateReqDTO;
import com.yaohui.caij.controller.response.TaskDetailQueryRspDTO;
import com.yaohui.caij.dao.entity.TaskDetail;
import com.yaohui.caij.service.TaskDetailService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskDetailBizImpl implements TaskDetailBiz {

    @Autowired
    private TaskDetailService taskDetailService;

    @Override
    public Result insert(TaskDetailInsertReqDTO dto) {
        TaskDetail taskDetail = taskDetailInsertReqDTO2DO(dto);
        taskDetailService.insert(taskDetail);
        return Result.success(null);
    }

    @Override
    public Result deleteByPrimaryKey(Integer id) {
        taskDetailService.deleteByPrimaryKey(id);
        return Result.success(null);
    }

    @Override
    public Result updateByPrimaryKeySelective(TaskDetailUpdateReqDTO dto) {
        TaskDetail taskDetail = taskDetailUpdateReqDTO2DO(dto);
        taskDetailService.updateByPrimaryKeySelective(taskDetail);
        return Result.success(null);
    }

    @Override
    public Result<TaskDetailQueryRspDTO> selectByPrimaryKey(Integer id) {
        TaskDetail taskDetail = taskDetailService.selectByPrimaryKey(id);
        TaskDetailQueryRspDTO dto = do2TaskDetailQueryRspDTO(taskDetail);
        return Result.success(dto);
    }

    @Override
    public Result<List<TaskDetailQueryRspDTO>> selectByPrimaryKeyList(List<Integer> ids) {
        List<TaskDetail> taskDetailList = taskDetailService.selectByPrimaryKeyList(ids);
        List<TaskDetailQueryRspDTO> dtoList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(taskDetailList)) {
            for (TaskDetail e : taskDetailList) {
                TaskDetailQueryRspDTO dto = do2TaskDetailQueryRspDTO(e);
                dtoList.add(dto);
            }
        }
        return Result.success(dtoList);
    }

    @Override
    public PagedResult<TaskDetailQueryRspDTO> selectByParamsForPage(Integer id, Integer taskId, int pageNo, int pageSize, String orderByClause) {
        Page<TaskDetail> taskDetailPage = taskDetailService.selectByParamsForPage(id, taskId, pageNo, pageSize, orderByClause);
        List<TaskDetail> taskDetailList = taskDetailPage.getResult();
        List<TaskDetailQueryRspDTO> dtoList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(taskDetailList)) {
            for (TaskDetail e : taskDetailList) {
                TaskDetailQueryRspDTO dto = do2TaskDetailQueryRspDTO(e);
                dtoList.add(dto);
            }
        }
        Page<TaskDetailQueryRspDTO> page = new Page<>();
        page.setTotalCount(taskDetailPage.getTotalCount());
        page.setResult(dtoList);
        page.setPageSize(pageSize);
        page.setPageNo(pageNo);
        page.setTotalPages(taskDetailPage.getTotalPages());
        return PagedResult.success(page);
    }

    @Override
    public Result<List<TaskDetailQueryRspDTO>> selectByParamsForList(Integer id, Integer taskId) {
        List<TaskDetail> taskDetailList = taskDetailService.selectByParamsForList(id, taskId);
        List<TaskDetailQueryRspDTO> dtoList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(taskDetailList)) {
            for (TaskDetail e : taskDetailList) {
                TaskDetailQueryRspDTO dto = do2TaskDetailQueryRspDTO(e);
                dtoList.add(dto);
            }
        }
        return Result.success(dtoList);
    }

    private TaskDetail taskDetailInsertReqDTO2DO(TaskDetailInsertReqDTO dto) {
        TaskDetail entity = new TaskDetail();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    private TaskDetail taskDetailUpdateReqDTO2DO(TaskDetailUpdateReqDTO dto) {
        TaskDetail entity = new TaskDetail();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    private TaskDetailQueryRspDTO do2TaskDetailQueryRspDTO(TaskDetail taskDetail) {
        TaskDetailQueryRspDTO dto = new TaskDetailQueryRspDTO();
        BeanUtils.copyProperties(taskDetail, dto);
        return dto;
    }
}
