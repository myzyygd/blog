package com.islide.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.islide.blog.entity.Users;
import com.islide.blog.mapper.UserMapper;
import com.islide.blog.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, Users> implements IUserService {
}
