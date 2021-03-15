package com.devits.laboratory.demographic.interfaces;

import java.util.List;

import com.devits.laboratory.demographic.entities.Demographic;

public interface DemographicService {
	
	public Demographic saveDemographic(Demographic demographic);
	
	public Demographic updateDemographic(Demographic demographic);
	
	public void deleteDemographic(Demographic demographic);
	
	public Demographic getDemographicById(String referenceId);
	
	public List<Demographic> getDemographics();

}
