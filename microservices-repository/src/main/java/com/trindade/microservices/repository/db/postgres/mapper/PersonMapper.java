package com.trindade.microservices.repository.db.postgres.mapper;

import com.trindade.microservices.domain.entity.Gender;
import com.trindade.microservices.domain.entity.Person;
import com.trindade.microservices.domain.util.ConvertUtils;
import com.trindade.microservices.repository.db.postgres.orm.PessoaOrm;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@UtilityClass
public class PersonMapper {

    public static Person from(PessoaOrm orm) {
        if (orm == null) {
            return null;
        }
        var optional = Optional.of(orm);
        var id = optional.map(PessoaOrm::getId).orElse(null);
        var name = optional.map(PessoaOrm::getNome).orElse(null);
        var taxId = optional.map(PessoaOrm::getCpf).orElse(null);
        var email = optional.map(PessoaOrm::getEmail).orElse(null);
        var gender = optional.map(PessoaOrm::getGenero).map(Gender::findByCode).orElse(null);
        var birthDate = optional.map(PessoaOrm::getDataNascimento).orElse(null);
        var active = optional.map(PessoaOrm::getAtivo).map(ConvertUtils::toBoolean).orElse(Boolean.FALSE);
        return Person.builder()
                .id(id)
                .name(name)
                .taxId(taxId)
                .email(email)
                .gender(gender)
                .birthDate(birthDate)
                .active(active)
                .build();
    }

    public static List<Person> from(List<PessoaOrm> orms) {
        if (orms.isEmpty()) {
            return new ArrayList<>();
        }
        return orms.stream().map(PersonMapper::from).collect(Collectors.toList());
    }
}
