package com.consultadd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.naming.ServiceUnavailableException;
import java.net.URI;
import java.util.Optional;

@RestController
public class MessageController {

    @Autowired
    private DiscoveryClient discoveryClient;
    private final RestTemplate restTemplate;

    public MessageController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Optional<URI> serviceUrl(){
        return discoveryClient.getInstances("demoB")
                .stream()
                .findFirst()
                .map(si-> si.getUri());
    }

    @GetMapping("/callB")
    public String discoveryMsg() throws RestClientException,ServiceUnavailableException {
        URI service = serviceUrl()
                .map(s -> s.resolve("/msg"))
                .orElseThrow(ServiceUnavailableException::new);

        return this.restTemplate.getForEntity(service, String.class).getBody();
    }
}
