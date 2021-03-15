package com.devits.laboratory.person.interfaces;

import java.util.List;

import com.devits.laboratory.person.entity.Person;
import com.devits.laboratory.person.response.template.PersonDemographicResponseTemplate;

public interface PersonService {
	
	public Person getPersonById(Long id);
	
	public PersonDemographicResponseTemplate getPersonDemographicById(Long id);
	
	public List<Person> getPersons();
	
	public Person savePerson(Person person);
	
	public Person updatePerson(Person person);
	
	public void deletePerson(Person person);

}
