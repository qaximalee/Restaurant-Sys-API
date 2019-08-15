package com.balti.restaurant.sys.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.balti.restaurant.sys.abstractClasses.AuditModel;

@Entity
@Table(name = "employee")
public class Employee extends AuditModel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	
	@Column
	@NotBlank
	private String name;

	@Column
	@NotBlank
	private String designation;

	@Column
	@NotNull
	private Double salary;

	public Long getEmployeeId() {
		return employeeId;
	}

	public String getName() {
		return name;
	}

	public String getDesignation() {
		return designation;
	}

	public Double getSalary() {
		return salary;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
}
