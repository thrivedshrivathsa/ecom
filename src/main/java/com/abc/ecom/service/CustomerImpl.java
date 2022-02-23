package com.abc.ecom.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.*;


import com.abc.ecom.entity.Customer;
import com.abc.ecom.entity.Product;
import com.abc.ecom.exceptionhandling.CustomerNotFoundException;
import com.abc.ecom.exceptionhandling.ProductNotFoundException;
import com.abc.ecom.repository.CustomerRepositoryy;

@Service
public class CustomerImpl implements CustomerService {
	
	@Autowired
	private CustomerRepositoryy customerRepositoryy;

	@Override
	public Customer saveCustomer(Customer customer) {
		Customer product=customerRepositoryy.save(customer);
		return customer;
	}
	
	@Override
	public List<Customer> getAllCustomers(Customer customer) {
		List<Customer> customers=customerRepositoryy.findAll();
		return customers;
	}

	@Override
	public Customer getCustomerById(int customerId) {
		Optional<Customer> optionalCustomer=customerRepositoryy.findById(customerId);
		if(optionalCustomer.isPresent()) {
			throw new CustomerNotFoundException("Sorry! Product is not existing with id: "+customerId);

		}
		else {
			
		}
		return optionalCustomer.get();
	}

	@Override
	public void deleteCustomer(int customerId) {
		Optional<Customer> optionalCustomer=customerRepositoryy.findById(customerId);
		if(optionalCustomer.isPresent()) {
			customerRepositoryy.deleteById(customerId);
		}
		else {
			throw new CustomerNotFoundException("Sorry! Product is not existing with id: "+customerId);
		}
		
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Optional<Customer>optionalProduct=customerRepositoryy.findById(customer.getCustomerId());
		if(optionalProduct.isEmpty()) {
			throw new CustomerNotFoundException("Sorry! Customer is not existing with id :"+customer.getCustomerId());
		}
		Customer updatecustomer = customerRepositoryy.save(customer);
		
		return updatecustomer;
	}

	

}
