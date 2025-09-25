package com.islide.blog;

import com.alibaba.druid.pool.DruidDataSource;
import com.islide.blog.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    private IUserService userService;
    @Autowired
    private DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {

    }

}
