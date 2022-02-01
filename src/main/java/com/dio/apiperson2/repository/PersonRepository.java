package com.dio.apiperson2.repository;

import com.dio.apiperson2.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
