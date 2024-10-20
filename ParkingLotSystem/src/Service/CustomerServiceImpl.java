package Service;

import java.util.List;
import Dao.CustomerDaoImpl;
import Dao.CustomerDao;
import Exception.CustomerException;
import Model.Customer;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao dao;

    public CustomerServiceImpl() {
        this.dao = new CustomerDaoImpl();
    }

    public String addCustomer(Customer customer) throws CustomerException {
    	return dao.addCustomer(customer);
    }
    
    public Customer getCustomerById(int id) throws CustomerException {
        return dao.getCustomerById(id);
    }

    public List<Customer> getAllCustomers() throws CustomerException {
        return dao.getAllCustomers();
    }

    public String deleteCustomer(int id) throws CustomerException {
    	return dao.deleteCustomer(id);
    }

	public boolean authenticate(String username, String password) throws CustomerException {
		
		return dao.authenticate(username, password);
	}

	public String updateCustomer(int id, Customer updatedCustomer) throws CustomerException {
		
	    return dao.updateCustomer(id,updatedCustomer);
	}
	
	public String updatePassword(String username,String newPassword) throws CustomerException{
        return dao.updatePassword(username,newPassword);
    }
}

