package Service;

import java.util.List;

import Dao.ParkingSlotDao;
import Dao.ParkingSlotDaoImpl;
import Exception.ParkingSlotException;
import Model.ParkingSlot;

public class ParkingSlotServiceImpl implements ParkingSlotService {
    private final ParkingSlotDao dao;

    public ParkingSlotServiceImpl() {
        this.dao = new ParkingSlotDaoImpl();
    }
    
    public String addSlots(int numberOfSlots) throws ParkingSlotException {
        return dao.addSlots(numberOfSlots);
    }

    
    public List<ParkingSlot> getAvailableSlots() throws ParkingSlotException {
        return dao.getAvailableSlots();
    }
    
   
	public String releaseSlotById(int slotId) throws ParkingSlotException {
		return dao.releaseSlotById(slotId);
	}

    
    public String assignSlot(int slotId, String vehicleNumber) throws ParkingSlotException {
    	return dao.assignSlot(slotId, vehicleNumber);
    }

   
    public String releaseSlot(int slotId , String vehicleNumber) throws ParkingSlotException {
    	return dao.releaseSlot(slotId, vehicleNumber);
    }

	
}
