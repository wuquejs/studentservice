package cc.wuque.service.impl;

import cc.wuque.domain.Order;
import cc.wuque.mapper.OrderMapper;
import cc.wuque.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单service的实现类
 * @Author 无缺
 * @Date 2021/3/30 15:37
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void addOrder(Order order) {
        orderMapper.addOrder(order);
    }

    @Override
    public Order findOrderByOid(int oid) {
        return orderMapper.findOrderByOid(oid);
    }

    @Override
    public String findS_uidByOid(int oid) {
        return orderMapper.findS_uidByOid(oid);
    }

    @Override
    public String findB_uidByOid(int oid) {
        return orderMapper.findB_uidByOid(oid);
    }

    @Override
    public void updateOrder(int stater) {
        orderMapper.updateOrder(stater);
    }
}
