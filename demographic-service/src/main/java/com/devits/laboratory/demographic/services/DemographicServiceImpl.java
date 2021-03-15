package com.devits.laboratory.demographic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devits.laboratory.demographic.entities.Demographic;
import com.devits.laboratory.demographic.interfaces.DemographicService;
import com.devits.laboratory.demographic.repositories.DemographicRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DemographicServiceImpl implements DemographicService {
	
	@Autowired
	private DemographicRepository demographicRepository;

	@Override
	public Demographic saveDemographic(Demographic demographic) {
		log.info("Inside saveDemographic of DemographicServiceImpl");
		return this.demographicRepository.save(demographic);
	}

	@Override
	public Demographic updateDemographic(Demographic demographic) {
		log.info("Inside updateDemographic of DemographicServiceImpl");
		return this.demographicRepository.save(demographic);
	}

	@Override
	public void deleteDemographic(Demographic demographic) {
		log.info("Inside deleteDemographic of DemographicServiceImpl");
		this.demographicRepository.delete(demographic);
	}

	@Override
	public Demographic getDemographicById(String referenceId) {
		log.info("Inside getDemographicById of DemographicServiceImpl");
		return this.demographicRepository.findById(referenceId).get();
	}

	@Override
	public List<Demographic> getDemographics() {
		log.info("Inside getDemographics of DemographicServiceImpl");
		return this.demographicRepository.findAll();
	}

}
