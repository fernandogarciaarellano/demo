package com.fga.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fga.demo.model.EmployeProxy;
import com.fga.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "select concat(e.name, ' ',e.last_name) as name, e.tax_id_number as rfc, e.email, ct.name as contractName, c.date_From as dateFrom, c.date_to as dateTo, c.salary_per_day as salary from metaphorce.employee e \r\n"
			+ "inner join metaphorce.contract c on c.employee_id = e.employee_id\r\n"
			+ "inner join metaphorce.contract_type ct on ct.contract_type_id = c.contract_type_id\r\n"
			+ "where e.active = 1 and c.active = 1;", nativeQuery = true)
	List<EmployeProxy> getEmployess();

	boolean existsBytaxIdNumber(String taxIdNumber);
	
	Employee findByTaxIdNumber(String rfc);

}
