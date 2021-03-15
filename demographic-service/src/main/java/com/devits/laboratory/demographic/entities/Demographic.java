package com.devits.laboratory.demographic.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Demographic {

	@Id
	private String referenceId;
	private String street;
	private String extNum;
	private String intNum;
	private String suburb;
	private String municipality;
	private String city;
	private String state;
	private Integer zipCode;
	private String country;

}
