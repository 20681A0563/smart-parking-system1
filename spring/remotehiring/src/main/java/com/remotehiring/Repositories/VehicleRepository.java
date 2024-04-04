package com.remotehiring.Repositories;

import com.remotehiring.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository; // Import Repository annotation

@Repository // Add Repository annotation
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{

	@Query("Select cost from Vehicle where vehicle_type = ?1")
	String getVechileCost(String vehicle_type);
}
