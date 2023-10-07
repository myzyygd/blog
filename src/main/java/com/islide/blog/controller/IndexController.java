package com.islide.blog.controller;

import com.islide.blog.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@Api(tags = "首页")
public class IndexController {

    private final IUserService userService;

    @GetMapping("/")
    @ApiOperation(value = "根据姓名获取问候信息", notes = "根据传入的姓名参数，返回问候信息")
    public String home(ModelAndView modelAndView) {
        return "main.html";
    }

    @GetMapping("/index")
    @ApiOperation(value = "根据姓名获取问候信息", notes = "根据传入的姓名参数，返回问候信息")
    public String index(ModelAndView modelAndView) {
        return "main.html";
    }
}
