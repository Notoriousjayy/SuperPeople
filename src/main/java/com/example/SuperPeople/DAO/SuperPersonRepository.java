package com.example.SuperPeople.DAO;

import com.example.SuperPeople.Entity.SuperPerson;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SuperPersonRepository extends MongoRepository<SuperPerson, String> {
    Optional<SuperPerson> findPersonByName(String name);
    Optional<SuperPerson> findPersonById(String id);
}
