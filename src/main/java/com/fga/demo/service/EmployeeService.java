package com.fga.demo.service;

import java.util.List;

import com.fga.demo.dto.CreateEmployeeRequest;
import com.fga.demo.dto.EmployeeDTO;
import com.fga.demo.dto.UpdateEmployeeRequest;
import com.fga.demo.model.Employee;

public interface EmployeeService {

	List<EmployeeDTO> getAllEmployee();

	Employee create(CreateEmployeeRequest entity) throws Exception;
	
	Employee update(UpdateEmployeeRequest entity) throws Exception;
}
