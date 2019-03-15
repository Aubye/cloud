package com.app.portal.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testRest() {
        String body = restTemplate.getForEntity("http://CUSTOMER-UI/customer?a=10&b=20", String.class).getBody();
        System.out.println(body);
    }

}
