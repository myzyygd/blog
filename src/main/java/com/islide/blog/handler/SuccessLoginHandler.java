package com.islide.blog.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SuccessLoginHandler implements AuthenticationSuccessHandler {

    private final String redirectUrl;

    public SuccessLoginHandler(String redirectUrl) {
        Assert.isTrue(UrlUtils.isValidRedirectUrl(redirectUrl), () -> " not validate url");
        this.redirectUrl = redirectUrl;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.sendRedirect(this.redirectUrl);
    }
}
