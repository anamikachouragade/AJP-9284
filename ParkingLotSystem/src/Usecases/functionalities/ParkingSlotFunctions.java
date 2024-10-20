package Usecases.functionalities;

import java.util.List;
import java.util.Scanner;

import Exception.ParkingSlotException;
import Model.ParkingSlot;
import Service.ParkingSlotService;
import Service.ParkingSlotServiceImpl;

public class ParkingSlotFunctions {
	 private static Scanner sc = new Scanner(System.in);

	    public void parkingSlotFunctions() throws ParkingSlotException {
	        ParkingSlotService parkingSlotService = new ParkingSlotServiceImpl();
	        int option;

	        do {
	            System.out.println("_____Parking Slot Portal_____");
	            System.out.println("1. Add Parking Slots\n2. View Available Parking Slots\n3. Release Parking Slot By Id\n4. Assign Parking Slot\n5.. Release Parking Slot\n0. Exit");
	            option = sc.nextInt();

				switch (option) {
	                case 1:
	                    System.out.print("Enter number of parking slots to add: ");
	                    int numberOfSlots = sc.nextInt();
	                    try {
	                        System.out.println(parkingSlotService.addSlots(numberOfSlots));
	                    } catch (ParkingSlotException e) {
	                        e.printStackTrace();
	                    }
	                    break;
	                case 2:
	                	List<ParkingSlot> availableSlots = parkingSlotService.getAvailableSlots();
	                    if (availableSlots.isEmpty()) {
	                        System.out.println("No Available Parking Slots.");
	                    } else {
	                        for (ParkingSlot slot : availableSlots) {
	                            System.out.println(slot);
	                        }
	                    }
	                    break;
	                case 3:
	                	System.out.print("Enter Parking Slot Id to release: ");
	                    int slot_Id = sc.nextInt();
	                    try {
	                        String result = parkingSlotService.releaseSlotById(slot_Id);
	                        System.out.println(result);
	                    } catch (ParkingSlotException e) {
	                        System.err.println("Error: " + e.getMessage());
	                    }
	                    break;
	                case 4:
	                	System.out.print("Enter Parking Slot Id to assign: ");
	                    int slotId = sc.nextInt();
	                    sc.nextLine(); 
	                    System.out.print("Enter Vehicle Number: ");
	                    String vehicleNumber = sc.nextLine(); 
	                    System.out.println(parkingSlotService.assignSlot(slotId,vehicleNumber));
	                    break;
	                case 5:
	                	System.out.print("Enter Parking Slot Id to release: ");
	                    int slotId2 = sc.nextInt();
	                    sc.nextLine(); // Consume the newline character after nextInt()
	                    System.out.print("Enter Vehicle Number: ");
	                    String vehicleNumber2 = sc.nextLine(); 
	                    System.out.println(parkingSlotService.releaseSlot(slotId2 , vehicleNumber2));
	                    break;
	                case 0:
	                    System.out.println("Exiting...");
	                    break;
	                default:
	                    System.out.println("Invalid Choice");
	            }
	            System.out.println();
	        } while (option != 0);
	    }
}
