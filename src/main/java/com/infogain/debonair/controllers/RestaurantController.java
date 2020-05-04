package com.infogain.debonair.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.debonair.dto.Items;
import com.infogain.debonair.service.CustomerService;
import com.infogain.debonair.service.RestaurantService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Restaurant class has all the endpoints which handles Restaurant operations
 * 
 * @author Chetna
 * @since 21-Apr-2020
 */
@RestController
@RequestMapping("/debonair")
@Api(value = "/debonair")
@CrossOrigin(origins = "*")
public class RestaurantController {

	@Autowired
	RestaurantService restaurantServices;
	@Autowired
	CustomerService customerServices;

	/**
	 * This method is endpoint to fetch Menu details
	 * 
	 * @return ResponseEntity object containing Restaurant Menu & HTTP Status OK
	 * @since 04-May-2020
	 */
	@ApiOperation(protocols = "http", notes = "This is used to get menu items.", value = "Show Menu")
	@GetMapping(path = "/menu")
	public ResponseEntity<List<Items>> showMenu() {
		System.out.println("Show Menu");
		return new ResponseEntity<List<Items>>(restaurantServices.getMenu(), HttpStatus.OK);
	}

	/**
	 * This method is endpoint to process the order placed by used.
	 * 
	 * @param items object sent from frontend
	 * @return ResponseEntity object with HTTP Status Created
	 * @since 04-May-2020
	 */
	@ApiOperation(protocols = "http", notes = "This is used to place customer orders.", value = "Take Order")
	@PostMapping(path = "/order", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> takeOrder(@RequestBody Items items[]) {
		restaurantServices.processOrder(items);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/**
	 * This method is endpoint to check Customer status
	 * 
	 * @param orderId provided by the customer
	 * @return ResponseEntity Object with Status message and HTTP Status OK
	 * @since 04-May-2020
	 */
	@ApiOperation(protocols = "http", notes = "This is used to check order status.", value = "Order Status")
	@PostMapping(path = "/status", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> checkStatus(@RequestBody String orderId) {
		System.out.println(orderId);
		Boolean orderStatus = restaurantServices.checkStatus(Integer.parseInt(orderId));
		if (orderStatus) {
			return new ResponseEntity<String>("Your order is getting ready.", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Oops! We are not able to find your order", HttpStatus.OK);
		}
	}

	/**
	 * This method is endpoint to check offers based on type of customer
	 * 
	 * @param customerId is provided by the customer
	 * @return ResponseEntity with offers message and HTTP status OK
	 * @since 04-May-2020
	 */
	@ApiOperation(protocols = "http", notes = "This is used to get regular offers.", value = "Customer Offers")
	@PostMapping(path = "/offers", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getOffers(@RequestBody String customerId) {
		String value = customerServices.checkCustomerType(customerId);
		return new ResponseEntity<String>(value, HttpStatus.OK);
	}

}
