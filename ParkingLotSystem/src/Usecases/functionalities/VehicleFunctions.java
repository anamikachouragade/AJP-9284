package Usecases.functionalities;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import Exception.VehicleException;
import Model.Vehicle;
import Service.VehicleService;
import Service.VehicleServiceImpl;

public class VehicleFunctions {
	private static Scanner sc = new Scanner(System.in);

    public void vehicleFunctions() {
        VehicleService vehicleService = new VehicleServiceImpl();
        int option;
        do {
            System.out.println("______Manage Vehicles______");
            System.out.println("1. Add Vehicle\n2. View Vehicle by Number\n3. View All Vehicles\n4. Remove Vehicle\n0. Back");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter vehicle details");
                    System.out.print("Enter vehicle number: ");
                    String vehicleNumber = sc.next();
                    System.out.print("Enter vehicle type: ");
                    String vehicleType = sc.next();
                    System.out.print("Enter Customer ID: ");
                    int customerId = sc.nextInt();
                    Vehicle vehicle = new Vehicle();
                    vehicle.setVehicleNumber(vehicleNumber);
                    vehicle.setType(vehicleType); // Assuming type is a string; adjust if using an ENUM
                    vehicle.setCustomerId(customerId);
                    vehicle.setCreatedAt(new Timestamp(System.currentTimeMillis()));
                    try {
                        System.out.println(vehicleService.addVehicle(vehicle));
                    } catch (VehicleException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.print("Enter Vehicle Number: ");
                    String vNumber = sc.next();
                    try {
                        Vehicle vehicleByNumber = vehicleService.getVehicleByNumber(vNumber);
                        if (vehicleByNumber != null) {
                            System.out.println(vehicleByNumber);
                        } else {
                            System.out.println("No Vehicle Found with this number.");
                        }
                    } catch (VehicleException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        List<Vehicle> vehicles = vehicleService.getAllVehicles();
                        if (vehicles.isEmpty()) {
                            System.out.println("No Vehicles Found.");
                        } else {
                            vehicles.forEach(System.out::println);
                        }
                    } catch (VehicleException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.print("Enter Vehicle Number to remove: ");
                    String removeNumber = sc.next();
                    try {
                        System.out.println(vehicleService.removeVehicle(removeNumber));
                    } catch (VehicleException e) {
                        e.printStackTrace();
                    }
                    break;
                case 0:
                    System.out.println("Back to Previous Menu...");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
            System.out.println();
        } while (option != 0);
    }
}
