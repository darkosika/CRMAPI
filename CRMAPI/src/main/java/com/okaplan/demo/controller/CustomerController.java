package com.okaplan.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.okaplan.demo.entity.Customer;
import com.okaplan.demo.service.customerService;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
	
	@Autowired
	private customerService service; 
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return service.getCustomers();
									   }
	
	@GetMapping("/customer/{Id}")
	public Customer getCustomer(@PathVariable int Id){
		Customer customer=service.getCustomer(Id);
		if(customer==null) throw new CustomerNotFoundException("Customer not exist with"+ Id);
			
		return customer;
									   				 }
	@PostMapping("/customer")
	public Customer saveCustomer(@RequestBody Customer cus){
		cus.setId(0);
		service.saveCustomer(cus);
		return cus;
									   				 }
	@PutMapping("/customer")
	public Customer updateCustomer(@RequestBody Customer cus){
		service.saveCustomer(cus);
		return cus;
									   				 }
	@DeleteMapping("/deletecustomer/{Id}")
	public String deleteCustomer(@PathVariable int Id){
		
		Customer cus=service.getCustomer(Id);
		if(cus==null) throw new CustomerNotFoundException("Such a customer not exists with " +Id);
		service.deleteCustomer(Id);
		return "Deleted Successfully";
									   				 }
								



}
