package com.example.mongodb_immersion_crud.Repository;

import com.example.mongodb_immersion_crud.Models.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends MongoRepository<Address,String> {
}
