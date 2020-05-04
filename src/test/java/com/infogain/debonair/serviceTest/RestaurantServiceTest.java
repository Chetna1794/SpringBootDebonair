package com.infogain.debonair.serviceTest;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.common.base.Verify;
import com.infogain.debonair.dto.Items;
import com.infogain.debonair.dto.Order;
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
		myOrder.generateBill();
	}
	
	@Test
	public void testCheckStatus() {
		when(restaurantService.checkStatus(1)).thenReturn(true);
		when(restaurantService.checkStatus(100)).thenReturn(false);
		Verify.verify(restaurantService.checkStatus(1).equals(true));
		Verify.verify(restaurantService.checkStatus(100).equals(false));
	}

}
