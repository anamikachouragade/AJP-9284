package Utility;

public class ParkingSlotQuery {
	
	public String getLastSlotId() {
        return "SELECT MAX(id) FROM ParkingSlot"; // New query to get last slot ID
    }

    public String insertSlot() {
        return "INSERT INTO ParkingSlot (id, is_available) VALUES (?, ?)"; // New query to insert a slot
    }

    public String getAvailableSlots() {
        return "SELECT * FROM ParkingSlot WHERE is_available = TRUE";
    }
    
    public String releaseSlotById() {
        return "UPDATE ParkingSlot SET is_Available = ? WHERE id = ?";
    }
    
    public String checkSlotAvailability() {
        return "SELECT is_Available FROM ParkingSlot WHERE id = ?";
    }
    
    public String checkSlotByVehicle() {
        return "SELECT * FROM ParkingSlot WHERE id = ? AND vehicleNumber = ?";
    }
    
    
    public String assignSlot() {
        return "UPDATE ParkingSlot SET is_available = ?, vehicleNumber = ? WHERE id = ?";
    }

    public String releaseSlot() {
        return "UPDATE ParkingSlot SET is_Available = ?, vehicleNumber = NULL WHERE id = ?";
    }

	public String getVehicleByNumber() {
		
		return "SELECT * FROM Vehicle WHERE vehicleNumber = ?";
	}
}

