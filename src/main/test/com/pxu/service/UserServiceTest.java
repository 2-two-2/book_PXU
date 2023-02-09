package com.pxu.service;

import com.pxu.bean.User;
import com.pxu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
        UserService us = new UserServiceImpl();
    @Test
    public void registerUser() {
        System.out.println(us.registerUser(new User(null,"root","root","root@qq.com")));
    }

    @Test
    public void login() {
        System.out.println(us.login("admin","admin"));
    }

    @Test
    public void existsUser() {
        if (us.existsUser("admin")){
            System.out.println("用户名已存在");
        }else {
            System.out.println("用户名可用");
        }
    }
}