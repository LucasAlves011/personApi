package com.dio.apiperson2.service;

import com.dio.apiperson2.dto.mapper.PersonMapper;
import com.dio.apiperson2.dto.request.PersonDTO;
import com.dio.apiperson2.entity.Address;
import com.dio.apiperson2.entity.Person;
import com.dio.apiperson2.repository.AddressRepository;
import com.dio.apiperson2.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService  {

    @Autowired
    ViaCepService viaCepService;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;
    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public PersonService(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    public void addPerson(PersonDTO personDTO){
        saveWithCep(personDTO);
    }


    private void saveWithCep(PersonDTO personDTO) {
        String cep = personDTO.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet( () -> {
             Address newAddress = viaCepService.consultarCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        personDTO.setAddress(address);
        Person bufferPerson = personMapper.toModel(personDTO);
        personRepository.save(bufferPerson);

    }
}
