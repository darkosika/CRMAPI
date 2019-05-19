package dao;

import java.util.List;

import com.okaplan.demo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer customer);
	
	public Customer getCustomer(int id);
	
	public void delete(int id);
	
							 }
