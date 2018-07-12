package com.yaohui.caij.controller;

import com.yaohui.caij.biz.TaskDetailBiz;
import com.yaohui.caij.constant.PagedResult;
import com.yaohui.caij.constant.Result;
import com.yaohui.caij.controller.request.TaskDetailInsertReqDTO;
import com.yaohui.caij.controller.request.TaskDetailUpdateReqDTO;
import com.yaohui.caij.controller.response.TaskDetailQueryRspDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = {"TaskDetail管理接口"})
@RestController
@Validated
public class TaskDetailController {

    @Autowired
    private TaskDetailBiz taskDetailBiz;

    /**
     * 插入记录
     */
    @PostMapping("/taskDetail")
    @ApiOperation(value = "新增记录")
    Result insert(@Valid @RequestBody TaskDetailInsertReqDTO dto) {
        return taskDetailBiz.insert(dto);
    }

    /**
     * 根据主键删除
     */
    @DeleteMapping("/taskDetail/{id}")
    @ApiOperation(value = "根据ID删除记录")
    Result deleteByPrimaryKey(@ApiParam(value = "主键", required = true) @PathVariable(value = "id", required = true) Integer id) {
        return taskDetailBiz.deleteByPrimaryKey(id);
    }

    /**
     * 根据主键更新
     */
    @PutMapping("/taskDetail")
    @ApiOperation(value = "更新记录")
    Result updateByPrimaryKeySelective(@Valid @RequestBody TaskDetailUpdateReqDTO dto) {
        return taskDetailBiz.updateByPrimaryKeySelective(dto);
    }

    /**
     * 根据主键查询
     */
    @GetMapping("/taskDetail/{id}")
    @ApiOperation(value = "根据ID查询记录")
    Result<TaskDetailQueryRspDTO> selectByPrimaryKey(@ApiParam(value = "主键", required = true) @PathVariable(value = "id", required = true) Integer id) {
        return taskDetailBiz.selectByPrimaryKey(id);
    }

    /**
     * 根据ID列表查询
     */
    @PostMapping("/taskDetail/batch")
    @ApiOperation(value = "根据ID列表批量查询记录")
    Result<List<TaskDetailQueryRspDTO>> selectByPrimaryKeyList(@Valid @RequestBody List<Integer> ids) {
        return taskDetailBiz.selectByPrimaryKeyList(ids);
    }

    /**
     * 根据参数分页查询
     */
    @GetMapping("/taskDetail")
    @ApiOperation(value = "参数查询分页数据")
    PagedResult<TaskDetailQueryRspDTO> selectByParamsForPage(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "taskId", required = false) Integer taskId,
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") @Min(value = 1, message = "最小值1") int pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "1") @Min(value = 1, message = "最小值1") int pageSize,
            @RequestParam(value = "pageSize", required = false) String orderByClause) {
        return taskDetailBiz.selectByParamsForPage(id, taskId, pageNo, pageSize, orderByClause);
    }

    /**
     * 根据参数列表查询
     */
    @GetMapping("/taskDetail/all")
    @ApiOperation(value = "参数查询全量数据")
    Result<List<TaskDetailQueryRspDTO>> selectByParamsForList(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "taskId", required = false) Integer taskId
    ) {
        return taskDetailBiz.selectByParamsForList(id, taskId);
    }

}
