package com.islide.blog.enums;

import lombok.Getter;

@Getter
public enum ApiErrorCode {
    /**
     * 失败
     */
    FAILED(-1, "操作失败"),

    /**
     * 成功
     */
    SUCCESS(0, "执行成功"),

    /**
     * token验证失败
     */
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(402, "Forbidden");

    private Integer code;
    private String msg;

    ApiErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
