package com.example.mongodb_immersion_crud.Repository;

import com.example.mongodb_immersion_crud.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
