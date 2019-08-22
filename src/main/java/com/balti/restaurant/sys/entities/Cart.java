package com.balti.restaurant.sys.entities;

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

@Entity
@Table(name = "cart")
public class Cart extends AuditModel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;
	
	@ManyToOne
	@JoinColumn(name = "itemId")
	private Item item;
	
	@ManyToOne
	@JoinColumn(name = "dealId")
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
}
