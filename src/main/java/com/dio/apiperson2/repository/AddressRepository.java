package com.dio.apiperson2.repository;

import com.dio.apiperson2.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,String> {


}
