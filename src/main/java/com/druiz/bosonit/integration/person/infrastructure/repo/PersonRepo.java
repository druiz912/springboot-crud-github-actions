package com.druiz.bosonit.integration.person.infrastructure.repo;

import com.druiz.bosonit.integration.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person, Integer> {

    List<Person> findByName(String name);

}
