package com.fga.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fga.demo.repository.EmployeeRepository;

@Component
public class RFCNotExistValidator implements ConstraintValidator<RFCNotExist, String> {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		// TODO i dont know why this validation is running twice and the second time
		// employeeRepository is null, i need to fix this
		if (employeeRepository == null)
			return true;
		boolean exist = employeeRepository.existsBytaxIdNumber(value);
		return !exist;
	}

}
