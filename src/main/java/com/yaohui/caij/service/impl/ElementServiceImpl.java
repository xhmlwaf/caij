package com.yaohui.caij.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yaohui.caij.constant.Page;
import com.yaohui.caij.dao.ElementMapper;
import com.yaohui.caij.dao.entity.Element;
import com.yaohui.caij.service.ElementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import tk.mybatis.mapper.entity.Example;

@Service
public class ElementServiceImpl implements ElementService {

    @Autowired
    private ElementMapper elementMapper;

    @Override
    public int insert(Element record) {
        return elementMapper.insert(record);
    }

    @Override
    public int insertBatch(List<Element> record) {
        return elementMapper.insertBatchSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return elementMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Element record) {
        return elementMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Element selectByPrimaryKey(Integer id) {
        return elementMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Element> selectByPrimaryKeyList(List<Integer> ids) {
        Example example = new Example(Element.class);
        example.createCriteria().andIn("id",ids);
        return elementMapper.selectByExample(example);
    }

    @Override
    public Page<Element> selectByRecordForPage(Element record, int pageNo, int pageSize, String orderByClause) {
        Example example = new Example(Element.class);
        Example.Criteria criteria = example.createCriteria();

        PageHelper.startPage(pageNo,pageSize);
        example.setOrderByClause(orderByClause);

        if (record.getTaskId() != null) {
            criteria.andEqualTo("taskId",record.getTaskId());
        }

        List<Element> list = elementMapper.selectByExample(example);
        PageInfo<Element> pageInfo = new PageInfo<Element>(list);
        Page<Element> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        page.setResult(list);
        page.setTotalCount((int)pageInfo.getTotal());
        return page;
    }

    @Override
    public List<Element> selectByRecordForList(Element record) {
        Example example = new Example(Element.class);
        Example.Criteria criteria = example.createCriteria();

        if (record.getTaskId() != null) {
            criteria.andEqualTo("taskId",record.getTaskId());
        }

        return elementMapper.selectByExample(example);
    }

    @Override
    public Page<Element> selectByParamsForPage(Integer taskId, int pageNo, int pageSize, String orderByClause) {
        Example example = new Example(Element.class);
        Example.Criteria criteria = example.createCriteria();

        PageHelper.startPage(pageNo,pageSize);
        example.setOrderByClause(orderByClause);

        if (taskId != null) {
             criteria.andEqualTo("taskId",taskId);
        }

        List<Element> list = elementMapper.selectByExample(example);
        PageInfo<Element> pageInfo = new PageInfo<Element>(list);
        Page<Element> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        page.setResult(list);
        page.setTotalCount((int)pageInfo.getTotal());
        return page;
    }

    @Override
    public List<Element> selectByParamsForList(Integer taskId) {
        Example example = new Example(Element.class);
        Example.Criteria criteria = example.createCriteria();

        if (taskId != null) {
            criteria.andEqualTo("taskId",taskId);
        }

        return elementMapper.selectByExample(example);
    }

 }
