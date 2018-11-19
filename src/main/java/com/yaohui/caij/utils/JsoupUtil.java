package com.yaohui.caij.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class JsoupUtil {


  /**
   * 根据网页内容返回Document对象
   *
   * @param html :
   * @return : org.jsoup.nodes.Document
   */
  public static Document getDocumentFromContent(String html) {
    return Jsoup.parse(html);
  }


  /**
   * 获取元素内某个子元素
   *
   * @param e :
   * @param rule :
   * @return : java.util.List<org.jsoup.nodes.Element>
   */
  public static List<Element> selectElements(Element e, String rule) {
    return e.select(rule);
  }

}
