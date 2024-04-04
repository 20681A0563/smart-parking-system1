package com.remotehiring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vehicleid;

	@NotBlank(message = "Vehicle type cannot be blank")
	private String vehicle_type;

	@NotBlank(message = "Cost cannot be blank")
	@Pattern(regexp = "\\d+(\\.\\d{1,2})?", message = "Invalid cost format")
	private String cost;

	public Vehicle() {
	}

	public Vehicle(Integer vehicleid, String vehicle_type, String cost) {
		this.vehicleid = vehicleid;
		this.vehicle_type = vehicle_type;
		this.cost = cost;
	}

	public Integer getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(Integer vehicleid) {
		this.vehicleid = vehicleid;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}
}
