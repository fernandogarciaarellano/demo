package com.fga.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fga.demo.model.Contract;
import com.fga.demo.model.Employee;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
	
	Contract findByEmployeeAndActive(Employee employee, Boolean active);

}
