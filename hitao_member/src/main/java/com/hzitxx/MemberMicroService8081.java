package com.hzitxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MemberMicroService8081 {
public static void main(String[] args) {
	SpringApplication.run(MemberMicroService8081.class, args);
}
}
