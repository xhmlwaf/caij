package com.yaohui.caij.thread;

import com.yaohui.caij.cache.WebPageTaskQueue;
import com.yaohui.caij.constant.model.WebPageConfig;
import com.yaohui.caij.utils.CaijUtils;

import java.util.List;
import java.util.Map;

public class CaijTaskThread implements Runnable {

    @Override
    public void run() {

        try {
            while (true) {
                WebPageConfig webPageConfig = WebPageTaskQueue.webPageConfigQueue.take();
                if (webPageConfig != null) {
                    List<Map<String, Object>> resultMap = CaijUtils.dealAndReturn(webPageConfig);
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
