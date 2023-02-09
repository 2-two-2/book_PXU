package com.pxu.dao;

import com.pxu.bean.OrderItem;
import com.pxu.dao.impl.OrderItemDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDaoTest {
OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Test
    public void saveOrderItem() {
        System.out.println(orderItemDao.saveOrderItem(new OrderItem(null, "Java", 1, new BigDecimal(100), new BigDecimal(100),"1")));
    }

    @Test
    public void queryOrderItemsByOrderId() {
    }
}