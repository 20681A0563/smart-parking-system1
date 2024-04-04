package com.remotehiring.Services;

import java.util.List;
import com.remotehiring.entities.Vehicle;
import com.remotehiring.Repositories.VehicleRepository;
import com.remotehiring.exceptions.VehicleNotFoundException; // Import the custom exception
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository repo;

	public List<Vehicle> listAll() {

		return repo.findAll();
	}

	public Vehicle add(Vehicle vehicle) {

		return repo.save(vehicle);
	}

	public int getVehicleCost(String vehicle_type) {
		String cost = repo.getVechileCost(vehicle_type);
		if (cost == null) {
			throw new VehicleNotFoundException("Vehicle type not found: " + vehicle_type);
		}
		return Integer.parseInt(cost);
	}
}
