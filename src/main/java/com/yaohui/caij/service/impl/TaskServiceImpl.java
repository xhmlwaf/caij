package com.yaohui.caij.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yaohui.caij.constant.Page;
import com.yaohui.caij.dao.TaskMapper;
import com.yaohui.caij.dao.entity.Task;
import com.yaohui.caij.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import tk.mybatis.mapper.entity.Example;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public int insert(Task record) {
        return taskMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return taskMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Task record) {
        return taskMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Task selectByPrimaryKey(Integer id) {
        return taskMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Task> selectByPrimaryKeyList(List<Integer> ids) {
        Example example = new Example(Task.class);
        example.createCriteria().andIn("id", ids);
        return taskMapper.selectByExample(example);
    }

    @Override
    public Page<Task> selectByRecordForPage(Task record, int pageNo, int pageSize, String orderByClause) {
        Example example = new Example(Task.class);
        Example.Criteria criteria = example.createCriteria();

        PageHelper.startPage(pageNo, pageSize);
        example.setOrderByClause(orderByClause);

        if (record.getId() != null) {
            criteria.andEqualTo("id", record.getId());
        }
        if (record.getName() != null) {
            criteria.andLike("name", "%" + record.getName() + "%");
        }
        if (record.getIsDynamic() != null) {
            criteria.andEqualTo("isDynamic", record.getIsDynamic());
        }
        if (record.getCreatedAt() != null) {
            criteria.andEqualTo("createdAt", record.getCreatedAt());
        }
        if (record.getStatus() != null) {
            criteria.andEqualTo("status", record.getStatus());
        }

        List<Task> list = taskMapper.selectByExample(example);
        PageInfo<Task> pageInfo = new PageInfo<Task>(list);
        Page<Task> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        page.setResult(list);
        page.setTotalCount((int) pageInfo.getTotal());
        return page;
    }

    @Override
    public List<Task> selectByRecordForList(Task record) {
        Example example = new Example(Task.class);
        Example.Criteria criteria = example.createCriteria();

        if (record.getId() != null) {
            criteria.andEqualTo("id", record.getId());
        }
        if (record.getName() != null) {
            criteria.andLike("name", "%" + record.getName() + "%");
        }
        if (record.getIsDynamic() != null) {
            criteria.andEqualTo("isDynamic", record.getIsDynamic());
        }
        if (record.getCreatedAt() != null) {
            criteria.andEqualTo("createdAt", record.getCreatedAt());
        }
        if (record.getStatus() != null) {
            criteria.andEqualTo("status", record.getStatus());
        }

        return taskMapper.selectByExample(example);
    }

    @Override
    public Page<Task> selectByParamsForPage(Integer id, String name, Byte isDynamic, Date startCreatedAt, Date endCreatedAt, Byte status, int pageNo, int pageSize, String orderByClause) {
        Example example = new Example(Task.class);
        Example.Criteria criteria = example.createCriteria();

        PageHelper.startPage(pageNo, pageSize);
        example.setOrderByClause(orderByClause);

        if (id != null) {
            criteria.andEqualTo("id", id);
        }
        if (name != null) {
            criteria.andLike("name", "%" + name + "%");
        }
        if (isDynamic != null) {
            criteria.andEqualTo("isDynamic", isDynamic);
        }
        if (startCreatedAt != null) {
            criteria.andGreaterThanOrEqualTo("createdAt", startCreatedAt);
        }
        if (endCreatedAt != null) {
            criteria.andLessThanOrEqualTo("createdAt", startCreatedAt);
        }
        if (status != null) {
            criteria.andEqualTo("status", status);
        }

        List<Task> list = taskMapper.selectByExample(example);
        PageInfo<Task> pageInfo = new PageInfo<Task>(list);
        Page<Task> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        page.setResult(list);
        page.setTotalCount((int) pageInfo.getTotal());
        return page;
    }

    @Override
    public List<Task> selectByParamsForList(Integer id, String name, Byte isDynamic, Date startCreatedAt, Date endCreatedAt, Byte status) {
        Example example = new Example(Task.class);
        Example.Criteria criteria = example.createCriteria();

        if (id != null) {
            criteria.andEqualTo("id", id);
        }
        if (name != null) {
            criteria.andLike("name", "%" + name + "%");
        }
        if (isDynamic != null) {
            criteria.andEqualTo("isDynamic", isDynamic);
        }
        if (startCreatedAt != null) {
            criteria.andGreaterThanOrEqualTo("createdAt", startCreatedAt);
        }
        if (endCreatedAt != null) {
            criteria.andLessThanOrEqualTo("createdAt", startCreatedAt);
        }
        if (status != null) {
            criteria.andEqualTo("status", status);
        }

        return taskMapper.selectByExample(example);
    }

}
