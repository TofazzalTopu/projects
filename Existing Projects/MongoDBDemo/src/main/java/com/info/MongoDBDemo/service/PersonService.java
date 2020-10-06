package com.info.MongoDBDemo.service;

import com.info.MongoDBDemo.model.Person;
import com.info.MongoDBDemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mdtofazzal.hossain on 2/25/2019.
 */

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    //Create Person
    public Person create(String firstName, String lastName, Integer age){
        return personRepository.save(new Person(firstName,lastName,age));
    }

    //Retrieve
    public List<Person> getAll(){
        return personRepository.findAll();
    }

    public Person getByFirstName(String firstName){
        return personRepository.findByFirstName(firstName);
    }

    public Person findById(Integer id){
        return personRepository.findById(id);
    }

    //Update
    public Person update(String firstName, String lastName, Integer age){
        Person p = personRepository.findByFirstName(firstName);
        p.setLastName(lastName);
        p.setAge(age);
        return personRepository.save(p);
    }
    //delete All
    public void deleteAll(){
        personRepository.deleteAll();
    }
    //delete
    public void delete(String firstName){
        Person p = personRepository.findByFirstName(firstName);
        personRepository.delete(p);
    }



}
