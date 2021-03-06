package com.trindade.microservices.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String id;
    private String name;
    private String taxId;
    private String email;
    private Date birthDate;
    private Gender gender;
    private Boolean active;

}
