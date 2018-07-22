package com.yaohui.caij.thread;

import com.alibaba.fastjson.JSON;
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
                    logger.info("开始采集");
                    List<Map<String, Object>> resultMap = CaijUtils.dealAndReturn(webPageConfig);
                    logger.info("采集结果:" + JSON.toJSONString(resultMap));
                    logger.info("结束采集");
                }
            }

        } catch (Exception e) {
            logger.error("抓取数据异常.", e);
        }

    }


}
