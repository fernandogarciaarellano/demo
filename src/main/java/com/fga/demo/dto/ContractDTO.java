package com.fga.demo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fga.demo.validation.RFCExist;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ContractDTO {

	private LocalDate dateFrom;
	private LocalDate dateTo;
	private Double SalaryPerDay;
	private LocalDateTime dateCreated;
	private Boolean active;
	
	@RFCExist
	@NotBlank(message = "RFC is mandatory")
	@Pattern(regexp = "[A-Z]{4}[0-9]{6}[A-Z0-9]{3}", message = "Invalid format for RFC")
	private String rfc;
	
	//TODO add custom validator to check if the given id already exists
	@NotNull(message = "ContractId is mandatory")
	private Short contractTypeId;

}
