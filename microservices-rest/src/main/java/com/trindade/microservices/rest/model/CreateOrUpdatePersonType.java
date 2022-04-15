package com.trindade.microservices.rest.model;

import com.trindade.microservices.domain.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrUpdatePersonType {
    private String name;
    private String taxId;
    private String birthDate;
    private String email;
    private Gender gender;
}
