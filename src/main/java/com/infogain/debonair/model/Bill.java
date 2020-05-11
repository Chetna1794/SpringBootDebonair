package com.infogain.debonair.model;

import java.time.LocalDateTime;

/**
 * DTO for User's Bill
 * 
 * @author Chetna
 * @since 21-Apr-2020
 */
public class Bill {
	private int billNumber;
	private int orderId;
	private double totalAmount;
	private LocalDateTime orderDate;

	/**
	 * @param billNumber  - Bill Number
	 * @param orderId     - Order Id
	 * @param totalAmount - Total Bill Amount
	 * @param orderDate   - Date at which Order is placed
	 */
	public Bill(int billNumber, int orderId, double totalAmount, LocalDateTime orderDate) {
		this.billNumber = billNumber;
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.orderDate = orderDate;
	}

	public int getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(int billNumber) {
		this.billNumber = billNumber;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * Overridden toString() method of Bill class
	 * 
	 * @return stringified form of complete Bill object
	 * @since 21-Apr-2020
	 */
	@Override
	public String toString() {
		return "Bill [billNumber=" + billNumber + ", orderId=" + orderId + ", totalAmount=" + totalAmount
				+ ", orderDate=" + orderDate + "]";
	}

}
