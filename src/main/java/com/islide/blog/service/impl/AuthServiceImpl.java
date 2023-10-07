package com.islide.blog.service.impl;

import com.islide.blog.dto.in.LoginDto;
import com.islide.blog.dto.out.LoginSuccessDto;
import com.islide.blog.entity.LoginUserInfo;
import com.islide.blog.enums.ApiErrorCode;
import com.islide.blog.exception.BusinessException;
import com.islide.blog.service.IAuthService;
import com.islide.blog.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {
    private final AuthenticationManager authenticationManager;

    @Override
    public LoginSuccessDto login(LoginDto loginDto) throws Exception {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginDto.getUserName(), loginDto.getPassword());

        Authentication authenticate = authenticationManager.authenticate(token);
        if (ObjectUtils.isEmpty(authenticate)) {
            throw new BusinessException(ApiErrorCode.FAILED.getCode(), "登陆失败");
        }
        LoginUserInfo userInfo = (LoginUserInfo) authenticate.getPrincipal();
        String jwtToken = JwtUtils.createToken(new HashMap<String, Object>() {
            {
                put("id", userInfo.getUserId());
                put("userName", userInfo.getUsername());
            }
        });
        LoginSuccessDto loginSuccessDto = new LoginSuccessDto();
        loginSuccessDto.setToken(jwtToken);

        return loginSuccessDto;
    }
}
