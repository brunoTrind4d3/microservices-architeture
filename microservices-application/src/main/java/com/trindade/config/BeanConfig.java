package com.trindade.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.PersonService;


@Configuration
public class BeanConfig {

    @Bean
    PersonService personService(){
        return new PersonService();
    }
}
