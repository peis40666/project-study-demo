package com.study.dyndatasource.statics.service;

import com.study.dyndatasource.config.DynamicDataSourceConfig;
import com.study.dyndatasource.statics.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderServiceStaticProxy")
public class OrderServiceStaticProxy implements OrderService{

    @Autowired
    private OrderService orderService;

    @Autowired
    private DynamicDataSourceConfig config;


    @Override
    public int createOrder(OrderEntity order) {
        before(order.getCreateTime());
        return orderService.createOrder(order);
    }


    private void before(Long createTime){
        //根据时间戳 奇数就路由到mysql_1,偶数就路由到mysql_2
        config.router(getOddOrEven(createTime));
    }


    /**
     * 判断是奇数还是偶数
     * 奇数返回1
     * 偶数返回2
     * @param x
     * @return
     */
    private int getOddOrEven(Long x){
        if(x % 2 == 0){
            return 2;
        }
        return 1;
    }
}
