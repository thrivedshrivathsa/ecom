package com.abc.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecom.entity.Customer;
import com.abc.ecom.service.CustomerImpl;
import com.abc.ecom.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	//*********************************************SaveCustomerMethod*****************************************************
	@PostMapping("/save")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
	{
		Customer newCustomer=customerService.saveCustomer(customer);
		
		ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(newCustomer,HttpStatus.CREATED);
		return responseEntity;
		
	}
	
	//*********************************************SaveCustomerMethod*****************************************************

	//*********************************************fetchallCustomerMethod*****************************************************
	
	@GetMapping("/all")
	public List<Customer> fetchAllCustomers(Customer customer)
	{
		List<Customer> customers=customerService.getAllCustomers(customer);
		return customers;
	}

	
	//*********************************************fetchallCustomerMethod*****************************************************

	
	//*********************************************fetchallCustomerByIdMethod*****************************************************
	
	@GetMapping("/get/{cid}")
	public ResponseEntity<?> fetchAllCustomer(@PathVariable("cid") int customerId)
	{
		Customer customer=customerService.getCustomerById(customerId);
		return new ResponseEntity<>(customer, HttpStatus.OK);
		
	}
	
	//*********************************************fetchallCustomerByIdMethod*****************************************************

	
	//*********************************************DeleteCustomerByIdMethod*****************************************************
	@GetMapping("/delete/{cid}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("cid")int customerId){
		
		customerService.deleteCustomer(customerId);
		return new ResponseEntity<>("Customer Deleted with id: "+customerId,HttpStatus.OK);
		
	}



}
