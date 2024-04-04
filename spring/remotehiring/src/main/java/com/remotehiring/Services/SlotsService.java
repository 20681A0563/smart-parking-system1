package com.remotehiring.Services;

import java.util.List;

import com.remotehiring.entities.Bookings;
import com.remotehiring.entities.Slots;
import com.remotehiring.Repositories.SlotsRepository;
import com.remotehiring.exceptions.SlotNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlotsService {

	@Autowired
	private SlotsRepository repo;

	// Other methods

	public List<Slots> listAll() {
		return repo.findAll();
	}

	public boolean add(Slots slot) {
		if (repo.existsById(slot.getSlotid())) {
			return false; // Slot already exists
		} else {
			repo.save(slot);
			return true; // Slot added successfully
		}
	}

	public List<Slots> slotById(Integer locationid) {
		return repo.slotById(locationid);
	}

	public void updateSlot(Bookings booking) {
		int rowsAffected = repo.updateSlot(1, booking.getTime(), booking.getDuration(), booking.getSlotid());
		if (rowsAffected == 0) {
			throw new SlotNotFoundException("Slot with ID " + booking.getSlotid() + " not found");
		}
	}

	public void rollbackSlot(String slotid) {
		int rowsAffected = repo.rollbackSlot(slotid);
		if (rowsAffected == 0) {
			throw new SlotNotFoundException("Slot with ID " + slotid + " not found");
		}
	}
}
