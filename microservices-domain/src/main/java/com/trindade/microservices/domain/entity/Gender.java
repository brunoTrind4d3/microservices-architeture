package com.trindade.microservices.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    MALE(1, "Masculino"),
    FEMALE(2, "Feminino"),
    PREFER_NOT_SAY(3, "Não definido");

    private final Integer code;
    private final String description;

    public static Gender findByCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (Gender gender : Gender.values()) {
            if (gender.getCode().equals(code)) {
                return gender;
            }
        }
        return null;
    }

    public Gender findByName(String name) {
        if (name == null) {
            return null;
        }
        for (Gender gender : Gender.values()) {
            if (gender.getDescription().equals(name)) {
                return gender;
            }
        }
        return null;
    }

}
