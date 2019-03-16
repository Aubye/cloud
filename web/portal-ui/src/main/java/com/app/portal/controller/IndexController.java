package com.app.portal.controller;

import com.app.common.utils.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BeanMapper beanMapper;

    @GetMapping("/test")
    public String getSystems() {
        String bodyA = restTemplate.getForEntity("http://EUREKA-SERVER/actuator", String.class).getBody();
        System.out.println(bodyA);
        String body = restTemplate.getForEntity("http://SYSTEM-SERVICE/user", String.class).getBody();
        System.out.println(body);
        return "abc";
    }

}
