package com.technical.springboot.matepore.Springboot_Technical_Interview.repositories;

import com.technical.springboot.matepore.Springboot_Technical_Interview.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}