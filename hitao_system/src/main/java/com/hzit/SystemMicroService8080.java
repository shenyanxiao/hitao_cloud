package com.hzit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SystemMicroService8080 {
   public static void main(String[] args) {
	SpringApplication.run(SystemMicroService8080.class, args);
}
}
