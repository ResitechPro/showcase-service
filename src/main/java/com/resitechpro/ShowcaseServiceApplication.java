package com.resitechpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@EnableDiscoveryClient
@SpringBootApplication
public class ShowcaseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShowcaseServiceApplication.class, args);
    }

}
