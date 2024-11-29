package com.example.ebay_service.service;

import com.example.ebay_service.controller.GreetingController;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingEbayService implements GreetingController {
    @Lazy
    private final EurekaClient eurekaClient;

    private final Environment environment;

    @Value("${spring.application.name}")
    private String appName;

    public GreetingEbayService(EurekaClient eurekaClient, Environment environment) {
        this.eurekaClient = eurekaClient;
        this.environment = environment;
    }

    @Override
    public String greeting() {
        return String.format("Hello from '%s' with %s!", eurekaClient.getApplication(appName).getName(), environment.getProperty("local.server.port"));
    }
}
