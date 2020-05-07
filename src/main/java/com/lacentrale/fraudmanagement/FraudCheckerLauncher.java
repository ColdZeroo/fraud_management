package com.lacentrale.fraudmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.lacentrale.fraudmanagement.rulesengine," +
        "com.lacentrale.fraudmanagement.services," +
        "com.lacentrale.fraudmanagement.configuration")
public class FraudCheckerLauncher {
    public static void main(String[] args) {
        SpringApplication.run(FraudCheckerLauncher.class, args);
    }
}
