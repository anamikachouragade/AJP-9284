package Dao;

import java.util.List;

import Exception.VehicleException;
import Model.Vehicle;

public interface VehicleDao {
	String addVehicle(Vehicle vehicle) throws VehicleException;
    Vehicle getVehicleByNumber(String vehicleNumber) throws VehicleException;
    List<Vehicle> getAllVehicles() throws VehicleException;
    String removeVehicle(String vehicleNumber) throws VehicleException;
}
