package com.trindade.config;

import com.trindade.microservices.domain.repository.PersonRepository;
import com.trindade.microservices.domain.service.PersonService;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfig {

    @Bean
    PersonService personService(PersonRepository repository){
        return new PersonService(repository);
    }

    @Bean
    public KeycloakSpringBootConfigResolver keycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }
}
