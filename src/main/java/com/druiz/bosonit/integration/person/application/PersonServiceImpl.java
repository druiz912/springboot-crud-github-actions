package com.druiz.bosonit.integration.person.application;

import com.druiz.bosonit.integration.person.domain.Person;
import com.druiz.bosonit.integration.person.infrastructure.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepo personRepo;

    @Override
    public List<Person> findAllPersons() {
        return personRepo.findAll();
    }

    @Override
    public Person findPersonById(int id) {
        return personRepo.findById(id).orElse(null);
    }

    @Override
    public Person savePerson(Person person) {
        return personRepo.save(person);
    }

    @Override
    public Person updatePerson(int id, Person person) throws Exception {
        Person personAux = new Person();
        if (personRepo.findById(id).isPresent()) {
            try {
                personAux.setName(person.getName());
                personAux.setSurname(person.getSurname());
                return personRepo.save(personAux);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                throw new Exception(e.getMessage());
            }
        }else{
            return personAux;
        }
    }

    @Override
    public List<Person> findPersonByName(String name) {
        return personRepo.findByName(name);
    }

    @Override
    public void deletePerson(int id) {
        personRepo.deleteById(id);
    }
}
