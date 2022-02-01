package com.dio.apiperson2.controller;

import com.dio.apiperson2.entity.Person;
import com.dio.apiperson2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        personService.addPerson(person);
        return ResponseEntity.created(URI.create("/person/"+ person.getId())).body(person);
    }

    @GetMapping
    public String teste(){
        return "Primeiro commmit";
    }
}
