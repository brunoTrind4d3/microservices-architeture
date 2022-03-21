package com.trindade.config;

import com.trindade.microservices.domain.service.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfig {

    @Bean
    PersonService personService(){
        return new PersonService();
    }
}
