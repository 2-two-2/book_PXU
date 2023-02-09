package com.pxu.service.impl;

import com.pxu.bean.User;
import com.pxu.dao.UserDao;
import com.pxu.dao.impl.UserDaoImpl;
import com.pxu.service.UserService;

/**
 * @author
 * @Date:2022/12/1-21:52
 */
public class UserServiceImpl implements UserService{
    private UserDao userDao = new UserDaoImpl();
    @Override
    public int registerUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public User login(String username, String password) {
        return userDao.queryUserByUsernameAndPassword(username, password);
    }

    @Override
    public boolean existsUser(String username) {
        if(userDao.queryUserByUsername(username) == null){
            return false;
        }
            return true;

    }
}
