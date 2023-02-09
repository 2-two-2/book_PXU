package com.pxu.dao;

import com.pxu.bean.Order;
import com.pxu.dao.impl.OrderDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoTest {
        OrderDao orderDao = new OrderDaoImpl();
    @Test
    public void saveOrder() {
        //orderId是主键
        System.out.println(orderDao.saveOrder(new Order("1234544", "2022-12-5", new BigDecimal(999), 0, 55)));
    }

    @Test
    public void queryOrders() {
        System.out.println(orderDao.queryOrders());

    }

    @Test
    public void changeOrderStatus() {
        System.out.println(orderDao.changeOrderStatus("1", 5));
    }

    @Test
    public void queryOrdersByUserId() {
        System.out.println(orderDao.queryOrdersByUserId(6));
    }
}