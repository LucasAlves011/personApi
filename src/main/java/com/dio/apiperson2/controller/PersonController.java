package com.dio.apiperson2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/persona")
public class PersonController {

    @GetMapping
    public String teste(){
        return "Primeiro commmit";
    }
}
