package com.dio.apiperson2.controller;

import com.dio.apiperson2.entity.Person;
import com.dio.apiperson2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        personService.addPerson(person);
        return ResponseEntity.ok(person);
    }

    @GetMapping
    public String teste(){
        return "Primeiro commmit";
    }
}
