package Usecases;

import java.util.Scanner;

import Exception.AdminException;
import Exception.CustomerException;
import Exception.ParkingSlotException;
import Exception.VehicleException;
import Model.Admin;
import Service.AdminService;
import Service.AdminServiceImpl;
import Usecases.functionalities.CustomerFunctions;
import Usecases.functionalities.ParkingSlotFunctions;
import Usecases.functionalities.VehicleFunctions;


public class AdminMenu {
	private static Scanner sc = new Scanner(System.in);

    public void adminOperation() throws ParkingSlotException, CustomerException, AdminException,  VehicleException {
        AdminService adminService = new AdminServiceImpl();
        int choice;
        do {
            System.out.println("***** Admin Menu *****");
            System.out.println("1. Admin Register\n2. Admin Login\n0. Exit");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Admin Registration");
                    System.out.print("Enter Username: ");
                    String newUsername = sc.next();
                    System.out.print("Enter Password: ");
                    String newPassword = sc.next();
                    Admin admin = new Admin(newUsername, newPassword);
                    
                    System.out.println(adminService.addAdmin(admin));
                    break;
                    
                case 2:
                	System.out.print("Enter Username: ");
                    String username = sc.next();
                    System.out.print("Enter PassWord: ");
                    String password = sc.next();

                    boolean valid = adminService.authenticate(username, password);
                    if (valid) {
                            System.out.println("Login successfully");
                            System.out.println();
                            int option;
                            do {
                                System.out.println("______Admin Options______");
                                System.out.println("1. Manage Customers\n" +
                                        "2. Manage Parking Slots\n" +
                                        "3. Manage Vehicles\n" +
                                        "4. Update Password\n" +
                                        "0. Exit");

                                option = sc.nextInt();
                                switch (option) {
                                    case 1:
                                        CustomerFunctions cf  = new CustomerFunctions();
                                        cf.customerFunctions();
                                        break;
                                    case 2:
                                    	ParkingSlotFunctions psf  = new ParkingSlotFunctions();
                                        psf.parkingSlotFunctions();
                                        break;
                                    case 3:
                                    	VehicleFunctions vf  = new VehicleFunctions();
                                        vf.vehicleFunctions();
                                        break;
                                    case 4:
                                    	System.out.print("Enter New Password: ");
                                        String updatedPassword = sc.next();
                                        System.out.println(adminService.updatePassword(username, updatedPassword));
                                        break;
                                    case 0:
                                        System.out.println("Exiting...");
                                        break;
                                    default:
                                        System.out.println("Invalid Choice");
                                }
                                System.out.println();
                            } while (option != 0);
                        } else {
                            System.out.println("Invalid username or password");
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

