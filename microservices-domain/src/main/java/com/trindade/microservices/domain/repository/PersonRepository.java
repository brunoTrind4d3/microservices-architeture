package com.trindade.microservices.domain.repository;

import com.trindade.microservices.domain.entity.Person;

public interface PersonRepository {

    Person getPersonById(String id);
}
