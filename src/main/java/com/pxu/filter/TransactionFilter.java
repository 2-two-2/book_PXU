package com.pxu.filter;

/**
 * @author
 * @Date:2022/11/21-16:30
 */

import com.pxu.utils.JdbcUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "TransactionFilter")
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
    }
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            chain.doFilter(request, response);
            //提交事务并释放资源

        } catch (Exception e) {
            e.printStackTrace();
            //把异常继续抛给Tomcat服务器，做统一异常管理展示
            throw new RuntimeException(e);
        }
    }
}
