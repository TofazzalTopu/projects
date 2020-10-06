package com.info.MongoDBDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

//The @EnableHystrix annotation is used to enable the Hystrix functionalities into your Spring Boot application
@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication
public class MongoDbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbDemoApplication.class, args);
	}

}
