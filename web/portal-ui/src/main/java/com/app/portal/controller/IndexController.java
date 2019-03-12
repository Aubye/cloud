package com.app.portal.controller;

import com.app.portal.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@RestController("/index")
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BeanMapper beanMapper;

    @GetMapping("/user")
    @PostConstruct
    public String getSystems() {
        return restTemplate.getForEntity("http://SYSTEM-SERVICE/user", String.class).getBody();
    }

}
