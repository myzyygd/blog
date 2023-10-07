package com.islide.blog.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.islide.blog.entity.LoginUserInfo;
import com.islide.blog.entity.Users;
import com.islide.blog.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserDetail implements UserDetailsService {

    private final IUserService userService;

    @Override
    public LoginUserInfo loadUserByUsername(String s) throws UsernameNotFoundException {
        Users user = userService.getOne(Wrappers.<Users>lambdaQuery().eq(Users::getName, s));
        if (ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        return new LoginUserInfo(user, getAuthorities(user));
    }

    public LoginUserInfo loadUserById(Integer userId) throws UsernameNotFoundException {
        Users user = userService.getOne(Wrappers.<Users>lambdaQuery().eq(Users::getId, userId));
        if (ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException("用户名存在");
        }

        return new LoginUserInfo(user, getAuthorities(user));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Users users) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        authorities.add(new SimpleGrantedAuthority("read"));
        return authorities;
    }
}
