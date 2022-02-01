package com.dio.apiperson2.controller;

import com.dio.apiperson2.dto.request.PersonDTO;
import com.dio.apiperson2.exception.PersonNotFoundException;
import com.dio.apiperson2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO){
        personService.addPerson(personDTO);
        return ResponseEntity.created(URI.create("/person/"+ personDTO.getId())).body(personDTO);
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> listAll() {
        return ResponseEntity.ok(personService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> findById(@PathVariable Long id) throws PersonNotFoundException {
        PersonDTO p = personService.findById(id);
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> findByid(@PathVariable Long id) throws PersonNotFoundException {
        personService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
