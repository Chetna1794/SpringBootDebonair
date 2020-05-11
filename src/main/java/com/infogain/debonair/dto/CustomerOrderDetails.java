package com.infogain.debonair.dto;

import java.io.Serializable;

import com.infogain.debonair.model.Customer;

public class CustomerOrderDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	private Customer customer;
	private Items items[];
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Items[] getItems() {
		return items;
	}
	public void setItems(Items[] items) {
		this.items = items;
	}
	public CustomerOrderDetails(Customer customer, Items[] items) {
		super();
		this.customer = customer;
		this.items = items;
	}
	
}
