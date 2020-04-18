package com.study.dyndatasource.statics.dao;

import com.study.dyndatasource.statics.entity.OrderEntity;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {
    public int insert(OrderEntity order){
        System.out.println("创建订单成功");
        return 1;
    }
}
