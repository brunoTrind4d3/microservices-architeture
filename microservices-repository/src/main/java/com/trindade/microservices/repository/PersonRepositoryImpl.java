package com.trindade.microservices.repository;

import com.trindade.microservices.domain.entity.Person;
import com.trindade.microservices.domain.repository.PersonRepository;
import com.trindade.microservices.repository.db.postgres.PessoaOrmRepository;
import com.trindade.microservices.repository.db.postgres.mapper.PersonMapper;
import com.trindade.microservices.repository.db.postgres.mapper.PessoaOrmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @Autowired
    PessoaOrmRepository repository;

    @Override
    public Person getPersonByTaxId(String taxId) {
        var result = this.repository.findByCpf(taxId);
        return PersonMapper.from(result);
    }

    @Override
    public Person save(Person entity) {
        var result = this.repository.save(PessoaOrmMapper.from(entity));
        return PersonMapper.from(result);
    }

    @Override
    public List<Person> findAll() {
        return PersonMapper.from(this.repository.findAll());
    }
}
