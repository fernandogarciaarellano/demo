package com.fga.demo.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class UpdateEmployeeRequest {

	private Integer employeeId;

	@Pattern(regexp = "[A-Z]{4}[0-9]{6}[A-Z0-9]{3}", message = "Invalid format for RFC")
	@NotBlank(message = "RFC is mandatory")
	private String taxIdNumber;

	@NotBlank(message = "Name is mandatory")
	private String name;

	@NotBlank(message = "Lastname is mandatory")
	private String lastName;

	@NotNull(message = "birthDate is mandatory")
	private LocalDate birthDate;

	@NotBlank(message = "email is mandatory")
	private String email;

	@NotBlank(message = "cellPhone is mandatory")
	private String cellPhone;

	private Boolean active;

}
