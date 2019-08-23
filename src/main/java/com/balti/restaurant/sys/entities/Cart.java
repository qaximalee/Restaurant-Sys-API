package com.balti.restaurant.sys.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "cart")
public class Cart extends AuditModel implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;
	
	@Column
	@NotNull
	private Double totalAmount;
	
	@Column
	@NotNull
	private Integer dealQuantity;
	
	@Column
	@NotNull
	private Integer itemQuantity;
	
	@ManyToOne
	@JoinColumn(columnDefinition="integer", name="itemId")
	private Item item;
	
	@ManyToOne
	@JoinColumn(columnDefinition="integer", name="dealId")
	private Deal deal;
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	public Long getCartId() {
		return cartId;
	}

	public Item getItem() {
		return item;
	}

	public Deal getDeal() {
		return deal;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setDeal(Deal deal) {
		this.deal = deal;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public Integer getDealQuantity() {
		return dealQuantity;
	}

	public Integer getItemQuantity() {
		return itemQuantity;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setDealQuantity(Integer dealQuantity) {
		this.dealQuantity = dealQuantity;
	}

	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
	
}
