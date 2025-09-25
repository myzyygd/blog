package com.islide.blog.controller;

import com.islide.blog.common.Result;
import com.islide.blog.dto.in.LoginDto;
import com.islide.blog.dto.out.LoginSuccessDto;
import com.islide.blog.service.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final IAuthService authService;

    @PostMapping("/login")
    public Result<LoginSuccessDto> login(@RequestBody @Validated LoginDto loginDto) throws Exception {
        LoginSuccessDto login = authService.login(loginDto);
        return Result.success(login);
    }

    //public Result<Void> register()
}
