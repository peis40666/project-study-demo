package com.study.dyndatasource.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "dynamic")
public class DynamicDataSourceConfig {
    private String primary;

    private Map<String,DataSourceProperties> dataSource = new HashMap<>();

    //**为了简述原理，这里提供一个路由方法
    public void router(Integer router){
        String dbnameprefix = "mysql_";
        System.out.println("动态分配数据源名称："+dbnameprefix+router);
        //打印数据源信息
        System.out.println("打印数据源信息"+dataSource.get(dbnameprefix+router).toString());
    }
}
