package com.islide.blog;

import com.islide.blog.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    private IUserService userService;
    @Test
    void contextLoads() {
        System.out.println(userService.list());
    }

}
