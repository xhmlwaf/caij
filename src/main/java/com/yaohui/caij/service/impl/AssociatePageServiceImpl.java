package com.yaohui.caij.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yaohui.caij.constant.Page;
import com.yaohui.caij.dao.AssociatePageMapper;
import com.yaohui.caij.dao.entity.AssociatePage;
import com.yaohui.caij.service.AssociatePageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import tk.mybatis.mapper.entity.Example;

@Service
public class AssociatePageServiceImpl implements AssociatePageService {

    @Autowired
    private AssociatePageMapper associatePageMapper;

    @Override
    public int insert(AssociatePage record) {
        return associatePageMapper.insert(record);
    }

    @Override
    public int insertBatch(List<AssociatePage> record) {
        return associatePageMapper.insertBatchSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return associatePageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AssociatePage record) {
        return associatePageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public AssociatePage selectByPrimaryKey(Integer id) {
        return associatePageMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<AssociatePage> selectByPrimaryKeyList(List<Integer> ids) {
        Example example = new Example(AssociatePage.class);
        example.createCriteria().andIn("id",ids);
        return associatePageMapper.selectByExample(example);
    }

    @Override
    public Page<AssociatePage> selectByRecordForPage(AssociatePage record, int pageNo, int pageSize, String orderByClause) {
        Example example = new Example(AssociatePage.class);
        Example.Criteria criteria = example.createCriteria();

        PageHelper.startPage(pageNo,pageSize);
        example.setOrderByClause(orderByClause);

        if (record.getTaskId() != null) {
            criteria.andEqualTo("taskId",record.getTaskId());
        }

        List<AssociatePage> list = associatePageMapper.selectByExample(example);
        PageInfo<AssociatePage> pageInfo = new PageInfo<AssociatePage>(list);
        Page<AssociatePage> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        page.setResult(list);
        page.setTotalCount((int)pageInfo.getTotal());
        return page;
    }

    @Override
    public List<AssociatePage> selectByRecordForList(AssociatePage record) {
        Example example = new Example(AssociatePage.class);
        Example.Criteria criteria = example.createCriteria();

        if (record.getTaskId() != null) {
            criteria.andEqualTo("taskId",record.getTaskId());
        }

        return associatePageMapper.selectByExample(example);
    }

    @Override
    public Page<AssociatePage> selectByParamsForPage(Integer taskId, int pageNo, int pageSize, String orderByClause) {
        Example example = new Example(AssociatePage.class);
        Example.Criteria criteria = example.createCriteria();

        PageHelper.startPage(pageNo,pageSize);
        example.setOrderByClause(orderByClause);

        if (taskId != null) {
             criteria.andEqualTo("taskId",taskId);
        }

        List<AssociatePage> list = associatePageMapper.selectByExample(example);
        PageInfo<AssociatePage> pageInfo = new PageInfo<AssociatePage>(list);
        Page<AssociatePage> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        page.setResult(list);
        page.setTotalCount((int)pageInfo.getTotal());
        return page;
    }

    @Override
    public List<AssociatePage> selectByParamsForList(Integer taskId) {
        Example example = new Example(AssociatePage.class);
        Example.Criteria criteria = example.createCriteria();

        if (taskId != null) {
            criteria.andEqualTo("taskId",taskId);
        }

        return associatePageMapper.selectByExample(example);
    }

 }
