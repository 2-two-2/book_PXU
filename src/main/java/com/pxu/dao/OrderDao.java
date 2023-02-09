package com.pxu.dao;

import com.pxu.bean.Order;

import java.util.List;

/**
 * @author
 * @Date:2022/10/20-11:30
 */
public interface OrderDao {
    /**
     * 保存订单
     * @param order
     * @return
     */
    public int saveOrder(Order order);

    /**
     * 查询全部订单
     * @return  List<Order> 集合
     */
    public List<Order> queryOrders();

    /**
     * 修改订单状态
     * @param orderId
     * @param status 0:未发货;1:已发货;2:已签收
     * @return
     */
    public int changeOrderStatus(String orderId, Integer status);

    /**
     * 根据用户编号查询订单信息
     * @param userId
     * @return
     */
    public List<Order> queryOrdersByUserId(Integer userId);
}
