package com.pxu.servlet;

/**
 * @author iller
 * @Date:2022/11/15-20:19
 */

import com.pxu.bean.User;
import com.google.gson.Gson;
import com.pxu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends BaseServlet {
    /**
     * AJAX请求验证用户名是否存在
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxExistsUserName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String userName = request.getParameter("userName");
        //调用service层的方法验证
        boolean existsUser = userService.existsUser(userName);
        //把获取的参数封装成为map对象
        Map<String, Object> map = new HashMap<>();
        map.put("existsUser", existsUser);
        //将json字符传通过输出流的形式返回
        Gson gson = new Gson();
        String json = gson.toJson(map);
        response.getWriter().write(json);
    }

    /**
     * 处理登录业务
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //调用UserService.login()方法判断是否登录成功
        User loginUser = userService.login(username, password);
        if(loginUser == null){
            //把错误信息和回显表单保存到Request域中
            request.setAttribute("msg", "用户名或密码错误");
            request.setAttribute("username", username);
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }else{
            //登录成功
            //保存用户登录成功后的信息到session域中
            request.getSession().setAttribute("User", loginUser);
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
        }
    }

    /**
     * 处理注销业务
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.销毁session中用户登录的信息
        request.getSession().invalidate();
        //2.重定向到首页 /book
        response.sendRedirect(request.getContextPath());
    }
    /**
     * 处理注册业务
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的参数信息
        String code = request.getParameter("code");
        //获取请求参数注入到javabean对象中
        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());
        //获取session中的验证码,并删除
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //判断验证码是否正确
        if(token.equalsIgnoreCase(code) && token!=null){
            //判断用户名是否存在
            if(userService.existsUser(user.getUsername())){
                //用户存在
                request.setAttribute("msg", "用户名已存在");
                request.setAttribute("username", user.getUsername());
                request.setAttribute("password", user.getPassword());
                request.setAttribute("email", user.getEmail());
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);;

            }else{
                //用户成功注册
                userService.registerUser(user);
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
            }
        }else{
            //验证码错误
            request.setAttribute("msg", "验证码错误");
            request.setAttribute("username", user.getUsername());
            request.setAttribute("password", user.getPassword());
            request.setAttribute("email", user.getEmail());
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
        }
    }
}
