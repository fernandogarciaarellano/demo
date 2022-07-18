package com.fga.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYEE_ID")
	private Integer employeeId;

	@Column(name = "TAX_ID_NUMBER", nullable = false, length = 13)
	private String taxIdNumber;

	@Column(name = "NAME", nullable = false, length = 60)
	private String name;

	@Column(name = "LAST_NAME", nullable = false, length = 120)
	private String lastName;

	@Column(name = "BIRTH_DATE", nullable = false)
	private LocalDate birthDate;

	@Column(name = "EMAIL", nullable = false, length = 60)
	private String email;

	@Column(name = "CELL_PHONE", nullable = false, length = 20)
	private String cellPhone;

	@Column(nullable = false)
	@CreationTimestamp
	private LocalDateTime dateCreated;

	@Column(nullable = false)
	private Boolean active;

}
