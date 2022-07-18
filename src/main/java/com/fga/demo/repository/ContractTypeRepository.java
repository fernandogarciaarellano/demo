package com.fga.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fga.demo.model.ContractType;
 

@Repository
public interface ContractTypeRepository extends JpaRepository<ContractType, Short> {

}
