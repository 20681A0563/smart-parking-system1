package com.remotehiring.Repositories;

import com.remotehiring.entities.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Integer> {

	@Query("Select b from Bookings b where email = ?1")
	List<Bookings> listByUsers(String email);

	@Modifying
	@Transactional
	@Query("Update Bookings b set b.paid = 1 where b.bookingid = ?1")
	int endBooking(Integer bookingid);
}
