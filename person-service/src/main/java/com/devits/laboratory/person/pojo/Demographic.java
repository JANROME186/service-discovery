package com.devits.laboratory.person.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Demographic {

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
