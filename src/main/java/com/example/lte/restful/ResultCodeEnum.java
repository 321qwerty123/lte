package com.example.lte.restful;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    SUCCESS(0, "操作成功"),
    TOKEN_NULL(9777, "请求头里没有token"),
    TOKEN_TIME_OUT(9776, "token已过期,请重新登录"),
    TOKEN_USER_ALREADY_SIGN(9775, "token用户已登录,请退出重登后再请求本接口"),
    FAILED(9500, "响应失败"),
    BUSY(9600, "系统繁忙"),
    ACCOUNT_PASS_FAILED(9301, "密码错误"),
    ACCOUNT_NOT_EXIST(9302, "用户名不存在"),
    ACCOUNT_DISABLED(9303, "用户没有权限/已禁用"),
    NOT_LOGIN(9403,"未登录"),
    VALIDATE_FAILED(9996, "参数校验异常"),
    ARITHMETIC_FAILED(9997, "算术异常"),
    ARRAY_INDEX_OUT_OF_BOUNDS_FAILED(9998, "数组越界异常"),
    ERROR(9999, "未知错误");

    private int code;
    private String msg;

    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }



}
