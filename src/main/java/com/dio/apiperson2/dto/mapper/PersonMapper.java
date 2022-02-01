package com.dio.apiperson2.dto.mapper;

import com.dio.apiperson2.dto.request.PersonDTO;
import com.dio.apiperson2.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(source = "birthDate", target = "birthDate" , dateFormat = "dd/MM/yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);


}
