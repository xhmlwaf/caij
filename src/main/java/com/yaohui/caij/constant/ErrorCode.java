package com.yaohui.caij.constant;

/**
 * 系统错误码定义
 */
public enum ErrorCode {
    SUCCESS("000000", "success"),
    TASK_NOT_EXSIT("000001", "任务不存在");

    private String code;
    private String desc;

    ErrorCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ErrorCode get(String code) {
        for (ErrorCode e : ErrorCode.values()) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
