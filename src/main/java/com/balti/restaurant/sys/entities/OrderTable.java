package com.balti.restaurant.sys.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.balti.restaurant.sys.abstractClasses.AuditModel;

@Entity
@Table(name = "order_table")
public class OrderTable extends AuditModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotBlank
	private String tableNo;

	public Long getId() {
		return id;
	}

	public String getTableNo() {
		return tableNo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTableNo(String tableNo) {
		this.tableNo = tableNo;
	}
	
	
}
