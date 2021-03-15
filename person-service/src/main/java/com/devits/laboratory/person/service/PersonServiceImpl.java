package com.devits.laboratory.person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.devits.laboratory.person.entity.Person;
import com.devits.laboratory.person.interfaces.PersonService;
import com.devits.laboratory.person.pojo.Demographic;
import com.devits.laboratory.person.repository.PersonRepository;
import com.devits.laboratory.person.response.template.PersonDemographicResponseTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public Person getPersonById(Long id) {
		log.info("getPersonById in PersonServiceImpl");
		return this.personRepository.findById(id).get();
	}

	@Override
	public List<Person> getPersons() {
		log.info("getPersons in PersonServiceImpl");
		return this.personRepository.findAll();
	}

	@Override
	public Person savePerson(Person person) {
		log.info("savePerson in PersonServiceImpl");
		return this.personRepository.save(person);
	}

	@Override
	public Person updatePerson(Person person) {
		log.info("updatePerson in PersonServiceImpl");
		return this.personRepository.save(person);
	}

	@Override
	public void deletePerson(Person person) {
		log.info("deletePerson in PersonServiceImpl");
		this.personRepository.delete(person);
	}

	@Override
	public PersonDemographicResponseTemplate getPersonDemographicById(Long id) {
		PersonDemographicResponseTemplate personDemographic = new PersonDemographicResponseTemplate();
		personDemographic.setPerson(this.personRepository.findById(id).get());
		personDemographic.setDemographic(this.restTemplate.getForObject(
				"http://DEMOGRAPHIC-SERVICE/demographic/get/" + personDemographic.getPerson().getReferenceId(),
				Demographic.class));
		return personDemographic;
	}

}
