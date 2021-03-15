package com.devits.laboratory.demographic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devits.laboratory.demographic.entities.Demographic;

@Repository
public interface DemographicRepository extends JpaRepository<Demographic, String> {

}
