package com.fga.demo.service;

import javax.validation.Valid;

import com.fga.demo.dto.ContractDTO;
import com.fga.demo.dto.DeleteContractRequest;
import com.fga.demo.model.Contract;

public interface ContractService {

	Contract save(ContractDTO entity);

	Contract delete(@Valid DeleteContractRequest entity);
	
}
