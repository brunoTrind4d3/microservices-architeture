package com.trindade.microservices.domain.service;


import com.trindade.microservices.domain.entity.Person;

public class PersonService {

    public Person getPerson(){
        return Person.builder().name("Fulano").build();
    }

}
