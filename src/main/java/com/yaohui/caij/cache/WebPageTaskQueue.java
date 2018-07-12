package com.yaohui.caij.cache;

import com.yaohui.caij.constant.model.WebPageConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class WebPageTaskQueue {

    public static final Logger logger = LoggerFactory.getLogger(WebPageTaskQueue.class);

    private static final int MAX_QUEUE_SIZE = 1000;

    public static final BlockingQueue<WebPageConfig> webPageConfigQueue = new LinkedBlockingDeque<>(MAX_QUEUE_SIZE);

    public static void put(WebPageConfig webPageConfig) {
        try {
            webPageConfigQueue.put(webPageConfig);
        } catch (InterruptedException e) {
            logger.error("放入队列出错.", e);
        }
    }


}
