package cc.wuque.service;

import cc.wuque.domain.Order;

/**
 * 订单的service层
 * @Author 无缺
 * @Date 2021/3/30 15:37
 */
public interface OrderService {

    //添加订单信息
    void addOrder(Order order);

    /**
     * 根据订单id查询订单信息
     * @Author 无缺
     * @Date 2021/3/30 16:45
     * @param oid
     * @return
     */
    Order findOrderByOid(int oid);

    /**
     * 根据oid查询卖家id
     * @Author 无缺
     * @Date 2021/3/30 16:52
     * @param oid
     * @return s_uid
     */
    String findS_uidByOid(int oid);

    /**
     * 根据oid查询买家id
     * @Author 无缺
     * @Date 2021/3/30 16:52
     * @param oid
     * @return b_uid
     */
    String findB_uidByOid(int oid);

    void updateOrder(int stater);
}
