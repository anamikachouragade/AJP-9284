package Dao;

import java.util.List;

import Exception.ParkingSlotException;
import Model.ParkingSlot;

public interface ParkingSlotDao {
	String addSlots(int numberOfSlots) throws ParkingSlotException;
	List<ParkingSlot> getAvailableSlots() throws ParkingSlotException;
	String releaseSlotById(int slotId) throws ParkingSlotException;
    String assignSlot(int slotId,String vehicleNumber) throws ParkingSlotException;
    String releaseSlot(int slotId, String vehicleNumber) throws ParkingSlotException;
}

