package com.yaohui.caij.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

    public static final Logger log = LoggerFactory.getLogger(RegexUtils.class);

    private static RegexUtils zz;

    public static RegexUtils init(CharSequence res, String pattern) {
        if (zz == null || (!res.equals(zz.res) || !pattern.equals(zz.pattern))) {
            //在没有实例或内容不同的时候新建一个实例
            zz = new RegexUtils(res, pattern);
        }
        return zz;
    }

    private CharSequence res;
    private String pattern;
    private Pattern p;
    private Matcher m;
    private int size = 0;
    private String[] list;//所有匹配到的字符串

    private RegexUtils(CharSequence res, String pattern) {
        this.res = res;
        this.pattern = pattern;
        p = Pattern.compile(pattern);
        m = p.matcher(res);
        while (m.find()) {
            size++;
        }
        list = new String[size];
        m.reset();
        for (int i = 0; i < size; i++) {
            if (m.find()) list[i] = m.group();
        }
    }

    /**
     * 是否能匹配到至少一个
     */
    public boolean find() {
        return size > 0;
    }

    /**
     * 匹配整个字符串，必须整个字符串满足正则表达式才算true
     */
    public boolean match() {
        return find() && get(0).equals(res);
    }

    /**
     * 获取所有匹配的字符串个数
     */
    public int size() {
        return size;
    }

    /**
     * 获取所有匹配到的字符串
     */
    public String[] getAll() {
        return list;
    }

    /**
     * 获取匹配到的第N个字符串
     */
    public String get(int index) {
        if (index < 0) {
            log.error("请不要开玩笑,索引 {} 让我去哪里找?", index);
            return null;
        }
        if (index >= size) {
            log.error("并没有匹配到辣么多,总共就{}个，你要第{}个是不行的。", size, index);
            return null;
        }
        return list[index];
    }

    /**
     * 替换所有匹配到的字符串
     */
    public String replaceAll(String replacement) {
        return m.replaceAll(replacement);
    }

    /**
     * 替换第一个匹配到的字符串
     */
    public String replaceFirst(String replacement) {
        return m.replaceFirst(replacement);
    }

    /**
     * 替换最后一个匹配到的字符串
     */
    public String replaceTail(String replacement) {
        return replace(size - 1, replacement);
    }

    /**
     * 替换第N个匹配到的字符串
     */
    public String replace(int index, String replacement) {
        m.reset();
        boolean isFind = false;
        while (index >= 0) {
            isFind = m.find();
            index--;
        }
        if (isFind) {
            StringBuffer sb = new StringBuffer();
            m.appendReplacement(sb, replacement);
            m.appendTail(sb);
            return sb.toString();
        }
        return (String) res;
    }
}
