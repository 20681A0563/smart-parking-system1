package com.remotehiring.Controller;

import java.util.List;
import com.remotehiring.entities.Vehicle;
import com.remotehiring.Services.VehicleService;
import com.remotehiring.exceptions.VehicleNotFoundException; // Import the custom exception
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ExceptionHandler; // Import exception handler
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus; // Import response status

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class VehicleController {

	@Autowired
	private VehicleService service;

	@GetMapping("/vehicle")
	public List<Vehicle> list() {
		return service.listAll();
	}

	@PostMapping("/vehicle/add")
	public ResponseEntity<Vehicle> add(@RequestBody Vehicle vehicle) {
		return new ResponseEntity<Vehicle>(service.add(vehicle), HttpStatus.OK);
	}

	@ExceptionHandler(VehicleNotFoundException.class) // Handle VehicleNotFoundException
	@ResponseStatus(HttpStatus.NOT_FOUND) // Set response status to 404
	public String handleVehicleNotFoundException(VehicleNotFoundException ex) {
		return ex.getMessage();
	}
}

