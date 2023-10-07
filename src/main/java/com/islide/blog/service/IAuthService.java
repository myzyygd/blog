package com.islide.blog.service;

import com.islide.blog.dto.in.LoginDto;
import com.islide.blog.dto.out.LoginSuccessDto;

public interface IAuthService {
    LoginSuccessDto login(LoginDto loginDto) throws Exception;
}
