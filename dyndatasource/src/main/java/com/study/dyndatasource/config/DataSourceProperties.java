package com.study.dyndatasource.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
public class DataSourceProperties {
    private String userName;

    private String password;

    private String driverClassName;

    private String url;


}
