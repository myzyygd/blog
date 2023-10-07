package com.islide.blog.exception;

import com.islide.blog.enums.ApiErrorCode;
import lombok.Data;
@Data
public class BusinessException extends Exception {

    private static final long serialVersionUID = 5248499789470270640L;
    private Integer code;
    private String msg;

    public BusinessException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(ApiErrorCode code) {
        super(code.getMsg());
        this.code = code.getCode();
        this.msg = code.getMsg();
    }
}
