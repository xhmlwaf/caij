package com.yaohui.caij.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class FileUrlQueue {

  public static final Logger logger = LoggerFactory.getLogger(FileUrlQueue.class);

  private static final int MAX_QUEUE_SIZE = 100000;

  private static final BlockingQueue<String> fileUrlQueue = new LinkedBlockingDeque<>(MAX_QUEUE_SIZE);

  public static void put(String url) {
    try {
      fileUrlQueue.put(url);
    } catch (InterruptedException e) {
      logger.error("放入队列出错.", e);
    }
  }

  public static String take() {
    String url = null;
    try {
      url = fileUrlQueue.take();
    } catch (InterruptedException e) {
      logger.error("从队列获取发生异常.", e);
    }
    return url;
  }


}
