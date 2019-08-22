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
import javax.validation.constraints.NotNull;

import com.balti.restaurant.sys.abstractClasses.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table
public class OrderCustomer extends AuditModel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	@Column
	@NotNull
	private Double bill;
	
	@Column
	@NotNull
	private Boolean status;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customers;

	public Long getOrderId() {
		return orderId;
	}

	public Double getBill() {
		return bill;
	}

	public Boolean getStatus() {
		return status;
	}

	public Customer getCustomers() {
		return customers;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public void setBill(Double bill) {
		this.bill = bill;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public void setCustomers(Customer customers) {
		this.customers = customers;
	}
}
