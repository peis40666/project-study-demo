package com.study.dyndatasource.statics.service;

import com.study.dyndatasource.statics.dao.OrderDao;
import com.study.dyndatasource.statics.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public int createOrder(OrderEntity order) {
        System.out.println("OrderService调用orderDao创建订单订单");
        return orderDao.insert(order);
    }
}
