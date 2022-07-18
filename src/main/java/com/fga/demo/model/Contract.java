package com.fga.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "CONTRACT")
public class Contract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer contractId;
	
	@Column(name = "DATE_FROM", nullable = false)
	private LocalDate dateFrom;
	
	@Column(name = "DATE_TO", nullable = false)
	private LocalDate dateTo;
	
	@Column(name = "SALARY_PER_DAY", nullable = false)
	private Double SalaryPerDay;
	
	@Column(nullable = false)
	@CreationTimestamp
	private LocalDateTime dateCreated;

	@Column(nullable = false)
	private Boolean active;
	
	@JoinColumn(name = "EMPLOYEE_ID")
    @OneToOne(fetch = FetchType.LAZY)
	private Employee employee;
	
	@JoinColumn(name = "CONTRACT_TYPE_ID")
    @OneToOne(fetch = FetchType.LAZY)
	private ContractType contractType;
}
