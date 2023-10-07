package com.islide.blog.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.islide.blog.enums.ApiErrorCode;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@ApiModel("结果返回类")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 6860891119347597922L;
    private Integer code;
    private String msg;
    private T data;
    private String errorMsg;
    private String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    public Result() {

    }

    public Result(T data) {
        this.data = data;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, String errorMsg) {
        this.code = code;
        this.msg = msg;
        this.errorMsg = errorMsg;
    }

    public static Result<Void> success() {
        return new Result<>();
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>(data);
        result.code = ApiErrorCode.SUCCESS.getCode();
        result.msg = ApiErrorCode.SUCCESS.getMsg();
        return result;
    }

    public static Result<Void> error(Integer code, String errorMsg) {
        return new Result<>(code, errorMsg);
    }

    public static Result<Void> error(ApiErrorCode code) {
        return new Result<>(code.getCode(), code.getMsg());
    }
}
