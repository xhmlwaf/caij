package com.yaohui.caij.constant.model;

/**
 * 页码规则
 */
public class PageConfig {

    /**
     * 页码对应的url
     */
    private String nextPageUrl;

    /**
     * 开始页码数
     */
    private int startPageNum;

    /**
     * 结束页码数
     */
    private int endPageNum;

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public int getStartPageNum() {
        return startPageNum;
    }

    public void setStartPageNum(int startPageNum) {
        this.startPageNum = startPageNum;
    }

    public int getEndPageNum() {
        return endPageNum;
    }

    public void setEndPageNum(int endPageNum) {
        this.endPageNum = endPageNum;
    }
}
