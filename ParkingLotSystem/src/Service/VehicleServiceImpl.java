package Service;

import java.util.List;

import Dao.VehicleDao;
import Dao.VehicleDaoImpl;
import Exception.VehicleException;
import Model.Vehicle;

public class VehicleServiceImpl implements VehicleService {
    private final VehicleDao dao;

    public VehicleServiceImpl() {
        this.dao = new VehicleDaoImpl();
    }

    @Override
    public String addVehicle(Vehicle vehicle) throws VehicleException {
    	return dao.addVehicle(vehicle);
    }

    @Override
    public Vehicle getVehicleByNumber(String vehicleNumber) throws VehicleException {
        return dao.getVehicleByNumber(vehicleNumber);
    }

    @Override
    public String removeVehicle(String vehicleNumber) throws VehicleException {
    	return dao.removeVehicle(vehicleNumber);
    }

	@Override
	public List<Vehicle> getAllVehicles() throws VehicleException {
		
		return dao.getAllVehicles();
	}
}

