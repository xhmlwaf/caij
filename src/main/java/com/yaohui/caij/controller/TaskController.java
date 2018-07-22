package com.yaohui.caij.controller;

import com.yaohui.caij.biz.TaskBiz;
import com.yaohui.caij.constant.PagedResult;
import com.yaohui.caij.constant.Result;
import com.yaohui.caij.controller.request.TaskInsertReqDTO;
import com.yaohui.caij.controller.request.TaskUpdateReqDTO;
import com.yaohui.caij.controller.response.TaskQueryRspDTO;

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

@Api(tags = {"Task管理接口"})
@RestController
@Validated
public class TaskController {

    @Autowired
    private TaskBiz taskBiz;

    /**
     * 插入记录
     */
    @PostMapping("/task")
    @ApiOperation(value = "新增记录")
    Result insert(@RequestBody TaskInsertReqDTO dto) {
        return taskBiz.insert(dto);
    }

   /**
     * 批量插入记录
     */
    @PostMapping("/task/batch")
    @ApiOperation(value = "批量新增记录")
    Result insertBatch(@Valid @RequestBody List<TaskInsertReqDTO> dtoList) {
        return taskBiz.insertBatch(dtoList);
    }

    /**
     * 根据主键删除
     */
    @DeleteMapping("/task/{id}")
    @ApiOperation(value = "根据ID删除记录")
    Result deleteByPrimaryKey(@ApiParam(value = "主键", required = true) @PathVariable(value = "id", required = true) Integer id) {
        return taskBiz.deleteByPrimaryKey(id);
    }

    /**
     * 根据主键更新
     */
    @PutMapping("/task")
    @ApiOperation(value = "更新记录")
    Result updateByPrimaryKeySelective(@Valid @RequestBody TaskUpdateReqDTO dto) {
        return taskBiz.updateByPrimaryKeySelective(dto);
    }

    /**
     * 根据主键查询
     */
    @GetMapping("/task/{id}")
    @ApiOperation(value = "根据ID查询记录")
    Result<TaskQueryRspDTO> selectByPrimaryKey(@ApiParam(value = "主键", required = true) @PathVariable(value = "id", required = true) Integer id) {
        return taskBiz.selectByPrimaryKey(id);
    }

    /**
     * 根据ID列表查询
     */
    @GetMapping("/task/batch")
    @ApiOperation(value = "根据ID列表批量查询记录")
    Result<List<TaskQueryRspDTO>> selectByPrimaryKeyList(@Valid @RequestBody List<Integer> ids) {
    return taskBiz.selectByPrimaryKeyList(ids);
    }

    /**
    * 根据参数分页查询
    */
    @GetMapping("/task")
    @ApiOperation(value = "参数查询分页数据")
    PagedResult<TaskQueryRspDTO> selectByParamsForPage(
        @RequestParam(value = "name", required = false) String name,
        @RequestParam(value = "dynamic", required = false) Byte dynamic,
        @RequestParam(value = "multiPage", required = false) Byte multiPage,
        @RequestParam(value = "startCreatedAt", required = false) Date startCreatedAt,
        @RequestParam(value = "endCreatedAt", required = false) Date endCreatedAt,
        @RequestParam(value = "pageNo", required = false, defaultValue = "1") @Min(value = 1, message = "最小值1") int pageNo,
        @RequestParam(value = "pageSize", required = false, defaultValue = "1") @Min(value = 1, message = "最小值1") int pageSize,
        @RequestParam(value = "orderByClause", required = false) String orderByClause) {
        return taskBiz.selectByParamsForPage(name, dynamic, multiPage, startCreatedAt, endCreatedAt, pageNo, pageSize, orderByClause);
    }

    /**
    * 根据参数列表查询
    */
    @GetMapping("/task/all")
    @ApiOperation(value = "参数查询全量数据")
    Result<List<TaskQueryRspDTO>> selectByParamsForList(
        @RequestParam(value = "name", required = false) String name,
        @RequestParam(value = "dynamic", required = false) Byte dynamic,
        @RequestParam(value = "multiPage", required = false) Byte multiPage,
        @RequestParam(value = "startCreatedAt", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startCreatedAt,
        @RequestParam(value = "endCreatedAt", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endCreatedAt
        ) {
        return taskBiz.selectByParamsForList(name, dynamic, multiPage, startCreatedAt, endCreatedAt);
     }

    @GetMapping("/task/{id}/start")
    @ApiOperation(value = "启动任务")
     Result startTask(@ApiParam(value = "主键", required = true) @PathVariable(value = "id", required = true) Integer id){
        return taskBiz.startTask(id);
     }

}
