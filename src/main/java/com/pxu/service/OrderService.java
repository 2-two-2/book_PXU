package com.pxu.service;

import com.pxu.bean.Cart;
import com.pxu.bean.Order;
import com.pxu.bean.OrderItem;

import java.util.List;

/**
 * @author
 * @Date:2022/11/20-13:05
 */
public interface OrderService {
    /**
     * 清空购物车，创建订单，返回订单号
     * @param cart 购物车
     * @param userId 用户Id
     * @return 订单号
     */

    public String createOrder(Cart cart, Integer userId);

    /**
     * 查询全部订单
     * @return List<Order>集合
     */
    public List<Order> showAllOrders();

    /**
     * 发货
     * @param orderId
     */
    public void sendOrder(String orderId);

    /**
     * 查看订单详情
     * @param orderId
     * @return List<OrderItem>集合
     */
    public List<OrderItem> showOrderDetail(String orderId);

    /**
     * 查看我的订单
     * @param userId
     * @return
     */
    public List<Order> showMyOrders(Integer userId);

    /**
     * 签收订单/确认收货
     * @param orderId
     */
    public void receiveOrder(String orderId);
}
