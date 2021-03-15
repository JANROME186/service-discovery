package com.devits.laboratory.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devits.laboratory.person.entity.Person;
import com.devits.laboratory.person.interfaces.PersonService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@ApiOperation(value = "Service to save Person in Data Base")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully Created Person.", response = Person.class),
			@ApiResponse(code = 500, message = "Internal server error.", response = Exception.class),
			@ApiResponse(code = 404, message = "Unable to find contracts", response = Exception.class) })
	@PostMapping(value = "/save")
	public ResponseEntity<Object> savePerson(@RequestBody Person person) {
		log.info("Inside savePerson of PersonController");
		return new ResponseEntity<>(this.personService.savePerson(person), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Service to update Person in Data Base")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully Updated Person.", response = Person.class),
			@ApiResponse(code = 500, message = "Internal server error.", response = Exception.class),
			@ApiResponse(code = 404, message = "Unable to find contracts", response = Exception.class) })
	@PostMapping(value = "/update")
	public ResponseEntity<Object> updatePerson(@RequestBody Person person) {
		log.info("Inside updatePerson of PersonController");
		return new ResponseEntity<>(this.personService.savePerson(person), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Service to delete Person in Data Base")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully Created Person.", response = Person.class),
			@ApiResponse(code = 500, message = "Internal server error.", response = Exception.class),
			@ApiResponse(code = 404, message = "Unable to find contracts", response = Exception.class) })
	@PostMapping(value = "/delete")
	public ResponseEntity<Object> deletePerson(@RequestBody Person person) {
		log.info("Inside deletePerson of PersonController");
		this.personService.deletePerson(person);
		return new ResponseEntity<>("Person Deleted Succesfully", HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get All Persons in Data Base")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully Get All Persons.", response = Person.class),
			@ApiResponse(code = 500, message = "Internal server error.", response = Exception.class),
			@ApiResponse(code = 404, message = "Unable to find contracts", response = Exception.class) })
	@GetMapping(value = "/all")
	public ResponseEntity<Object> getAllPersons() {
		log.info("Inside getAllPersons in PersonController");
		return new ResponseEntity<>(this.personService.getPersons(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get Person by Id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully Get Person by Id.", response = Person.class),
			@ApiResponse(code = 500, message = "Internal server error.", response = Exception.class),
			@ApiResponse(code = 404, message = "Unable to find contracts", response = Exception.class) })
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<Object> getPersonById(@PathVariable("id") Long id) {
		log.info("Inside getPersonById of PersonController");
		return new ResponseEntity<>(this.personService.getPersonById(id), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get Person with Demographic by Id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully Get Person and Demographics by Id.", response = Person.class),
			@ApiResponse(code = 206, message = "Failed Getting Person or Demographics by Id.", response = Person.class),
			@ApiResponse(code = 500, message = "Internal server error.", response = Exception.class),
			@ApiResponse(code = 404, message = "Unable to find contracts", response = Exception.class) })
	@GetMapping(value = "/demographic/{id}")
	public ResponseEntity<Object> getPersonDemographicById(@PathVariable("id") Long id) {
		log.info("Inside getPersonById of PersonController");
		return new ResponseEntity<>(this.personService.getPersonDemographicById(id), HttpStatus.OK);
	}

}
