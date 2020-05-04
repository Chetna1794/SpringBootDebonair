package com.infogain.debonair.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.debonair.dto.Bill;
import com.infogain.debonair.dto.Items;
import com.infogain.debonair.dto.Order;
import com.infogain.debonair.repository.Menu;

/**
 * RestaurantService class handles all the business logic for carrying out the
 * restaurant operations
 * 
 * @author Chetna
 * @since 21-Apr-2020
 */
@Service
public class RestaurantService {

	@Autowired
	Menu menuRepository;

	/**
	 * This method is used to get restaurant menu from the Menu repository
	 * 
	 * @return static Menu list to showMenu() method of Restaurant controller
	 * 
	 * @since 21-Apr-2020
	 */
	public List<Items> getMenu() {
		return menuRepository.fetchMenu();
	}

	/**
	 * This method is used to process the order
	 * 
	 * @since 21-Apr-2020
	 */
	public void processOrder(Items items[]) {
		Order myOrder = new Order();
		Random randomObj = new Random();
		// Generating Random Order Id
		myOrder.setOrderId(randomObj.nextInt(100));
		// Getting current Date Time
		myOrder.setOrderDate(LocalDateTime.now());
		myOrder.setOrderCart(items);
		// initiating bill generation
		generateBill(myOrder);
	}

	/**
	 * This method is used to generate customer bill
	 * 
	 * @param myOrder
	 * @since 04-May-2020
	 */
	public void generateBill(Order myOrder) {
		double totalCartPrice = 0.00;
		Items items[] = myOrder.getOrderCart();
		for (int i = 0; i < items.length; i++) {
			totalCartPrice += items[i].getItemRate();
		}
		Random randomObj = new Random();
		// Generating random Bill Id
		int billNumber = randomObj.nextInt(100);
		// Generating Bill class's object
		Bill billObj = new Bill(billNumber, myOrder.getOrderId(), totalCartPrice, myOrder.getOrderDate());
		Order.currentSale.put(myOrder.getOrderId(), billObj);
	}

	/**
	 * This method is used to check the order status
	 * 
	 * @param OrderId Customer's Order ID
	 * 
	 * @since 23-Apr-2020
	 */
	public Boolean checkStatus(Integer orderId) {
		Map<Integer, Bill> orders = Order.currentSale;
		if (orders.get(orderId).equals(null)) {
			return false;
		} else {
			return true;
		}
	}
}
