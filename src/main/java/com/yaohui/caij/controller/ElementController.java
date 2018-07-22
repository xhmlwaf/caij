package com.yaohui.caij.controller;

import com.yaohui.caij.biz.ElementBiz;
import com.yaohui.caij.constant.PagedResult;
import com.yaohui.caij.constant.Result;
import com.yaohui.caij.controller.request.ElementInsertReqDTO;
import com.yaohui.caij.controller.request.ElementUpdateReqDTO;
import com.yaohui.caij.controller.response.ElementQueryRspDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = {"Element管理接口"})
@RestController
@Validated
public class ElementController {

    @Autowired
    private ElementBiz elementBiz;

    /**
     * 插入记录
     */
    @PostMapping("/element")
    @ApiOperation(value = "新增记录")
    Result insert(@RequestBody ElementInsertReqDTO dto) {
        return elementBiz.insert(dto);
    }

   /**
     * 批量插入记录
     */
    @PostMapping("/element/batch")
    @ApiOperation(value = "批量新增记录")
    Result insertBatch(@Valid @RequestBody List<ElementInsertReqDTO> dtoList) {
        return elementBiz.insertBatch(dtoList);
    }

    /**
     * 根据主键删除
     */
    @DeleteMapping("/element/{id}")
    @ApiOperation(value = "根据ID删除记录")
    Result deleteByPrimaryKey(@ApiParam(value = "主键", required = true) @PathVariable(value = "id", required = true) Integer id) {
        return elementBiz.deleteByPrimaryKey(id);
    }

    /**
     * 根据主键更新
     */
    @PutMapping("/element")
    @ApiOperation(value = "更新记录")
    Result updateByPrimaryKeySelective(@Valid @RequestBody ElementUpdateReqDTO dto) {
        return elementBiz.updateByPrimaryKeySelective(dto);
    }

    /**
     * 根据主键查询
     */
    @GetMapping("/element/{id}")
    @ApiOperation(value = "根据ID查询记录")
    Result<ElementQueryRspDTO> selectByPrimaryKey(@ApiParam(value = "主键", required = true) @PathVariable(value = "id", required = true) Integer id) {
        return elementBiz.selectByPrimaryKey(id);
    }

    /**
     * 根据ID列表查询
     */
    @GetMapping("/element/batch")
    @ApiOperation(value = "根据ID列表批量查询记录")
    Result<List<ElementQueryRspDTO>> selectByPrimaryKeyList(@Valid @RequestBody List<Integer> ids) {
    return elementBiz.selectByPrimaryKeyList(ids);
    }

    /**
    * 根据参数分页查询
    */
    @GetMapping("/element")
    @ApiOperation(value = "参数查询分页数据")
    PagedResult<ElementQueryRspDTO> selectByParamsForPage(
        @RequestParam(value = "taskId", required = false) Integer taskId,
        @RequestParam(value = "pageNo", required = false, defaultValue = "1") @Min(value = 1, message = "最小值1") int pageNo,
        @RequestParam(value = "pageSize", required = false, defaultValue = "1") @Min(value = 1, message = "最小值1") int pageSize,
        @RequestParam(value = "orderByClause", required = false) String orderByClause) {
        return elementBiz.selectByParamsForPage(taskId, pageNo, pageSize, orderByClause);
    }

    /**
    * 根据参数列表查询
    */
    @GetMapping("/element/all")
    @ApiOperation(value = "参数查询全量数据")
    Result<List<ElementQueryRspDTO>> selectByParamsForList(
        @RequestParam(value = "taskId", required = false) Integer taskId
        ) {
        return elementBiz.selectByParamsForList(taskId);
     }

}
