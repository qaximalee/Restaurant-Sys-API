package com.balti.restaurant.sys.entities;

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
@Table(name = "item")
public class Item extends AuditModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;
	
	@Column
	@NotBlank
	private String name;
	
	@Column
	@NotBlank
	private String description;
	
	@Column
	@NotNull
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "deal_id")
	private Deal deal;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
		
	public Long getItemId() {
		return itemId;
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

	public void setItemId(Long id) {
		this.itemId = id;
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

	public Deal getDeal() {
		return deal;
	}

	public Brand getBrand() {
		return brand;
	}

	public Category getCategory() {
		return category;
	}

	public void setDeal(Deal deal) {
		this.deal = deal;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
