package com.fga.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fga.demo.dto.ContractDTO;
import com.fga.demo.dto.DeleteContractRequest;
import com.fga.demo.model.Contract;
import com.fga.demo.service.ContractService;

@RestController
@RequestMapping("/Contract")
public class ContractController {

	@Autowired
	private ContractService service;

	@PostMapping
	public ResponseEntity<Contract> createOrUpdate(@Valid @RequestBody ContractDTO entity) throws Exception {
		Contract updated = service.save(entity);
		return new ResponseEntity<Contract>(updated, new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<?> delete(@Valid @RequestBody DeleteContractRequest entity) throws Exception {
		Contract updated = service.delete(entity);
		if(updated == null)
			return new ResponseEntity<String>("contract id does not exist", new HttpHeaders(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Contract>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
}
