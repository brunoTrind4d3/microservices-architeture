package com.trindade.microservices.domain.repository;

import com.trindade.microservices.domain.entity.Person;

import java.util.List;

public interface PersonRepository {

    Person getPersonByTaxId(String id);

    Person save(Person entity);

    List<Person> findAll();
}
