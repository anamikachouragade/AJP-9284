package Utility;

public class VehicleQuery {
    
    public String addVehicle() {
        return "INSERT INTO Vehicle (vehicleNumber, type, customerId) VALUES (?, ?, ?)";
    }

    public String getVehicleByNumber() {
        return "SELECT * FROM Vehicle WHERE vehicleNumber = ?";
    }

    public String getAllVehicles() {
        return "SELECT * FROM Vehicle";
    }

    public String removeVehicle() {
        return "DELETE FROM Vehicle WHERE vehicleNumber = ?";
    }
}
