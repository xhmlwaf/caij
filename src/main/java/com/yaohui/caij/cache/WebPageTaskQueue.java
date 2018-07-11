package com.yaohui.caij.cache;

import com.yaohui.caij.constant.model.WebPageConfig;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class WebPageTaskQueue {

  private static final int MAX_QUEUE_SIZE = 1000;
  private static final BlockingQueue<WebPageConfig> webPageConfigQueue = new LinkedBlockingDeque<>(MAX_QUEUE_SIZE);


}
