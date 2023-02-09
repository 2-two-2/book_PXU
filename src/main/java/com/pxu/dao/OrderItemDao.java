package com.pxu.dao;

import com.pxu.bean.OrderItem;

import java.util.List;

/**
 * @author
 * @Date:2022/10/20-11:31
 */
public interface OrderItemDao {
    /**
     * 保存订单项
     * @param orderItem
     * @return
     */
    public int saveOrderItem(OrderItem orderItem);

    /**
     * 根据用户编号查询订单详情
     * @param orderId
     * @return
     */
    public List<OrderItem> queryOrderItemsByOrderId(String orderId);
}
