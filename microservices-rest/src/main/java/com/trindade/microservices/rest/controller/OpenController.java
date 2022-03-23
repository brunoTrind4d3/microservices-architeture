package com.trindade.microservices.rest.controller;

import com.trindade.microservices.domain.entity.Person;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/v1/open/")
public class OpenController {


    @GetMapping("user/{id}")
    public Person getName(@RequestHeader String authorization, @PathVariable String id){
        return Person.builder().name("USUARIO LIVRE").build();
    }

}
