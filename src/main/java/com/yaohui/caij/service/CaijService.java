package com.yaohui.caij.service;

import com.yaohui.caij.constant.model.PageConfig;
import com.yaohui.caij.constant.model.WebPageConfig;

import java.util.List;
import java.util.Map;

public interface CaijService {

  /**
   * 将采集任务转换为多个采集页面
   */
  List<WebPageConfig> listWebPageConfig(WebPageConfig webPageConfig, PageConfig pageConfig);


  /**
   * 处理并返回结果
   */
  List<Map<String, Object>> dealAndReturn(WebPageConfig webPageConfig);


}
