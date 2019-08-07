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
@Table(name = "deal")
public class Deal extends AuditModel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dealId;
	
	@Column
	@NotBlank
	private String name;
	
	@Column
	@NotBlank
	private String description;
	
	@Column
	@NotNull
	private Double price;

	public Long getDealId() {
		return dealId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}

	public void setDealId(Long dealId) {
		this.dealId = dealId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}
