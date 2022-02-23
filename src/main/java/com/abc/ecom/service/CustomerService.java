package com.abc.ecom.service;

import java.util.List;

import com.abc.ecom.entity.Customer;

public interface CustomerService {
	
	public Customer saveCustomer(Customer customer);

	List<Customer> getAllCustomers(Customer customer);

	public Customer getCustomerById(int customerId);
	
	public void deleteCustomer(int customerId);
	
	public Customer updateCustomer(Customer customer);

}
