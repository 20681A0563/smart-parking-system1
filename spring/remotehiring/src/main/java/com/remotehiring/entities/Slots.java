package com.remotehiring.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity
public class Slots {

	@Id
	private String slotid;

	@NotNull(message = "Location ID cannot be null")
	private Integer locationid;

	@NotBlank(message = "Slot number cannot be blank")
	private String slotno;

	@NotNull(message = "Status cannot be null")
	@PositiveOrZero(message = "Status must be a positive number or zero")
	private Integer status = 0;

	@NotBlank(message = "Time cannot be blank")
	private String time = "0";

	@NotNull(message = "Duration cannot be null")
	@PositiveOrZero(message = "Duration must be a positive number or zero")
	private Integer duration = 0;

	public Slots() {
	}

	public Slots(String slotid, Integer locationid, String slotno, Integer status, String time, Integer duration) {
		this.slotid = slotid;
		this.locationid = locationid;
		this.slotno = slotno;
		this.status = status;
		this.time = time;
		this.duration = duration;
	}

	public String getSlotid() {
		return slotid;
	}

	public void setSlotid(String slotid) {
		this.slotid = slotid;
	}

	public Integer getLocationid() {
		return locationid;
	}

	public void setLocationid(Integer locationid) {
		this.locationid = locationid;
	}

	public String getSlotno() {
		return slotno;
	}

	public void setSlotno(String slotno) {
		this.slotno = slotno;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
}
