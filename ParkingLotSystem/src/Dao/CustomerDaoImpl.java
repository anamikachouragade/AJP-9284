package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exception.CustomerException;
import Model.Customer;
import Utility.ConnectionFactory;
import Utility.CustomerQuery;

public class CustomerDaoImpl implements CustomerDao {
	CustomerQuery query = new CustomerQuery();


    public String addCustomer(Customer customer) throws CustomerException {
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query.insertCustomer())) {
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getPhone());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getUsername());
            ps.setString(5, customer.getPassword());
            int x = ps.executeUpdate();
            if (x > 0) {
                return "Customer Added Successfully!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

  
    public Customer getCustomerById(int id) throws CustomerException {
        try (Connection con = ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(query.getCustomerById())) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	Customer customer = new Customer();
            	customer.setId(rs.getInt("id"));
            	customer.setName(rs.getString("name"));
            	customer.setPhone(rs.getString("phone"));
            	customer.setEmail(rs.getString("email"));
            	customer.setUsername(rs.getString("username"));
            	customer.setPassword(rs.getString("password"));
                 return customer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

  
    public List<Customer> getAllCustomers() throws CustomerException {
        List<Customer> customers = new ArrayList<>();
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query.getAllCustomers())) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	Customer customer = new Customer();
            	customer.setId(rs.getInt("id"));
            	customer.setName(rs.getString("name"));
            	customer.setPhone(rs.getString("phone"));
            	customer.setEmail(rs.getString("email"));
            	customer.setUsername(rs.getString("username"));
            	customer.setPassword(rs.getString("password"));
            	customers .add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    
    public String updateCustomer(int id, Customer customer) throws CustomerException {
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query.updateCustomer())) {
        	 ps.setString(1, customer.getName());
             ps.setString(2, customer.getPhone());
             ps.setString(3, customer.getEmail());
             ps.setString(4, customer.getUsername());
             ps.setString(5, customer.getPassword());
            ps.setInt(6, id);
            int x = ps.executeUpdate();
            if (x > 0) {
                return "Customer updated successfully!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

  
    public String deleteCustomer(int id) throws CustomerException {
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query.deleteCustomer())) {
            ps.setInt(1, id);
            int x = ps.executeUpdate();
            if (x > 0) {
                return "Customer Deleted successfully!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

   
    public boolean authenticate(String username, String password) throws CustomerException {
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query.authenticate())) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public String updatePassword(String username,String newPassword) throws CustomerException{
        try(Connection con = ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(query.updatePassword())){
            ps.setString(1,newPassword);
            ps.setString(2,username);
            int x = ps.executeUpdate();
            if(x>0){
                return "Password Updated Successfully!";
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}

