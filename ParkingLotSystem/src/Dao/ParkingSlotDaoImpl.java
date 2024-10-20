package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Exception.ParkingSlotException;
import Model.ParkingSlot;

import Utility.ConnectionFactory;
import Utility.ParkingSlotQuery;

public class ParkingSlotDaoImpl implements ParkingSlotDao {
	ParkingSlotQuery query = new ParkingSlotQuery();

	public String addSlots(int numberOfSlots) throws ParkingSlotException {
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query.insertSlot())) {

            // Get the current highest slot_id from the table
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query.getLastSlotId());
            int lastSlotId = 0;
            if (rs.next()) {
                lastSlotId = rs.getInt(1);
            }

            // Add new slots starting from the next slot_id
            for (int i = 1; i <= numberOfSlots; i++) {
                ps.setInt(1, ++lastSlotId);  // Increment slot_id for each new slot
                ps.setBoolean(2, true);      // All new slots are initially available
                ps.addBatch();
            }

            ps.executeBatch();  // Execute the batch insert
            return numberOfSlots + " parking slots added successfully.";

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ParkingSlotException("Error adding new parking slots.");
        }
    }
	
	public List<ParkingSlot> getAvailableSlots() throws ParkingSlotException {
        List<ParkingSlot> slots = new ArrayList<>();
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(query.getAvailableSlots())) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ParkingSlot slot = new ParkingSlot();
                slot.setId(rs.getInt("id"));
                slot.setAvailable(rs.getBoolean("is_available"));
                slots.add(slot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ParkingSlotException("Error retrieving available slots");
        }
        return slots;
    }
	
	public String releaseSlotById(int slotId) throws ParkingSlotException {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            // Step 1: Check if the slot exists and if it is occupied
            PreparedStatement checkSlotPs = con.prepareStatement(query.checkSlotAvailability());
            checkSlotPs.setInt(1, slotId);
            ResultSet rs = checkSlotPs.executeQuery();
            if (rs.next()) {
                boolean isAvailable = rs.getBoolean("is_Available");
                if (isAvailable) {
                    return "Parking slot is already available!";
                }
            } else {
                return "Parking slot does not exist!";
            }

            // Step 2: Release the slot by updating its availability
            PreparedStatement releaseSlotPs = con.prepareStatement(query.releaseSlotById());
            releaseSlotPs.setBoolean(1, true);  // Mark as available
            releaseSlotPs.setInt(2, slotId);     // Set the slot ID
            int result = releaseSlotPs.executeUpdate();
            if (result > 0) {
                return "Parking slot released successfully!";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ParkingSlotException("Error releasing parking slot.");
        }
        return null;
    }

	
	public String assignSlot(int slotId, String vehicleNumber) throws ParkingSlotException {
	    try (Connection con = ConnectionFactory.getInstance().getConnection()) {
	        // Step 1: Check if the slot is available
	        PreparedStatement checkAvailabilityPs = con.prepareStatement(query.checkSlotAvailability());
	        checkAvailabilityPs.setInt(1, slotId);
	        ResultSet rs = checkAvailabilityPs.executeQuery();
	        if (rs.next()) {
	            boolean isAvailable = rs.getBoolean("is_Available");
	            if (!isAvailable) {
	                return "Parking slot is already assigned!";
	            }
	        } else {
	            return "Parking slot does not exist!";
	        }

	        // Step 2: Check if the vehicle exists
	        PreparedStatement checkVehiclePs = con.prepareStatement(query.getVehicleByNumber());
	        checkVehiclePs.setString(1, vehicleNumber);
	        ResultSet vehicleRs = checkVehiclePs.executeQuery();
	        if (!vehicleRs.next()) {
	            return "Vehicle does not exist!";
	        }

	        // Step 3: Assign the slot if it is available
	        PreparedStatement assignSlotPs = con.prepareStatement(query.assignSlot());
	        assignSlotPs.setInt(1, slotId);           // Set slot ID
	        assignSlotPs.setString(2, vehicleNumber);  // Set vehicle number
	        assignSlotPs.setBoolean(3, false);         // Mark as not available
	        int x = assignSlotPs.executeUpdate();
	        if (x > 0) {
	            return "Parking slot assigned to vehicle successfully!";
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new ParkingSlotException("Error assigning parking slot.");
	    }
	    return null;
	}

	public String releaseSlot(int slotId, String vehicleNumber) throws ParkingSlotException {
	    try (Connection con = ConnectionFactory.getInstance().getConnection()) {
	        // Step 1: Check if the slot is occupied by the given vehicle
	        PreparedStatement checkSlotPs = con.prepareStatement(query.checkSlotByVehicle());
	        checkSlotPs.setInt(1, slotId);
	        checkSlotPs.setString(2, vehicleNumber);
	        ResultSet rs = checkSlotPs.executeQuery();
	        if (rs.next()) {
	            boolean isAvailable = rs.getBoolean("is_Available");
	            if (isAvailable) {
	                return "Parking slot is already available!";
	            }
	        } else {
	            return "Parking slot or vehicle does not exist!";
	        }

	        // Step 2: Release the slot and make it available
	        PreparedStatement releaseSlotPs = con.prepareStatement(query.releaseSlot());
	        releaseSlotPs.setInt(1, slotId);  // Set slot ID
	        releaseSlotPs.setBoolean(2, true);  // Mark as available
	        int x = releaseSlotPs.executeUpdate();
	        if (x > 0) {
	            return "Parking slot released from vehicle successfully!";
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new ParkingSlotException("Error releasing parking slot.");
	    }
	    return null;
	}

	


	
	
}

