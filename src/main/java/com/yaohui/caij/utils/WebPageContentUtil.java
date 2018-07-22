package com.yaohui.caij.utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebPageContentUtil {

    public static final Logger logger = LoggerFactory.getLogger(WebPageContentUtil.class);

    /**
     * 根据URL地址获取网页内容
     */
    private static String getSourceContent(String urlString) throws Exception {
        try {
            StringBuffer html = new StringBuffer();
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStreamReader isr = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String temp;
            while ((temp = br.readLine()) != null) {
                html.append(temp).append("\n");
            }
            br.close();
            isr.close();
            return html.toString();
        } catch (Exception e) {
            logger.error("获取网页内容异常.url:" + urlString, e);
            throw new RuntimeException(e);
        }
    }

    private static String getDynamicContent(String urlString) throws Exception {
        ChromeDriver chromeDriver = (ChromeDriver)ChromeDriverPoolUtils.pool.borrowObject();
        chromeDriver.get("about:blank");
        chromeDriver.get(urlString);
        String source = chromeDriver.getPageSource();
        logger.info("网页内容："+source);
        ChromeDriverPoolUtils.pool.returnObject(chromeDriver);
        return source;
    }

    public static String getWebPageContent(String url, boolean dynamic) {
        try {
            if (dynamic) {
                return getDynamicContent(url);
            } else {
                return getSourceContent(url);
            }
        } catch (Exception e) {
            logger.error("获取网页内容发生异常.",e);
            return null;
        }
    }

}
