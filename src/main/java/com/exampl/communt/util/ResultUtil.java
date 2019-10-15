package com.exampl.communt.util;

import com.exampl.communt.exception.AcmeException;
import com.exampl.communt.exception.AcmeExceptionCode;

public class ResultUtil {

    private Integer code;
    private String msg;

    public ResultUtil(final Integer code, final String msg) {
        this.code = code;
        this.msg = msg;
    }



    public String getMsg() {
        return this.msg;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(final Integer code) {
        this.code = code;
    }

    public static ResultUtil errorOf(Integer code, String msg) {
        return new ResultUtil(code, msg);
    }

    public static ResultUtil errorOf(AcmeExceptionCode userLoginErrorCode) {
        return new ResultUtil(userLoginErrorCode.getCode(), userLoginErrorCode.getMessage());
    }

    public static ResultUtil errorOf(AcmeException e) {
        return new ResultUtil(e.getCode(),e.getMessage());
    }

    public static ResultUtil okOf() {
        return new ResultUtil(10000, "成功");
    }
}
