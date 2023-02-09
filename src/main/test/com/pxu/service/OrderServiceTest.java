package com.pxu.service;

import com.pxu.bean.Cart;
import com.pxu.bean.CartItem;
import com.pxu.bean.OrderItem;
import com.pxu.dao.OrderItemDao;
import com.pxu.dao.impl.OrderItemDaoImpl;
import com.pxu.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceTest {
    OrderService orderService = new OrderServiceImpl();
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    Cart cart = new Cart();

    @Test
    public void createOrder() {
        cart.addItem(new CartItem(1,"郭敬红传奇",1,new BigDecimal(1000),new BigDecimal(2000)));
        cart.addItem(new CartItem(2,"刘林伟传奇",1,new BigDecimal(1000),new BigDecimal(2000)));
        cart.addItem(new CartItem(1,"郭敬红传奇",1,new BigDecimal(1000),new BigDecimal(2000)));
        cart.addItem(new CartItem(1,"郭敬红传奇",1,new BigDecimal(1000),new BigDecimal(2000)));
        System.out.println("订单号是："+orderService.createOrder(cart, 1));
    }

    @Test
    public void showAllOrders() {
        System.out.println(orderService.showAllOrders());
    }

    @Test
    public void sendOrder() {
    }

    @Test
    public void showOrderDetail() {
    }

    @Test
    public void showMyOrders() {
    }

    @Test
    public void receiveOrder() {
    }
}