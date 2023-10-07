package com.islide.blog.filter;

import com.alibaba.fastjson.JSON;
import com.islide.blog.common.Result;
import com.islide.blog.entity.LoginUserInfo;
import com.islide.blog.enums.ApiErrorCode;
import com.islide.blog.service.impl.UserDetail;
import com.islide.blog.utils.JwtUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class TokenFilter extends OncePerRequestFilter {
    private final UserDetail userDetail;

    public TokenFilter(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = httpServletRequest.getHeader("Authorization");
        if (StringUtils.isNotEmpty(token)) {
            Map<String, Object> userInfo = JwtUtils.verifyJwt(token);
            if (ObjectUtils.isNotEmpty(userInfo)) {
                if (SecurityContextHolder.getContext().getAuthentication() == null) {
                    LoginUserInfo loginUserInfo = userDetail.loadUserById((Integer) userInfo.get("id"));
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUserInfo, null, loginUserInfo.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
