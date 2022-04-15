package com.trindade.microservices.rest.controller;

import com.trindade.microservices.domain.entity.BusinessError;
import com.trindade.microservices.domain.exception.NotFoundException;
import com.trindade.microservices.domain.exception.PersonAlreadyExistsException;
import com.trindade.microservices.domain.service.PersonService;
import com.trindade.microservices.rest.mapper.PersonMapper;
import com.trindade.microservices.rest.mapper.PersonResponseMapper;
import com.trindade.microservices.rest.model.CreateOrUpdatePersonType;
import com.trindade.microservices.rest.model.PersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;


@RestController()
@RequestMapping("/api/v1/api-gateway")
public class ApiGatewayController {

    @Autowired
    PersonService service;

    @PostMapping("/person")
    public PersonResponse post(@RequestBody CreateOrUpdatePersonType person) {
        var entity = PersonMapper.from(person);
        return PersonResponseMapper.from(this.service.save(entity));
    }

    @GetMapping("/person/{taxId}")
    public PersonResponse getByTaxId(@PathVariable String taxId) {
        return PersonResponseMapper.from(this.service.getPersonByTaxId(taxId));
    }

    @GetMapping("/person")
    public List<PersonResponse> getAll() {
        return PersonResponseMapper.from(this.service.getAll());
    }

    @ExceptionHandler({ParseException.class, PersonAlreadyExistsException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<BusinessError> handleBadRequest(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BusinessError.builder()
                        .errorMessage(ex.getMessage())
                        .errorCode(HttpStatus.BAD_REQUEST.value())
                        .build());
    }

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<BusinessError> handleNotFound(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BusinessError.builder()
                        .errorMessage(ex.getMessage())
                        .errorCode(HttpStatus.NOT_FOUND.value())
                        .build());
    }

}

