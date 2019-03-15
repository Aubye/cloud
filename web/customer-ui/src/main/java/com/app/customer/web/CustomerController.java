package com.app.customer.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/customer")
public class CustomerController {

    @GetMapping
    public String hello() {
        return "Yes";
    }

}
