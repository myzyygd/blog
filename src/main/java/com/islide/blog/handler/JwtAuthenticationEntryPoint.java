package com.islide.blog.handler;

import com.alibaba.fastjson.JSON;
import com.islide.blog.common.Result;
import com.islide.blog.enums.ApiErrorCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义认证处理
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        outputStream.write(JSON.toJSONBytes(Result.error(ApiErrorCode.UNAUTHORIZED)));
        outputStream.flush();
        outputStream.close();
    }
}
