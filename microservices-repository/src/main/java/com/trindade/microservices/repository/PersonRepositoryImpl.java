package com.trindade.microservices.repository;

import com.trindade.microservices.domain.entity.Person;
import com.trindade.microservices.domain.repository.PersonRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @Override
    public Person getPersonById(String id) {
        return Person.builder().id(id).name("Teste Repository").build() ;
    }
}
