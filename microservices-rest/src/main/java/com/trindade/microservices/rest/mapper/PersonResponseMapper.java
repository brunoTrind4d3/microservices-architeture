package com.trindade.microservices.rest.mapper;

import com.trindade.microservices.domain.entity.Gender;
import com.trindade.microservices.domain.entity.Person;
import com.trindade.microservices.domain.util.ConvertUtils;
import com.trindade.microservices.rest.model.PersonResponse;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@UtilityClass
public class PersonResponseMapper {

    public static PersonResponse from(Person person) {

        var optionalPerson = Optional.ofNullable(person);
        var id = optionalPerson.map(Person::getId).orElse(null);
        var name = optionalPerson.map(Person::getName).orElse(null);
        var taxId = optionalPerson.map(Person::getTaxId).orElse(null);
        var birthDate = optionalPerson.map(Person::getBirthDate).map(ConvertUtils::dateToString).orElse(null);
        var email = optionalPerson.map(Person::getEmail).orElse(null);
        var gender = optionalPerson.map(Person::getGender).map(Gender::getDescription).orElse(null);
        var active = optionalPerson.map(Person::getActive).orElse(Boolean.FALSE);

        return PersonResponse.builder()
                .id(id)
                .email(email)
                .name(name)
                .taxId(taxId)
                .birthDate(birthDate)
                .gender(gender)
                .active(active)
                .build();
    }

    public static List<PersonResponse> from(List<Person> entity) {
        if (entity.isEmpty()) {
            return new ArrayList<>();
        }
        return entity.stream().map(PersonResponseMapper::from).collect(Collectors.toList());
    }
}
