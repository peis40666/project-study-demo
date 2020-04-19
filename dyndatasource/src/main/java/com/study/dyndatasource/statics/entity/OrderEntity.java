package com.study.dyndatasource.statics.entity;

import lombok.Data;

/**
 * 订单实体类
 */
@Data
public class OrderEntity {
    private String id;
    private Object orderInfo; // 订单的详细信息
    private Long createTime; //订单的创建时间
}
