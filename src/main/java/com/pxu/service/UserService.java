package com.pxu.service;

import com.pxu.bean.User;

/**
 * @author
 * @Date:2022/12/1-21:35
 */
public interface UserService {
    /**
     * 处理用户注册业务
     * @param user
     * @return 返回影响行数,-1时表示注册失败
     */
    public int registerUser(User user);

    /**
     * 处理用户登录业务
     * @param username 用户名
     * @param password 密码
     * @return 当返回null时登录失败
     */
    public User login(String username, String password);

    /**
     * 检查用户名是否存在
     * @param username
     * @return 返回true时表示用户名已经存在
     */
    public boolean existsUser(String username);
}
