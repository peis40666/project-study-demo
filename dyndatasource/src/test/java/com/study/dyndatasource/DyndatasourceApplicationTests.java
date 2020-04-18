package com.study.dyndatasource;

import com.study.dyndatasource.config.DynamicDataSourceConfig;
import com.study.dyndatasource.statics.dao.OrderDao;
import com.study.dyndatasource.statics.entity.OrderEntity;
import com.study.dyndatasource.statics.service.OrderService;
import com.study.dyndatasource.statics.service.OrderServiceImpl;
import com.study.dyndatasource.statics.service.OrderServiceStaticProxy;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.zip.DataFormatException;

@RunWith(SpringRunner.class)
@SpringBootTest
class DyndatasourceApplicationTests {

    @Test
    void contextLoads() {
    }


    @EnableConfigurationProperties({DynamicDataSourceConfig.class})
    @Configuration
    public static class DyndatasourceTests{
        @Bean
        public OrderDao orderDao(){
            return new OrderDao();
        }

        @Bean
        public OrderService orderService(){
            return new OrderServiceImpl();
        }

        @Bean
        public OrderServiceStaticProxy orderServiceStaticProxy(){
            return new OrderServiceStaticProxy();
        }


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

}
