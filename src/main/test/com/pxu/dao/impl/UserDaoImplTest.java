package com.pxu.dao.impl;

import com.pxu.bean.User;
import com.pxu.dao.UserDao;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoImplTest {
    UserDao userdao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
//        System.out.println(userdao.queryUserByUsername("lisi"));
        if(userdao.queryUserByUsername("zhangsaan")==null){
            System.out.println("用户名可用");
        }else {
            System.out.println("用户名不可用");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
//        System.out.println(userdao.queryUserByUsernameAndPassword("zhangsan","111"));
            if(userdao.queryUserByUsernameAndPassword("zhangsan","111")==null){
                System.out.println("账号或者密码错误");
            }else {
                System.out.println("登录成功");
            }
    }

    @Test
    public void saveUser() {
//       System.out.println(userdao.saveUser(new User(null,"admin","admin","admin@qq.com")));
        if (userdao.saveUser(new User(null,"admin","admin","admin@qq.com"))==1){
            System.out.println("注册成功");
        }else {
            System.out.println("注册失败");
        }
    }
}