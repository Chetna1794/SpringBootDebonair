package com.infogain.debonair.serviceTest;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.infogain.debonair.repository.RegularAndCorporateCustomer;
import com.infogain.debonair.service.CustomerService;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
	
	
	@Mock
	RegularAndCorporateCustomer regularAndCorporateCustomerRepo;
	
	@InjectMocks
	CustomerService customerService;
	
	@BeforeAll
	public static void beforeClass(){
        System.out.println("This is to show use of @BeforeAll annotation in CustomerServiceTest.");
        System.out.println("This will be executed before all the test cases.");
    }
	
	@Test 
	public void checkingCustomerType() {
		when(regularAndCorporateCustomerRepo.getCustomerType("2")).thenReturn("REGULAR");
		when(regularAndCorporateCustomerRepo.getCustomerType("8")).thenReturn("CORPORATE");
		Assertions.assertEquals(customerService.checkCustomerType("2"),"REGULAR");
		Assertions.assertEquals(customerService.checkCustomerType("8"),"CORPORATE");
	}
	
}
