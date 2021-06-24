package com.ecosoft.customer.customers.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.ToString;

@Configuration
@ConfigurationProperties(prefix = "app")
@Data
@ToString
public class AppConfiguration {

    //@Value("${name}")
    private String name;
    //@Value("${year}")
    private Integer year;
    //@Value("${edition}")
    private String edition;
    //@Value("${countries}")
    private String[] countries;

    @Value("${JAVA_HOME}")
    private String javaHome;

}
