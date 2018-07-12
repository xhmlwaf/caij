package com.yaohui.caij.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yaohui.caij.constant.Page;
import com.yaohui.caij.dao.TaskDetailMapper;
import com.yaohui.caij.dao.entity.TaskDetail;
import com.yaohui.caij.service.TaskDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import tk.mybatis.mapper.entity.Example;

@Service
public class TaskDetailServiceImpl implements TaskDetailService {

    @Autowired
    private TaskDetailMapper taskDetailMapper;

    @Override
    public int insert(TaskDetail record) {
        return taskDetailMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return taskDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TaskDetail record) {
        return taskDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public TaskDetail selectByPrimaryKey(Integer id) {
        return taskDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TaskDetail> selectByPrimaryKeyList(List<Integer> ids) {
        Example example = new Example(TaskDetail.class);
        example.createCriteria().andIn("id",ids);
        return taskDetailMapper.selectByExample(example);
    }

    @Override
    public Page<TaskDetail> selectByRecordForPage(TaskDetail record, int pageNo, int pageSize, String orderByClause) {
        Example example = new Example(TaskDetail.class);
        Example.Criteria criteria = example.createCriteria();

        PageHelper.startPage(pageNo,pageSize);
        example.setOrderByClause(orderByClause);

        if (record.getId() != null) {
            criteria.andEqualTo("id",record.getId());
        }
        if (record.getTaskId() != null) {
            criteria.andEqualTo("taskId",record.getTaskId());
        }

        List<TaskDetail> list = taskDetailMapper.selectByExample(example);
        PageInfo<TaskDetail> pageInfo = new PageInfo<TaskDetail>(list);
        Page<TaskDetail> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        page.setResult(list);
        page.setTotalCount((int)pageInfo.getTotal());
        return page;
    }

    @Override
    public List<TaskDetail> selectByRecordForList(TaskDetail record) {
        Example example = new Example(TaskDetail.class);
        Example.Criteria criteria = example.createCriteria();

        if (record.getId() != null) {
            criteria.andEqualTo("id",record.getId());
        }
        if (record.getTaskId() != null) {
            criteria.andEqualTo("taskId",record.getTaskId());
        }

        return taskDetailMapper.selectByExample(example);
    }

    @Override
    public Page<TaskDetail> selectByParamsForPage(Integer id, Integer taskId, int pageNo, int pageSize, String orderByClause) {
        Example example = new Example(TaskDetail.class);
        Example.Criteria criteria = example.createCriteria();

        PageHelper.startPage(pageNo,pageSize);
        example.setOrderByClause(orderByClause);

        if (id != null) {
             criteria.andEqualTo("id",id);
        }
        if (taskId != null) {
             criteria.andEqualTo("taskId",taskId);
        }

        List<TaskDetail> list = taskDetailMapper.selectByExample(example);
        PageInfo<TaskDetail> pageInfo = new PageInfo<TaskDetail>(list);
        Page<TaskDetail> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        page.setResult(list);
        page.setTotalCount((int)pageInfo.getTotal());
        return page;
    }

    @Override
    public List<TaskDetail> selectByParamsForList(Integer id, Integer taskId) {
        Example example = new Example(TaskDetail.class);
        Example.Criteria criteria = example.createCriteria();

        if (id != null) {
            criteria.andEqualTo("id",id);
        }
        if (taskId != null) {
            criteria.andEqualTo("taskId",taskId);
        }

        return taskDetailMapper.selectByExample(example);
    }

 }
