package service;

import entity.Person;

public class PersonService {

    public Person getPerson(){
        return Person.builder().name("Fulano").build();
    }

}
