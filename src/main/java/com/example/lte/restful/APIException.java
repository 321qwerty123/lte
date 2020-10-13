package com.example.lte.restful;

import lombok.Getter;

@Getter
public class APIException extends RuntimeException {
    int code;
    String msg;


    public APIException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public APIException(String msg) {
        this(1001, msg);
    }

    public APIException() {
        this(ResultCodeEnum.FAILED.getCode(), ResultCodeEnum.FAILED.getMsg());
    }

    public APIException(ResultCodeEnum resultCodeEnum){
        this(resultCodeEnum.getCode(),resultCodeEnum.getMsg());
    }
}
