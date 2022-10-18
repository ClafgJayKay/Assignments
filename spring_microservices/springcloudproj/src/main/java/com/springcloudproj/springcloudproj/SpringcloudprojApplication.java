package com.springcloudproj.springcloudproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringcloudprojApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudprojApplication.class, args);
	}

}
