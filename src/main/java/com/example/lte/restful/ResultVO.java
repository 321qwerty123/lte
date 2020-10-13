package com.example.lte.restful;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResultVO<T> {
    int code;
    String msg;
    T data;
    Long timestamp;
    public ResultVO(int code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    public ResultVO(int code,String msg){
        this.code = code;
        this.msg = msg;
        this.data = null;
        this.timestamp = System.currentTimeMillis();
    }
    
    public ResultVO(ResultCodeEnum resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
        this.timestamp = System.currentTimeMillis();

    }

    public ResultVO(T data){
        this(ResultCodeEnum.SUCCESS,data);
    }
}
