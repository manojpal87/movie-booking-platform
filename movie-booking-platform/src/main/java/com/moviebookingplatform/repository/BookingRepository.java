package com.moviebookingplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviebookingplatform.entity.Booking;

/**
 * Repo to handle booking crud operations
 * 
 * @author manojpal
 *
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
