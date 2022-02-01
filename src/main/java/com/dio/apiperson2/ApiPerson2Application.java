package com.dio.apiperson2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiPerson2Application {

    public static void main(String[] args) {
        SpringApplication.run(ApiPerson2Application.class, args);
    }

}
