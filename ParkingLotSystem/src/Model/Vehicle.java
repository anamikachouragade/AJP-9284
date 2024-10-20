package Model;

import java.sql.Timestamp;

public class Vehicle {
    private int id;
    private String vehicleNumber;
    private String type; // ENUM values as String
    private int customerId;
    private Timestamp createdAt;

    // Constructor
    public Vehicle() {
    	
    }
    public Vehicle( String vehicleNumber, String type, int customerId, Timestamp createdAt) {
       
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.customerId = customerId;
        this.setCreatedAt(createdAt);
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", type='" + type + '\'' +
                ", customerId=" + customerId +
                '}';
    }
	
}

