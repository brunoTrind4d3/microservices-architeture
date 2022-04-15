package com.trindade.microservices.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponse {

    private String id;
    private String name;
    private String taxId;
    private String email;
    private String birthDate;
    private String gender;
    private Boolean active;

}
