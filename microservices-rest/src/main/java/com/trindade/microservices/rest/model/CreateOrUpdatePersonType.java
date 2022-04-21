package com.trindade.microservices.rest.model;

import com.trindade.microservices.domain.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrUpdatePersonType {

    @NotBlank(message = "Name must be informed")
    private String name;

    @NotBlank(message = "TaxId must be informed")
    private String taxId;

    @NotBlank(message = "Birth date must be informed")
    private String birthDate;

    @NotBlank(message = "Email must be informed")
    private String email;

    @NotNull(message = "Gender must be informed")
    private Gender gender;
}
