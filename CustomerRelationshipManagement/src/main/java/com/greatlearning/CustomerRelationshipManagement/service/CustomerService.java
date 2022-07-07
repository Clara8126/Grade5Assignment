package com.greatlearning.CustomerRelationshipManagement.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.greatlearning.CustomerRelationshipManagement.model.Customer;

@Repository
public interface CustomerService {
	public List<Customer> listAllData();

	public void save(Customer s1);

	public Customer delete(int id);

	public Customer getCustomerDetails(int id);

}
