package com.pxu.filter;

/**
 * @author
 * @Date:2022/10/21-13:51
 */

import com.pxu.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebFilter(filterName = "ManagerFilter")
public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
    }
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        //获取session域中的用户
        User user = (User) httpServletRequest.getSession().getAttribute("User");
        //定义管理员名单
        Map<String, Boolean> map = new HashMap<>();
        map.put("admin",true); map.put("root",true);
        map.put("admin888",true); map.put("root888", true);
        if(user == null){
            //请求转发到登录页面
            httpServletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }else if (map.getOrDefault(user.getUsername(),false)) {
            //管理员权限，继续访问资源
            chain.doFilter(request, response);
        }else{
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath());
        }

    }
}
