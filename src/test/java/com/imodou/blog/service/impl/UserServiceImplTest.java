package com.imodou.blog.service.impl;

import com.imodou.blog.BlogApplication;
import com.imodou.blog.pojo.User;
import com.imodou.blog.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogApplication.class)
public class UserServiceImplTest {

    @Autowired
    UserService userService;


    @Test
    public void add() {

        User user = new User();
        user.setUserName("dabao");

        userService.add(user);
    }
}