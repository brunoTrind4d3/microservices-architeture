package com.trindade.microservices.rest.controller;

import com.trindade.microservices.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/api/")
public class Controller {

    @Autowired
    PersonService service;

    @GetMapping("name")
    public String getName(){
        return this.service
        		.getPerson()
        		.getName();
    }
}
