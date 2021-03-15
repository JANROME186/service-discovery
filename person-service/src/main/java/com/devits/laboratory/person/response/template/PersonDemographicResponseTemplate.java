package com.devits.laboratory.person.response.template;

import com.devits.laboratory.person.entity.Person;
import com.devits.laboratory.person.pojo.Demographic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDemographicResponseTemplate {
	
	private Person person;
	private Demographic demographic;

}
