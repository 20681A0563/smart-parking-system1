package com.remotehiring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

@Entity
public class Bookings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingid;

	@NotBlank(message = "Email cannot be blank")
	private String email;

	@NotBlank(message = "Vehicle type cannot be blank")
	private String vehicle_type;

	@NotBlank(message = "Vehicle number cannot be blank")
	private String vehicle_no;

	@NotBlank(message = "Date cannot be blank")
	private String date;

	@NotBlank(message = "Time cannot be blank")
	private String time;

	@NotNull(message = "Duration cannot be null")
	@PositiveOrZero(message = "Duration must be a positive number or zero")
	private Integer duration;

	private String cost = "0";

	@NotNull(message = "Location ID cannot be null")
	private Integer locationid;

	@NotBlank(message = "Slot ID cannot be blank")
	private String slotid;

	@NotNull(message = "Paid status cannot be null")
	@PositiveOrZero(message = "Paid status must be a positive number or zero")
	private Integer paid = 0;

	public Bookings() {

	}

	public Integer getBookingid() {
		return bookingid;
	}

	public void setBookingid(Integer bookingid) {
		this.bookingid = bookingid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public String getVehicle_no() {
		return vehicle_no;
	}

	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public Integer getLocationid() {
		return locationid;
	}

	public void setLocationid(Integer locationid) {
		this.locationid = locationid;
	}

	public Integer getPaid() {
		return paid;
	}

	public void setPaid(Integer paid) {
		this.paid = paid;
	}

	public String getSlotid() {
		return slotid;
	}

	public void setSlotid(String slotid) {
		this.slotid = slotid;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
