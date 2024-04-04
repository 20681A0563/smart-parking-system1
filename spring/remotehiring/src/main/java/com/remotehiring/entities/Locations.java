package com.remotehiring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
public class Locations {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer locationid;

	@NotBlank(message = "Location name cannot be blank")
	private String location_name;

	@NotNull(message = "Slots cannot be null")
	@PositiveOrZero(message = "Slots must be a positive number or zero")
	private Integer slots = 0;

	@NotBlank(message = "Area cannot be blank")
	private String area;

	public Locations() {
	}

	public Locations(Integer locationid, String location_name, Integer slots, String area) {
		this.locationid = locationid;
		this.location_name = location_name;
		this.slots = slots;
		this.area = area;
	}

	public Integer getLocationid() {
		return locationid;
	}

	public void setLocationid(Integer locationid) {
		this.locationid = locationid;
	}

	public String getLocation_name() {
		return location_name;
	}

	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}

	public Integer getSlots() {
		return slots;
	}

	public void setSlots(Integer slots) {
		this.slots = slots;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
}
