package com.example;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@MapperScan(basePackages = "com.example.mapper" )
class BlogApplicationTests {
    @Resource
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {  //检查mybatis
        User user = userMapper.selectByPrimaryKey((long) 1);
        System.out.println(user.toString());
    }
    @Test
    void chalkMethode(){ // 检查service层的方法
        User user =new User();
        user.setUsername("admin");
        user.setPassword("admin");
        User checkUser = userService.checkUser(user);
        System.out.println("查询结果："+checkUser.toString());
    }

}
