package com.oct2022springeureka.oct2022springeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Oct2022springeurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oct2022springeurekaApplication.class, args);
	}

}
