package com.yaohui.caij.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {
  //默认页面
  private static final String DEFAULT_PAGE = "timeline.html";
  //首页模版
  private static final String INDEX_PAGE_TEMPLATE = "index";
  //业务页面
  private static final String BIZ_PAGE_PARAM_NAME = "bodyFilePath";

  @GetMapping("/admin")
  public ModelAndView toIndex(@RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE) String page,
    @RequestParam Map<String,String> map) {
    Map<String, Object> modelMap = new HashMap<>();
    modelMap.putAll(map);
    modelMap.put(BIZ_PAGE_PARAM_NAME, page);
    return new ModelAndView(INDEX_PAGE_TEMPLATE, modelMap);
  }

}
