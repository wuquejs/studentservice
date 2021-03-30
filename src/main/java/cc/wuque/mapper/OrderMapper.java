package cc.wuque.mapper;

import cc.wuque.domain.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单的mapper接口
 * @Author 无缺
 * @Date 2021/3/30 15:38
 */
@Mapper
public interface OrderMapper {

    void addOrder(Order order);

    Order findOrderByOid(int oid);

    String findS_uidByOid(int oid);

    String findB_uidByOid(int oid);

    void updateOrder(int stater,int oid);
}
