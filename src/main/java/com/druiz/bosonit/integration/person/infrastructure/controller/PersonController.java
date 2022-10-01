package com.druiz.bosonit.integration.person.infrastructure.controller;

import com.druiz.bosonit.integration.person.application.PersonService;
import com.druiz.bosonit.integration.person.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
@Slf4j
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.findAllPersons();
    }


    @GetMapping("/name/{name}")
    public List<Person> getPersonByName(@PathVariable String name){
        return personService.findPersonByName(name);
    }

    @GetMapping("{id}")
    public Person getPersonById(@PathVariable int id){
        return personService.findPersonById(id);
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @PutMapping
    public Person updatePerson(@PathVariable int id ,@RequestBody Person person) throws Exception {
        return personService.updatePerson(id,person);
    }

    @DeleteMapping
    public void deletePerson(@PathVariable int id){
        personService.deletePerson(id);
        if(personService.findPersonById(id) != null){
            throw new IllegalStateException("No se pudo borrar la persona");
        } else {
            log.info("La persona se borró correctamente");
        }
    }

}
