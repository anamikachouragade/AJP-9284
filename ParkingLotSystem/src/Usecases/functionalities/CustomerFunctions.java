package Usecases.functionalities;

import java.util.List;
import java.util.Scanner;

import Exception.CustomerException;
import Model.Customer;
import Service.CustomerService;
import Service.CustomerServiceImpl;

public class CustomerFunctions {
	private static Scanner sc = new Scanner(System.in);
	
	public void customerFunctions () throws CustomerException {
		CustomerService customerService = new CustomerServiceImpl();
	    int option;
	    do {
	        System.out.println("______Manage Customers______");
	        System.out.println("1.Create Customer\n2. Update Customer\n3. View Customers\n4. Delete Customer\n0. Back");

	        option = sc.nextInt();
	        switch (option) {
	            case 1:
	            	System.out.print("Enter Customer Name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Enter Customer Mobile Number: ");
                    String phone = sc.next();
                    System.out.print("Enter Customer Email: ");
                    String email = sc.next();
                    System.out.print("Enter Customer Username: ");
                    String username = sc.next();
                    System.out.print("Enter Customer Password: ");
                    String password = sc.next();
                    Customer customer = new Customer(name,  phone, email, username, password);
                    System.out.println(customerService.addCustomer(customer));
                    break;
	            case 2:
	            	System.out.print("Enter Customer Id: ");
                    int id = sc.nextInt();
                    System.out.print("Enter updated Customer Name: ");
                    sc.nextLine();
                    String updatedName = sc.nextLine();
                    System.out.print("Enter updated Customer Phone Number: ");
                    String updatedPhone = sc.next();
                    System.out.print("Enter updated Customer Email: ");
                    String updatedEmail = sc.next();
                    System.out.print("Enter updated Customer Username: ");
                    String updatedUsername = sc.next();
                    System.out.print("Enter updated Customer Password: ");
                    String updatedPassword = sc.next();
                    Customer updatedCustomer = new Customer(updatedName,  updatedPhone, updatedEmail, updatedUsername, updatedPassword);
                    System.out.println(customerService.updateCustomer(id, updatedCustomer));
                    ;
                    break;
	            case 3:
	            	 System.out.println("1. View Customer by Customer Id\n2. View All Customers");
	                    int viewCustomer = sc.nextInt();
	                    if (viewCustomer == 1) {
	                        System.out.print("Enter CustomerId: ");
	                        Customer customerView = customerService.getCustomerById(sc.nextInt());
	                        if (customerView != null) {
	                            System.out.println(customerView);
	                        } else {
	                            System.out.println("No Customer Found");
	                        }
	                    } else if (viewCustomer == 2) {
	                        List<Customer> customers = customerService.getAllCustomers();
	                        if (customers.isEmpty()) {
	                            System.out.println("No Customer Found");
	                        } else {
	                            for (Customer customer1 : customers) {
	                                System.out.println(customer1);
	                            }
	                        }
	                    } else {
	                        System.out.println("Invalid Choice.");
	                    }
	                    break;
	            case 4:
	            	System.out.print("Enter Customer Id you want to delete: ");
				    try {
			            	System.out.println(customerService.deleteCustomer(sc.nextInt()));
				    } catch (CustomerException e) {
				       	e.printStackTrace();
				    }
	                break;
	            
	            case 0:
	                System.out.println("Back to Admin Options...");
	                break;
	            default:
	                System.out.println("Invalid Choice");
	        }
	    } while (option != 0);
	
    }

}
