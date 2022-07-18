package com.fga.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "CONTRACT_TYPE")
public class ContractType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTRACT_TYPE_ID")
	private Short contractTypeId;

	@Column(length = 80, nullable = false)
	private String name;

	@Column(length = 255, nullable = true)
	private String description;

	@Column(nullable = false)
	@CreationTimestamp
	private LocalDateTime dateCreated;

	@Column(nullable = false)
	private Boolean active;

}
