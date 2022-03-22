package com.trindade.microservices.rest.controller;

import com.trindade.microservices.domain.entity.Person;
import com.trindade.microservices.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("/api/")
public class Controller {

    @Autowired
    PersonService service;

    @GetMapping("name/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public Person getName(@RequestHeader String authorization, @PathVariable String id){
        return this.service
        		.getPersonById(id);
    }
}

