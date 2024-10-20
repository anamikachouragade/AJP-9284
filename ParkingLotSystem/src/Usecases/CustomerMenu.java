package Usecases;

import java.util.List;
import java.util.Scanner;

import Exception.CustomerException;
import Exception.ParkingSlotException;
import Model.ParkingSlot;
import Service.CustomerService;
import Service.CustomerServiceImpl;
import Service.ParkingSlotService;
import Service.ParkingSlotServiceImpl;

public class CustomerMenu {
	private static Scanner sc = new Scanner(System.in);

    public void customerOperation() throws  CustomerException, ParkingSlotException {
    	CustomerService customerService = new CustomerServiceImpl();
        int choice;
        do {
            System.out.println("***** Customer Menu *****");
            System.out.println("1. Customer Register\n2. Customer Login\n0. Exit");
            choice = sc.nextInt();
            ParkingSlotService parkingSlotService = new ParkingSlotServiceImpl();
            
            switch (choice) {
                case 1:
                    System.out.println("Contact to your Admin");
                    break;
                case 2:
                    System.out.print("Enter Username: ");
                    String username = sc.next();
                    System.out.print("Enter Password: ");
                    String password = sc.next();

                    boolean valid = customerService.authenticate(username, password);
                    if (valid) {
                        System.out.println("Login successfully");
                        System.out.println();
                        int option;
                        do {
                            System.out.println("______Customer Options______");
                            System.out.println("1. View Available Parking Slots\n" +
                                               "2. Update Password\n" +
                                               "3. Book Parking Slot\n" +
                            		           "0. Exit");
                            option = sc.nextInt();
                            switch (option) {
                                case 1:
                                	// View available parking slots
                                    List<ParkingSlot> availableSlots = parkingSlotService.getAvailableSlots();
                                    if (availableSlots.isEmpty()) {
                                        System.out.println("No available parking slots.");
                                    } else {
                                        System.out.println("Available Parking Slots:");
                                        for (ParkingSlot slot : availableSlots) {
                                            System.out.println(slot);
                                            
                                        }
                                    }
                                    break;
                                case 2:
                                	// Update password
                                    System.out.print("Enter New Password: ");
                                    String newPassword = sc.next();
                                    System.out.println(customerService.updatePassword(username, newPassword));
                                    break;
                                case 3:
                                    System.out.println("Contact to your Admin");
                                    break;
                                case 0:
                                    System.out.println("Exiting...");
                                    break;
                                default:
                                    System.out.println("Invalid Choice.");
                            }
                            System.out.println();
                        } while (option != 0);
                    } else {
                        System.out.println("Not valid username or password");
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice! Please try again...");
            }
            System.out.println();
        } while (choice != 0);
    }
}

