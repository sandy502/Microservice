package com.freecharge.user.service.userService.controllers;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class circuitBreakerEx {
    private Logger logger= LoggerFactory.getLogger(circuitBreakerEx.class);
    @GetMapping("/sample-api")
    @Retry(name="sample-api",fallbackMethod="hardcodedResponse")
    public String sampleApi() {
        logger.info("Sample Api call recieved");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy",String.class);
        return forEntity.getBody();
    }

    public String hardcodedResponse(Exception ex) {
        return "fallback-response";
    }
}
