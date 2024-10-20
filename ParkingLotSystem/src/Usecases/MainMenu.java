package Usecases;

import java.util.Scanner;

import Exception.AdminException;
import Exception.CustomerException;
import Exception.ParkingSlotException;
import Exception.VehicleException;

public class MainMenu {
	static Scanner sc = new Scanner(System.in);
	
	

	public static void main(String[] args) throws  CustomerException, ParkingSlotException, AdminException, VehicleException {
        AdminMenu admin = new AdminMenu();
        CustomerMenu customer = new CustomerMenu();
        int choice;
        do{
        	System.out.println("Welcome to the Parking Lot System");
        	System.out.println("1. Admin Menu");
        	System.out.println("2. Customer Menu");
        	System.out.println("3. Exit");
        	System.out.print("Select an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> admin.adminOperation();
                case 2 -> customer.customerOperation();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid Choice! Please try again...");
            }
            System.out.println();
        } while (choice!=0);
    }
}

