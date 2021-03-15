package com.devits.laboratory.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devits.laboratory.person.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
