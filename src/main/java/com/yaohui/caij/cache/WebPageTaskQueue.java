package com.yaohui.caij.cache;

import com.yaohui.caij.bo.WebPageConfigBO;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebPageTaskQueue {

  private static final int MAX_QUEUE_SIZE = 1000;

  private static final BlockingQueue<WebPageConfigBO> WEB_PAGE_CONFIG_BO_QUEUE = new LinkedBlockingDeque<>(MAX_QUEUE_SIZE);

  public static void put(WebPageConfigBO webPageConfigBO) {
    try {
      WEB_PAGE_CONFIG_BO_QUEUE.put(webPageConfigBO);
    } catch (InterruptedException e) {
      log.error("放入队列出错.", e);
    }
  }

  public static WebPageConfigBO take() {
    WebPageConfigBO webPageConfigBO = null;
    try {
      webPageConfigBO = WEB_PAGE_CONFIG_BO_QUEUE.take();
    } catch (InterruptedException e) {
      log.error("从队列获取发生异常.", e);
    }
    return webPageConfigBO;
  }


}
