package com.pxu.servlet;

/**
 * @author
 * @Date:2022/12/5-21:35
 */

import com.pxu.bean.Book;
import com.pxu.bean.Cart;
import com.pxu.bean.CartItem;
import com.google.gson.Gson;
import com.pxu.service.BookService;
import com.pxu.service.impl.BookServiceImpl;
import com.pxu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends BaseServlet {

   /**
     * 加入购物车
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bookService = new BookServiceImpl();
        //获取请求的参数 id
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        //调用bookService.queryBookById(id)得到图书的信息
        Book book = bookService.queryBookById(id);
        //把图书信息转化为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //调用Cart.addItem(CartItem)添加商品项
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if(cart == null){
            //第一次创建购物车
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        //将最后一个添加的商品保存到session域中
        request.getSession().setAttribute("lastName",cartItem.getName());
        //重定向回原页面,http协议中有个请求头，会把当前地址栏地址发给服务器
        response.sendRedirect(request.getHeader("Referer"));
    }

    /**
     * ajax局部加入购物车
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxAddItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bookService = new BookServiceImpl();
        //获取请求的参数 id
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        //调用bookService.queryBookById(id)得到图书的信息
        Book book = bookService.queryBookById(id);
        //把图书信息转化为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //调用Cart.addItem(CartItem)添加商品项
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if(cart == null){
            //第一次创建购物车
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        //返回购物车总的商品数量和最后一个添加的商品名称
        Map<String, Object> map = new HashMap<>();
        map.put("totalCount",cart.getTotalCount());
        map.put("lastName", cartItem.getName());
        //以json响应流形式输出
        Gson gson = new Gson();
        String json = gson.toJson(map);
        response.getWriter().write(json);
    }

    /**
     * 删除商品项
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取商品编号
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        //获取购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null){
            cart.deleteItem(id);
            //重定向回原来购物车展示页面
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    /**
     * 清空购物车
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null){
            cart.clear();
            //重定向回原来购物车展示页面
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    /**
     * 修改商品数量
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的参数，商品编号及数量
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        int count = WebUtils.parseInt(request.getParameter("count"), 1);
        //获取购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if(cart != null){
            //修改商品数量
            cart.updateCount(id,count);
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

}
