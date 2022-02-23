package com.abc.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.ecom.entity.Customer;

public interface CustomerRepositoryy extends JpaRepository<Customer,Integer> {

}
