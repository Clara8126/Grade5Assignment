package com.greatlearning.CustomerRelationshipManagement.controller;

import com.greatlearning.CustomerRelationshipManagement.model.Customer;
import com.greatlearning.CustomerRelationshipManagement.service.CustomerService;
import com.greatlearning.CustomerRelationshipManagement.service.CustomerServiceImpl;

import java.util.Collections;
import java.util.List;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerServiceImpl io;

	@RequestMapping("/list")
	public String getAllCustomer(Model theModel) {
		List<Customer> L1 = io.listAllData();
		theModel.addAttribute("CustomerModel", L1);
		return "CustomerList";
	}

	@RequestMapping("/add")
	public String addCustomer(Model theModel) {
		Customer customer = new Customer();
		theModel.addAttribute("Customer", customer);
		return "CustomerSave1";
	}

	@RequestMapping("/update")
	public String updateStudent(@RequestParam("id") int id, Model theModel) {

		Customer customer = io.getCustomerDetails(id);
		theModel.addAttribute("Customer", customer);
		System.out.println(customer.getId() + "id");
		return "CustomerSave1";
	}

	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("Firstname") String Firstname,
			@RequestParam("LastName") String Lastname, @RequestParam("Email") String Email) {

		Customer c1 ;
		if (id != 0 ) { 
			c1= io.getCustomerDetails(id);
		}
		else {
			c1 = new Customer ();
		} 
	
		c1.setFirstname(Firstname);
		c1.setLastname(Lastname);
		c1.setEmail(Email);
		io.save(c1);
		
		return "redirect:/customers/list";
	}

	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam("id") int id) {
		io.delete(id);
		return "redirect:/customers/list";
	}

}
