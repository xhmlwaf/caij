package com.yaohui.caij.utils;

public class StringUtils {

    public static boolean isBlank(String str) {

        if (str == null || "".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }
}
