package com.springcloudproj.service1;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("service1")
@RestController
public class SampleController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @GetMapping("sampleget")
    public String callAPI(){
        String response = restTemplate.getForObject("http://localhost:8082/sampleapi", String.class);

        System.out.println("another service response is: "+response);
        return response;
    }

    private String callWhenError(){
        return "error when calling the api";
    }

    @GetMapping("samplegettest")
    public String GetList(){
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
        String url = "https://jsonplaceholder.typicode.com/albums";

        return circuitBreaker.run(()->restTemplate.getForObject(url,String.class),
            throwable -> callWhenError());
    }
}