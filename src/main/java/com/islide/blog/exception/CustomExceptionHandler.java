package com.islide.blog.exception;

import com.islide.blog.common.Result;
import com.islide.blog.enums.ApiErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.OK)
    public <T> Result<T> handlerBusinessException(BusinessException exception) {
        return new Result<>(exception.getCode(), exception.getMsg());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public <T> Result<T> handlerException(Exception exception) {
        return new Result<>(ApiErrorCode.FAILED.getCode(), exception.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public void accessDeniedException(AccessDeniedException accessDeniedException) throws AccessDeniedException {
        throw accessDeniedException;
    }


}
