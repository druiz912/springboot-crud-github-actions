package com.druiz.bosonit.integration.person.application;

import com.druiz.bosonit.integration.person.domain.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAllPersons();

    Person findPersonById(int id);

    Person savePerson(Person person);

    Person updatePerson(int id, Person person) throws Exception;

    List<Person> findPersonByName(String name);

    void deletePerson(int id);
}
