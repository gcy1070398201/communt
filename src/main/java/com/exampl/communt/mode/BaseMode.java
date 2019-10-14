package com.exampl.communt.mode;

import org.springframework.stereotype.Component;

/**
 * 前后端数据统一交互格式
 * @param <T>
 */
public class BaseMode<T> {
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return this.code;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public BaseMode(final int code, final String msg, final T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
