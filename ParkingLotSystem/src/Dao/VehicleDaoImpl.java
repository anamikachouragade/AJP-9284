package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exception.VehicleException;
import Model.Vehicle;
import Utility.ConnectionFactory;
import Utility.VehicleQuery;

public class VehicleDaoImpl implements VehicleDao {
	 private VehicleQuery query = new VehicleQuery();

	    @Override
	    public String addVehicle(Vehicle vehicle) throws VehicleException {
	        try (Connection con = ConnectionFactory.getInstance().getConnection();
	             PreparedStatement ps = con.prepareStatement(query.addVehicle())) {
	            ps.setString(1, vehicle.getVehicleNumber());
	            ps.setString(2, vehicle.getType());
	            ps.setInt(3, vehicle.getCustomerId());
	            int x = ps.executeUpdate();
	            if (x > 0) {
	                return "Vehicle added successfully!";
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    @Override
	    public Vehicle getVehicleByNumber(String vehicleNumber) throws VehicleException {
	        try (Connection con = ConnectionFactory.getInstance().getConnection();
	             PreparedStatement ps = con.prepareStatement(query.getVehicleByNumber())) {
	            ps.setString(1, vehicleNumber);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                Vehicle vehicle = new Vehicle();
	                vehicle.setVehicleNumber(rs.getString("vehicleNumber"));
	                vehicle.setType(rs.getString("type"));
	                vehicle.setCustomerId(rs.getInt("customerId"));
	                return vehicle;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    @Override
	    public List<Vehicle> getAllVehicles() throws VehicleException {
	        List<Vehicle> vehicles = new ArrayList<>();
	        try (Connection con = ConnectionFactory.getInstance().getConnection();
	             PreparedStatement ps = con.prepareStatement(query.getAllVehicles())) {
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                Vehicle vehicle = new Vehicle();
	                vehicle.setVehicleNumber(rs.getString("vehicleNumber"));
	                vehicle.setType(rs.getString("type"));
	                vehicle.setCustomerId(rs.getInt("customerId"));
	                vehicles.add(vehicle);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return vehicles;
	    }

	    @Override
	    public String removeVehicle(String vehicleNumber) throws VehicleException {
	        try (Connection con = ConnectionFactory.getInstance().getConnection();
	             PreparedStatement ps = con.prepareStatement(query.removeVehicle())) {
	            ps.setString(1, vehicleNumber);
	            int x = ps.executeUpdate();
	            if (x > 0) {
	                return "Vehicle removed successfully!";
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
}

