package com.dio.apiperson2.service;

import com.dio.apiperson2.entity.Address;
import com.dio.apiperson2.entity.Person;
import com.dio.apiperson2.repository.AddressRepository;
import com.dio.apiperson2.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService  {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ViaCepService viaCepService;

    public void addPerson(Person person){
        saveWithCep(person);
//        return personRepository.save(person);
    }


    private void saveWithCep(Person person) {
        String cep = person.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet( () -> {
             Address newAddress = viaCepService.consultarCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        person.setAddress(address);
        personRepository.save(person);
    }
}
