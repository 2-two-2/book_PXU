package com.pxu.dao.impl;

import com.pxu.bean.OrderItem;
import com.pxu.dao.BaseDao;
import com.pxu.dao.OrderItemDao;

import java.util.List;

/**
 * @author
 * @Date:2022/11/20-11:35
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`, `count`, `price`, `total_price`, `order_id`) values(?,?,?,?,?)";
        return update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderItemsByOrderId(String orderId) {
        String sql = "select `id`, `name`, `count`, `price`, `total_price` totalPrice, `order_id` orderId " +
                "from t_order_item where `order_id`=?";
        return queryForList(sql,OrderItem.class, orderId);
    }
}
