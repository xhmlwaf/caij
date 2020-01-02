package com.yaohui.caij.utils.rule;

import com.google.common.collect.Lists;

import com.yaohui.caij.bo.DetailPageConfigBO;
import com.yaohui.caij.enums.LocationTypeEnum;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

public class DetailPageUrlRule {

    private static final String URL_START_TAG = "http";

    /**
     * 获取详情页信息
     */
    public static String getDetailPageUrl(String homeUrl, DetailPageConfigBO detailPageConfigBO, Element e) {
        String value = null;
        Elements target = StringUtils.isEmpty(detailPageConfigBO.getXpath()) ? new Elements(Lists.newArrayList(e)) : e.select(detailPageConfigBO.getXpath());
        if (detailPageConfigBO.getLocation() == LocationTypeEnum.HTML.getValue()) {
            value = target.html();
        } else if (detailPageConfigBO.getLocation() == LocationTypeEnum.ATTR.getValue()) {
            value = target.attr(detailPageConfigBO.getAttrName());
        }
        if (value != null && !value.toLowerCase().startsWith(URL_START_TAG)) {
            return homeUrl + value;
        }
        return value;
    }
}
