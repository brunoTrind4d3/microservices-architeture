package com.trindade.microservices.repository.db.postgres.mapper;

import com.trindade.microservices.domain.entity.Gender;
import com.trindade.microservices.domain.entity.Person;
import com.trindade.microservices.domain.util.ConvertUtils;
import com.trindade.microservices.repository.db.postgres.orm.PessoaOrm;
import lombok.experimental.UtilityClass;

import java.util.Optional;
import java.util.UUID;

@UtilityClass
public class PessoaOrmMapper {

    public static PessoaOrm from(Person entity) {
        var optional = Optional.ofNullable(entity);
        var id = optional.map(Person::getId).orElse(UUID.randomUUID().toString());
        var nome = optional.map(Person::getName).orElse(null);
        var cpf = optional.map(Person::getTaxId).orElse(null);
        var email = optional.map(Person::getEmail).orElse(null);
        var genero = optional.map(Person::getGender).map(Gender::getCode).orElse(null);
        var dataNascimento = optional.map(Person::getBirthDate).orElse(null);
        var ativo = optional.map(Person::getActive).map(ConvertUtils::toIndicator).orElse("N");

        return PessoaOrm.builder()
                .id(id)
                .nome(nome)
                .cpf(cpf)
                .genero(genero)
                .email(email)
                .dataNascimento(dataNascimento)
                .ativo(ativo)
                .build();
    }
}
