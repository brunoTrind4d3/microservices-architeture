package com.trindade.microservices.domain.service;

import com.trindade.microservices.domain.entity.Person;
import com.trindade.microservices.domain.exception.NotFoundException;
import com.trindade.microservices.domain.exception.PersonAlreadyExistsException;
import com.trindade.microservices.domain.repository.PersonRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    public Person getPersonByTaxId(String taxId) {
        var person = this.repository.getPersonByTaxId(taxId);
        if (person == null) {
            throw new NotFoundException("Person not found");
        }
        return person;
    }

    public List<Person> getAll() {
        return this.repository.findAll();
    }

    public Person save(Person entity) {
        var person = this.repository.getPersonByTaxId(entity.getTaxId());
        if (person != null) {
            throw new PersonAlreadyExistsException("Person already exists");
        }
        if (entity.getId() == null) {
            entity.setId(UUID.randomUUID().toString());
            entity.setActive(Boolean.TRUE);
        }
        return this.repository.save(entity);
    }

}
