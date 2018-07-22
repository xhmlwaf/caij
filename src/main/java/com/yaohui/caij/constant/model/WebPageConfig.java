package com.yaohui.caij.constant.model;

import java.util.List;
import java.util.Map;

/**
 * 网页配置
 */
public class WebPageConfig {

    /**
     * 抓取目标地址
     */
    private String targetUrl;

    /**
     * 主页地址（可能用于拼接地址）
     */
    private String homeUrl;

    /**
     * 内容列表规则
     */
    private String entityListXpath;

    /**
     * 参数名：参数规则
     */
    private Map<String, ParamsElement> paramsRuleMap;

    /**
     * 详情页规则
     */
    private List<DetailPageConfig> detailPageConfigList;

    /**
     * 动态网站
     */
    private boolean dynamic;


    public String getTargetUrl() {
        return targetUrl;
    }

    private static final String HTTP_TEMP = "https://";

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
        int index = targetUrl.indexOf("/", HTTP_TEMP.length());
        this.homeUrl = targetUrl.substring(0, index);
    }

    public String getHomeUrl() {
        return homeUrl;
    }

    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }

    public String getEntityListXpath() {
        return entityListXpath;
    }

    public void setEntityListXpath(String entityListXpath) {
        this.entityListXpath = entityListXpath;
    }

    public Map<String, ParamsElement> getParamsRuleMap() {
        return paramsRuleMap;
    }

    public void setParamsRuleMap(Map<String, ParamsElement> paramsRuleMap) {
        this.paramsRuleMap = paramsRuleMap;
    }


    public List<DetailPageConfig> getDetailPageConfigList() {
        return detailPageConfigList;
    }

    public void setDetailPageConfigList(List<DetailPageConfig> detailPageConfigList) {
        this.detailPageConfigList = detailPageConfigList;
    }

    public boolean isDynamic() {
        return dynamic;
    }

    public void setDynamic(boolean dynamic) {
        this.dynamic = dynamic;
    }
}
