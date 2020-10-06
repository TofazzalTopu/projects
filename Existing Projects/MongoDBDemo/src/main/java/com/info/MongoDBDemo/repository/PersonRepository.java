package com.info.MongoDBDemo.repository;

import com.info.MongoDBDemo.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mdtofazzal.hossain on 2/25/2019.
 */
@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
     Person findByFirstName(String firstName);
     Person findById(Integer id);
}
