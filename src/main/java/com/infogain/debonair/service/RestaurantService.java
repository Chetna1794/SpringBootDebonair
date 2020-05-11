package com.infogain.debonair.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.debonair.constants.Constants;
import com.infogain.debonair.dto.CustomerOrderDetails;
import com.infogain.debonair.dto.Items;
import com.infogain.debonair.model.Bill;
import com.infogain.debonair.model.Order;
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
	Random randomObj = new Random();
	@Autowired
	Menu menuRepository;

	/**
	 * This method is used to get restaurant menu from the Menu repository
	 * 
	 * @return Menu list to showMenu() method of Restaurant controller
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
	public Bill processOrder(CustomerOrderDetails customerOrderDetails) {	
		Order myOrder = new Order();
		// Generating Random Order Id
		myOrder.setOrderId(randomObj.nextInt(100));
		// Getting current Date Time
		myOrder.setOrderDate(LocalDateTime.now());
		myOrder.setOrderCart(customerOrderDetails.getItems());		
		// initiating bill generation
		Bill bill = generateBill(myOrder, getDiscountPercent(customerOrderDetails.getCustomer().getCustomerType()));
		return bill;
	}

	/**
	 * This method is used to generate customer bill
	 * 
	 * @param myOrder
	 * @since 04-May-2020
	 */
	public Bill generateBill(Order myOrder, double discountPercent) {
		double totalCartPrice = 0.00;
		Items items[] = myOrder.getOrderCart();
		for (int i = 0; i < items.length; i++) {
			totalCartPrice += items[i].getItemRate();
		}
		// Applying discount
		totalCartPrice = totalCartPrice - (totalCartPrice * (discountPercent/100)); 
		// Generating Bill class's object
		Bill billObj = new Bill(randomObj.nextInt(100), myOrder.getOrderId(), totalCartPrice, myOrder.getOrderDate());
		Order.currentSale.put(myOrder.getOrderId(), billObj);
		return billObj;
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
	
	/**
	 * This method returns discount percentage depending on customer type
	 * 
	 * @param customerType
	 * @return
	 * @since 10-May-2020
	 */
	public double getDiscountPercent(String customerType) {
		if(Constants.CORPORATE.equalsIgnoreCase(customerType)) {
			return 25.00;
		} else if(Constants.REGULAR.equalsIgnoreCase(customerType)) {
			return 15.00;
		}
		return 0.00;
	}
}
