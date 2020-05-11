package com.infogain.debonair.serviceTest;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.infogain.debonair.dto.CustomerOrderDetails;
import com.infogain.debonair.dto.Items;
import com.infogain.debonair.model.Bill;
import com.infogain.debonair.model.Customer;
import com.infogain.debonair.model.Order;
import com.infogain.debonair.service.RestaurantService;

@ExtendWith(MockitoExtension.class)
public class RestaurantServiceTest {

	@Mock
	RestaurantService restaurantService;

	@Spy
	Order myOrder;
	
	@Test 
	public void testProcessOrder() {
		LocalDateTime myOrderDate = LocalDateTime.now();
		Items item = new Items(1, "Pizza",23.0f, 40.00);
		Items orderItem[] = new Items[1];
		orderItem[0] = item;	
		myOrder.setOrderId(12345);
		myOrder.setOrderDate(myOrderDate);
		myOrder.setOrderCart(orderItem);
		Customer customer = new Customer(123, "Chetna", "2020-05-05", "8447096543", "Regular", "Sector-62, Noida");
		Bill bill = restaurantService.generateBill(myOrder, restaurantService.getDiscountPercent(customer.getCustomerType()));
		CustomerOrderDetails customerOrderDetails = new CustomerOrderDetails(customer, orderItem);
		Assertions.assertSame(restaurantService.processOrder(customerOrderDetails), bill, "They are same objects");
	}
	
	@Test
	public void testCheckStatus() {
		when(restaurantService.checkStatus(1)).thenReturn(true);
		when(restaurantService.checkStatus(100)).thenReturn(false);
		Assertions.assertTrue(restaurantService.checkStatus(1), "The Order is present");
		Assertions.assertFalse(restaurantService.checkStatus(100), "The Order is not present");
	}

}
