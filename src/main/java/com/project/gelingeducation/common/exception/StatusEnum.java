package com.project.gelingeducation.common.exception;

import lombok.Getter;

@Getter
public enum StatusEnum {
    OK(200, "操作成功"),
    UNKNOWD_ERROR(-3001, "全局异常，未知错误"),
    NO_USER(-3101, "用户未注册"),
    ACCOUNT_PASSWORD_ERROR(-3102, "账号密码错误"),
    NO_LOGIN(-3103, "用户未登录"),
    BAN_USER(-3104, "账号锁定"), 
    ACCOUNT_ALREADY_EXISTS(-3105, "账号已存在"),
    USER_NO_PERMISSION(-3106, "账号无权限"),
    ADD_USER_NO_ROLE(-3107, "添加的用户没有身份"),
    REQUEST_METHOD_NOT_SUPPORT(-3401, "请求的方式不支持");

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 内容
     */
    private String message;

    StatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}