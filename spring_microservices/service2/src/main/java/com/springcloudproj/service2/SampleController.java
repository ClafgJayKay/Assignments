package com.springcloudproj.service2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("service2")
public class SampleController {
    @GetMapping("sampleapi")
    public String getResponse(){
        return ("Response from Service 2");
    }
}