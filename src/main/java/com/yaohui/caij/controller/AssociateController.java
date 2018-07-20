package com.yaohui.caij.controller;

import com.yaohui.caij.constant.Page;
import com.yaohui.caij.constant.PagedResult;
import com.yaohui.caij.controller.response.AssociateDTO;
import com.yaohui.caij.controller.response.TaskDTO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AssociateController {

  @GetMapping("/admin/associate")
  @ResponseBody
  public PagedResult<AssociateDTO> getByPage(
      @RequestParam(value = "pageSize") int pageSize,
      @RequestParam(value = "page") int page
  ){

    AssociateDTO dto1 = new AssociateDTO();
    dto1.setId(1);
    dto1.setName("名称1");
    dto1.setAttrName("ssss");
    dto1.setContentType(1);
    dto1.setXpath("xxxxx");
    dto1.setRegex("regex");

    List<AssociateDTO> taskDTOList = new ArrayList<>();
    taskDTOList.add(dto1);

    for (int i=0;i<pageSize;i++){
      dto1.setId(i+2);
      dto1.setName("名称"+dto1.getId());
      taskDTOList.add(dto1);
    }

    PagedResult<AssociateDTO> pagedResult = new PagedResult<>();
    Page page1 = new Page();
    page1.setPageNo(page);
    page1.setPageSize(pageSize);
    page1.setResult(taskDTOList);
    page1.setTotalCount(100);

    pagedResult.setData(page1);

    return pagedResult;
  }
}
