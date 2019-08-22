package com.balti.restaurant.sys.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import com.balti.restaurant.sys.abstractClasses.AuditModel;

@Entity
@Table
public class ServeTable extends AuditModel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serveTableId;
	
	@Column
	@NotNull
	private Integer floor;
	
	@Column
	@NotNull
	private Integer tableNo;
	
	@Column
	@NotBlank
	private String block;
	
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	public Long getServeTableId() {
		return serveTableId;
	}

	public Integer getFloor() {
		return floor;
	}

	public String getBlock() {
		return block;
	}

	public void setServeTableId(Long serveTableId) {
		this.serveTableId = serveTableId;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getTableNo() {
		return tableNo;
	}

	public void setTableNo(Integer tableNo) {
		this.tableNo = tableNo;
	}
}
