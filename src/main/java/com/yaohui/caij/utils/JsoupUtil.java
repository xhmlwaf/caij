package com.yaohui.caij.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class JsoupUtil {

    public static final Logger logger = LoggerFactory.getLogger(JsoupUtil.class);

    /**
     * 根据网页内容返回Document对象
     */
    public static Document getDocumentFromContent(String html) {
        return Jsoup.parse(html);
    }

    /**
     * 获取
     */
    public static List<Element> selectElements(Element e, String rule) {
        return e.select(rule);
    }

}
