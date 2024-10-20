package Service;


import java.util.List;

import Exception.CustomerException;
import Model.Customer;

public interface CustomerService {
	 String addCustomer(Customer customer) throws CustomerException;
	    Customer getCustomerById(int id) throws CustomerException;
	    String deleteCustomer(int id) throws CustomerException;
		boolean authenticate(String username, String password) throws CustomerException;
		String updateCustomer(int customerId, Customer customer) throws CustomerException;
		List<Customer> getAllCustomers() throws CustomerException;
		String updatePassword(String username, String newPassword) throws CustomerException;
}

