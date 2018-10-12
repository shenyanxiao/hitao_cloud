package com.hzit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthcMicroService8082 {
public static void main(String[] args) {
	SpringApplication.run(AuthcMicroService8082.class, args);
}
}
