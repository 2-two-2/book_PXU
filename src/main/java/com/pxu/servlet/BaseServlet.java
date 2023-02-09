package com.pxu.servlet;

/**
 * @author
 * @Date:2022/10/15-21:22
 */

import com.pxu.service.UserService;
import com.pxu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class BaseServlet extends HttpServlet {
    public UserService userService = (UserService) new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决post请求中文乱码问题，一定要在请求参数之前调用才有效
        request.setCharacterEncoding("UTF-8");
        //解决响应中文乱码问题
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        try {
            //利用action鉴别字符串所对应的业务方法，反射获取方法对象
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            //调用目标业务方法，this是当前类对象的实例
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
            //把异常抛给servlet过滤器
            throw new RuntimeException(e);
        }
    }
}
