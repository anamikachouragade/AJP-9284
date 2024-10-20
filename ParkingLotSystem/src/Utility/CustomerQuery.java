package Utility;

public class CustomerQuery {
	public String insertCustomer(){
        return "INSERT INTO Customer(name,  phone, email,  username, password) VALUES(?, ?, ?, ?, ?)";
    }
    public String getCustomerById(){
        return "SELECT id, name, phone, email, username, password FROM Customer WHERE id = ?";
    }
    public String getAllCustomers(){
        return "SELECT id, name, phone, email, username, password FROM Customer";
    }
    public String authenticate(){
        return "SELECT * FROM Customer WHERE username = ? AND password = ?";
    }

    public String updatePassword(){
        return "UPDATE Customer SET password = ? WHERE username = ?";
    }

    public String updateCustomer() {
        return "UPDATE Customer SET name=?, email=?,  phone=?, username=?, password=? WHERE id=?";
    }
    public String deleteCustomer() {
        return "DELETE FROM Customer WHERE id = ?";
    }
}

