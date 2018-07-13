package com.yaohui.caij.thread;

import com.yaohui.caij.cache.WebPageTaskQueue;
import com.yaohui.caij.constant.model.WebPageConfig;
import com.yaohui.caij.utils.CaijUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class CaijTaskThread implements Runnable {

  public static final Logger logger = LoggerFactory.getLogger(CaijTaskThread.class);

  @Override
  public void run() {

    try {
      while (true) {
        WebPageConfig webPageConfig = WebPageTaskQueue.take();
        if (webPageConfig != null) {
          List<Map<String, Object>> resultMap = CaijUtils.dealAndReturn(webPageConfig);
        }
      }

    } catch (Exception e) {
      logger.error("抓取数据异常.", e);
    }

  }


}
