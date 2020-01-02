package com.yaohui.caij.utils;

import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebPageContentUtil {

  /**
   * 根据URL地址获取网页内容
   *
   * @param urlString :
   * @return : java.lang.String
   */
  private static String getSourceContent(String urlString) throws Exception {
    StringBuilder html = new StringBuilder();
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
  }

  /**
   * 获取动态网页内容
   *
   * @param urlString :
   * @return : java.lang.String
   */
  private static String getDynamicContent(String urlString) throws Exception {
    ChromeDriver chromeDriver = (ChromeDriver) ChromeDriverPoolUtils.pool.borrowObject();
    chromeDriver.get("about:blank");
    chromeDriver.get(urlString);
    String source = chromeDriver.getPageSource();
    ChromeDriverPoolUtils.pool.returnObject(chromeDriver);
    return source;
  }

  /**
   * 获取网页内容
   *
   * @param url     :
   * @param dynamic :
   * @return : java.lang.String
   */
  public static String getWebPageContent(String url, boolean dynamic) {
    try {
      if (dynamic) {
        return getDynamicContent(url);
      } else {
        return getSourceContent(url);
      }
    } catch (Exception e) {
      log.error("获取网页内容发生异常.", e);
      return null;
    }
  }

}
