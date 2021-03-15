package com.devits.laboratory.demographic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devits.laboratory.demographic.entities.Demographic;
import com.devits.laboratory.demographic.interfaces.DemographicService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DemographicController {
	
	@Autowired
	private DemographicService demographicService;
	
	@ApiOperation(value = "Service to save Demographic in Data Base")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully Created Person.", response = Demographic.class),
			@ApiResponse(code = 500, message = "Internal server error.", response = Exception.class),
			@ApiResponse(code = 404, message = "Unable to find contracts", response = Exception.class) })
	@PostMapping(value = "/save")
	public ResponseEntity<Object> saveDemographic(@RequestBody Demographic demographic) {
		log.info("saveDemographic in DemographicController");
		return new ResponseEntity<>(this.demographicService.saveDemographic(demographic), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Service to update Demographic in Data Base")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully Updated Demographic.", response = Demographic.class),
			@ApiResponse(code = 500, message = "Internal server error.", response = Exception.class),
			@ApiResponse(code = 404, message = "Unable to find contracts", response = Exception.class) })
	@PostMapping(value = "/update")
	public ResponseEntity<Object> updateDemographic(@RequestBody Demographic demographic) {
		log.info("updateDemographic in DemographicController");
		return new ResponseEntity<>(this.demographicService.saveDemographic(demographic), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Service to delete Demographic in Data Base")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully Updated Demographic.", response = Demographic.class),
			@ApiResponse(code = 500, message = "Internal server error.", response = Exception.class),
			@ApiResponse(code = 404, message = "Unable to find contracts", response = Exception.class) })
	@PostMapping(value = "/delete")
	public ResponseEntity<Object> deleteDemographic(@RequestBody Demographic demographic) {
		log.info("deleteDemographic in DemographicController");
		this.demographicService.deleteDemographic(demographic);
		return new ResponseEntity<>("Demographic Deleted Successfully", HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get Demographic by Id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully Get Demographic by Id.", response = Demographic.class),
			@ApiResponse(code = 500, message = "Internal server error.", response = Exception.class),
			@ApiResponse(code = 404, message = "Unable to find contracts", response = Exception.class) })
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<Object> getDemographicById(@PathVariable("id") String referenceId) {
		log.info("getDemographicById in DemographicController");
		return new ResponseEntity<>(this.demographicService.getDemographicById(referenceId), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get All Demographics in Data Base")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully Get All Demographics.", response = Demographic.class),
			@ApiResponse(code = 500, message = "Internal server error.", response = Exception.class),
			@ApiResponse(code = 404, message = "Unable to find contracts", response = Exception.class) })
	@GetMapping(value = "/all")
	public ResponseEntity<Object> getAllDemographics() {
		log.info("getAllDemographics in DemographicController");
		return new ResponseEntity<>(this.demographicService.getDemographics(), HttpStatus.OK);
	}

}
