package com.study.dyndatasource;

import com.study.dyndatasource.statics.entity.OrderEntity;
import com.study.dyndatasource.statics.service.OrderService;
import com.study.dyndatasource.statics.service.OrderServiceStaticProxy;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = {"com.study.dyndatasource"})
class DyndatasourceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private OrderServiceStaticProxy proxy;

    @Test
    public void Test(){
        OrderEntity order1 = new OrderEntity();
        order1.setId("1");
        order1.setCreateTime(new Date().getTime());
        order1.setOrderInfo("{订单1}");
        System.out.println(order1.toString());
        proxy.createOrder(order1);

        OrderEntity order2 = new OrderEntity();
        order2.setId("1");
        order2.setCreateTime(new Date().getTime());
        order2.setOrderInfo("{订单2}");
        System.out.println(order2.toString());
        proxy.createOrder(order2);
    }

    @Autowired
    private OrderService orderService;



    @Test
    public void testAop(){
        OrderEntity order1 = new OrderEntity();
        order1.setId("1");
        order1.setCreateTime(1587818744477l);
        order1.setOrderInfo("{订单1}");
        System.out.println(order1.toString());
        orderService.createOrder(order1);
        OrderEntity order2 = new OrderEntity();
        order2.setId("1");
        order2.setCreateTime(1587818744478l);
        order2.setOrderInfo("{订单2}");
        System.out.println(order2.toString());
        orderService.createOrder(order2);
    }
}
