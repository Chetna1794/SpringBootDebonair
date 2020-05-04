package com.infogain.debonair.dto;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Order class is used to create customer orders
 * 
 * @author Chetna
 * @since 21-Apr-2020
 */
public class Order {
	private int orderId;
	private LocalDateTime orderDate = LocalDateTime.now();
	private Items orderCart[];
	public static Map<Integer, Bill> currentSale = new HashMap<>();

	public Order() {
	}

	/**
	 * @param orderId   - Customer's Order ID
	 * @param orderDate - Customer's Order Date
	 * @param orderCart - Customer's Order Cart
	 */
	public Order(int orderId, LocalDateTime orderDate, Items orderCart[]) {
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderCart = orderCart;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public Items[] getOrderCart() {
		return orderCart;
	}

	public void setOrderCart(Items[] orderCart) {
		this.orderCart = orderCart;
	}

	/**
	 * Overridden toString() method of Order class
	 * 
	 * @return Stringified form of Order object
	 * @since 21-Apr-2020
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [orderId=").append(orderId).append(", orderDate=").append(orderDate)
				.append(", orderCart=").append(orderCart).append("]");
		return builder.toString();
	}

}
