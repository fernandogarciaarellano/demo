package com.fga.demo.dto;

import com.fga.demo.model.EmployeProxy;

import lombok.Data;

@Data
public class EmployeeDTO {

	private String name;
	private String rfc;
	private String email;
	private String contractName;
	private String dateFrom;
	private String dateTo;
	private String salary;

	public EmployeeDTO(EmployeProxy p) {
		this.contractName = p.getContractName();
		this.dateFrom = p.getDateFrom();
		this.dateTo = p.getDateTo();
		this.email = p.getEmail();
		this.name = p.getName();
		this.rfc = p.getRfc();
		this.salary = p.getSalary();
	}

}
