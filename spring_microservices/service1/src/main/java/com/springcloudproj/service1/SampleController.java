package com.springcloudproj.service1;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("service1")
@RestController
public class SampleController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("sampleget")
    public String callAPI(){
        String response = restTemplate.getForObject("http://localhost:8082/sampleapi", String.class);

        System.out.println("another service response is: "+response);
        return response;
    }
}