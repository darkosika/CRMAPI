package service;

import java.util.List;

import com.okaplan.demo.entity.Customer;

public interface customerService {

	
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer customer);
	
	public Customer getCustomer(int id);
	
	public void deleteCustomer(int id);
	
								 }
