package com.yaohui.caij.utils.rule;

import com.yaohui.caij.constant.model.DetailPageConfig;
import com.yaohui.caij.enums.LocationType;

import org.jsoup.nodes.Element;

public class DetailPageUrlRule {

    private static final String URL_START_TAG = "http";

    /**
     * 获取详情页信息
     */
    public static String getDetailPageUrl(String homeUrl, DetailPageConfig detailPageConfig, Element e) {
        String value = null;
        if (detailPageConfig.getLocation() == LocationType.HTML.getValue()) {
            value = e.select(detailPageConfig.getXpath()).html();
        } else if (detailPageConfig.getLocation() == LocationType.ATTR.getValue()) {
            value = e.select(detailPageConfig.getXpath()).attr(detailPageConfig.getAttrName());
        }
        if (value != null && !value.toLowerCase().startsWith(URL_START_TAG)) {
            return homeUrl + value;
        }
        return value;
    }
}
