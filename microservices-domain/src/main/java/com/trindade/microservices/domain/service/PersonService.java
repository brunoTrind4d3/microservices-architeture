package com.trindade.microservices.domain.service;


import com.trindade.microservices.domain.entity.Person;
import com.trindade.microservices.domain.repository.PersonRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    public Person getPersonById(String id) {
        return repository.getPersonById(id);
//        return Person.builder()
//                .id(id)
//                .name("Teste de nome")
//                .build();
    }

}
