package com.trindade.microservices.rest.mapper;

import com.trindade.microservices.domain.entity.Person;
import com.trindade.microservices.domain.util.ConvertUtils;
import com.trindade.microservices.rest.model.CreateOrUpdatePersonType;
import lombok.experimental.UtilityClass;

import java.util.Optional;

@UtilityClass
public class PersonMapper {

    public static Person from(CreateOrUpdatePersonType model) {

        var optionalPerson = Optional.ofNullable(model);
        var name = optionalPerson.map(CreateOrUpdatePersonType::getName).orElse(null);
        var taxId = optionalPerson.map(CreateOrUpdatePersonType::getTaxId).orElse(null);
        var birthDate = optionalPerson.map(CreateOrUpdatePersonType::getBirthDate)
                .map(ConvertUtils::toDate).orElse(null);
        var email = optionalPerson.map(CreateOrUpdatePersonType::getEmail).orElse(null);
        var gender = optionalPerson.map(CreateOrUpdatePersonType::getGender).orElse(null);

        return Person.builder()
                .email(email)
                .name(name)
                .taxId(taxId)
                .birthDate(birthDate)
                .gender(gender)
                .build();
    }
}
