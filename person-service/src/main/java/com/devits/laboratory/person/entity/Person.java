package com.devits.laboratory.person.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long personId;
	private String referenceId;
	private String title;
	private String firstName;
	private String secondName;
	private String firstLastName;
	private String secondLastName;
	private Date birthDate;
	private String gender;
	private String rfc;
	private String homoclave;
	private String ssn;
	private String curp;
	private String bloodType;
	private Integer personStatus;

}
