package com.fga.demo.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fga.demo.dto.ContractDTO;
import com.fga.demo.dto.DeleteContractRequest;
import com.fga.demo.model.Contract;
import com.fga.demo.model.ContractType;
import com.fga.demo.model.Employee;
import com.fga.demo.repository.ContractRepository;
import com.fga.demo.repository.EmployeeRepository;
import com.fga.demo.service.ContractService;

@Service
public class ContractServiceImpl implements ContractService {

	@Autowired
	private ContractRepository contractRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Contract save(ContractDTO entity) {
		Contract contract = new Contract();
		Employee e = employeeRepository.findByTaxIdNumber(entity.getRfc());
		contract.setEmployee(e);
		contract = contractRepository.findByEmployeeAndActive(e, Boolean.TRUE);
		if (contract != null) {
			contract.setActive(false);
			contract.setDateTo(LocalDate.now());
			contractRepository.saveAndFlush(contract);
		}
		contract = new Contract();
		contract.setEmployee(e);
		contract.setActive(entity.getActive());

		ContractType ct = new ContractType();
		ct.setContractTypeId(entity.getContractTypeId());
		contract.setContractType(ct);

		contract.setDateCreated(LocalDateTime.now());
		contract.setDateFrom(LocalDate.now());
		contract.setDateTo(LocalDate.now());
		contract.setSalaryPerDay(entity.getSalaryPerDay());

		return contractRepository.save(contract);
	}

	@Override
	public Contract delete(@Valid DeleteContractRequest entity) {

		Contract contract = new Contract();
		Employee e = employeeRepository.findByTaxIdNumber(entity.getRfc());
		contract.setEmployee(e);
		contract = contractRepository.findByEmployeeAndActive(e, Boolean.TRUE);
		if (contract == null)
			return contract;
		contract.setActive(Boolean.FALSE);
		contract.setDateTo(LocalDate.now());
		contractRepository.save(contract);
		return contract;
	}

}
