package com.islide.blog.controller;

import io.swagger.annotations.Api;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(tags = "用户")
public class UserController {

    @GetMapping("/list")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String userList() {
        return "user list";
    }

    @GetMapping("/index")
    @PreAuthorize("hasRole('ROLE_NORMAL')")
    public String userIndex() {
        return "User index";
    }

    @GetMapping("/index2")
    @PreAuthorize("hasAuthority('read')")
    public String userIndex2() {
        return "User index2";
    }

    @GetMapping("/index3")
    @PreAuthorize("hasAuthority('writer')")
    public String userIndex3() {
        return "User index3";
    }
}
