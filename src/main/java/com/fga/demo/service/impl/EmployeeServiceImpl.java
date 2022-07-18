package com.fga.demo.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fga.demo.dto.CreateEmployeeRequest;
import com.fga.demo.dto.EmployeeDTO;
import com.fga.demo.dto.UpdateEmployeeRequest;
import com.fga.demo.model.EmployeProxy;
import com.fga.demo.model.Employee;
import com.fga.demo.repository.EmployeeRepository;
import com.fga.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repository;

	public List<EmployeeDTO> getAllEmployee() {
		// TODO pasar a Criteria o jpa query para evitar EmployeeProxy
		List<EmployeProxy> employeeList = repository.getEmployess();
		List<EmployeeDTO> response = new ArrayList<EmployeeDTO>();
		if (employeeList.size() > 0) {
			response = employeeList.stream().map(EmployeeDTO::new).collect(Collectors.toList());
			return response;
		} else {
			return new ArrayList<EmployeeDTO>();
		}
	}

	public Employee create(CreateEmployeeRequest dto) throws Exception {

		Employee entity = new Employee();
		entity.setDateCreated(LocalDateTime.now());
		entity.setActive(Boolean.TRUE);
		entity.setName(dto.getName());
		entity.setBirthDate(dto.getBirthDate());
		entity.setCellPhone(dto.getCellPhone());
		entity.setEmail(dto.getEmail());
		entity.setLastName(dto.getLastName());
		entity.setTaxIdNumber(dto.getTaxIdNumber());
		entity = repository.save(entity);

		return entity;
	}

	public Employee update(UpdateEmployeeRequest dto) throws Exception {
		Optional<Employee> e = repository.findById(dto.getEmployeeId());
		if (!e.isPresent())
			return null;
		Employee entity = e.get();
		entity.setActive(dto.getActive());
		entity.setBirthDate(dto.getBirthDate());
		entity.setCellPhone(dto.getCellPhone());
		entity.setEmail(dto.getEmail());
		entity.setLastName(dto.getLastName());
		entity.setName(dto.getName());
		entity.setTaxIdNumber(dto.getTaxIdNumber());

		repository.save(entity);

		return entity;
	}

}
