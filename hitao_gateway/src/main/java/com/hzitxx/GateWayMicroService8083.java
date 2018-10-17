package com.hzitxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) //阻止spring boot自动注入dataSource bean
@EnableDiscoveryClient  
@EnableZuulProxy
public class GateWayMicroService8083 {
public static void main(String[] args) {
	SpringApplication.run(GateWayMicroService8083.class, args);
}
}
