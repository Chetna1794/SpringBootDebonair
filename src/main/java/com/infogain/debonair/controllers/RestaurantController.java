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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.debonair.dto.CustomerOrderDetails;
import com.infogain.debonair.dto.Items;
import com.infogain.debonair.model.Bill;
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
	public ResponseEntity<Bill> takeOrder(@RequestBody CustomerOrderDetails customerOrderDetails) {
		return new ResponseEntity<Bill>(restaurantServices.processOrder(customerOrderDetails), HttpStatus.CREATED);
	}

	/**
	 * This method is endpoint to check Customer status
	 * 
	 * @param orderId provided by the customer
	 * @return ResponseEntity Object with Status message and HTTP Status OK
	 * @since 04-May-2020
	 */
	@ApiOperation(protocols = "http", notes = "This is used to check order status.", value = "orderId")
	@GetMapping(path = "/status", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> checkStatus(@RequestParam String orderId) {
		boolean orderStatus = restaurantServices.checkStatus(Integer.parseInt(orderId));
		if (orderStatus) {
			return new ResponseEntity<String>("Your order is getting ready.", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Oops! We are not able to find your order", HttpStatus.OK);
		}
	}

	/**
	 * This method is endpoint to check offers based on type of customer
	 * 
	 * @param customerType is provided by the customer
	 * @return ResponseEntity with offers message and HTTP status OK
	 * @since 04-May-2020
	 */
	@ApiOperation(protocols = "http", notes = "This is used to get customer offers.", value = "customerType")
	@GetMapping(path = "/offers", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Double> getOfferPercent(@RequestParam String customerType) {
		return new ResponseEntity<Double>(restaurantServices.getDiscountPercent(customerType), HttpStatus.OK);
	}

}
